package com.example.firstproject.service;

import com.example.firstproject.DTO.ChatRequest;
import com.example.firstproject.DTO.ChatResponse;
import com.example.firstproject.model.Userinfo;
import com.example.firstproject.repository.UserInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class ChatService {
    private final WebClient webClient;
    private final UserInfoRepository userInfoRepository;

    public ChatService(WebClient.Builder webClientBuilder,UserInfoRepository userInfoRepository) {
        this.webClient = webClientBuilder
                .baseUrl("https://32d6-34-59-30-91.ngrok-free.app/") // FastAPI Public URL
                .build();
        this.userInfoRepository = userInfoRepository;
    }

    public ChatResponse getAnswer(String content, String userId)  {
        Userinfo userInfo = userInfoRepository.findByUserId(userId);
        if (userInfo == null) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        Map<String, Object> payload = Map.of(
                "content", content,
                "user_id", userInfo.getUserId(),
                "start_date", userInfo.getStartDate().toString(), // LocalDate를 String으로 변환
                "step", userInfo.getStep(),
                "day", userInfo.getDay()
        );
        try {
            // WebClient를 통해 Python 서버로 요청
            ChatResponse response = webClient.post()
                    .uri("/api/ai")
                    .bodyValue(payload)
                    .retrieve()
                    .bodyToMono(ChatResponse.class)
                    .block();

            // 응답 로그 출력
            System.out.println("Python 서버 응답: " + response);
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Python 서버 호출 중 오류 발생: " + e.getMessage(), e);
        }
    }
}
