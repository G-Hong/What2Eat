package com.example.firstproject.service;

import com.example.firstproject.DTO.ChatRequest;
import com.example.firstproject.DTO.ChatResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ChatService {
    private final WebClient webClient;

    public ChatService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://8deb-34-16-195-195.ngrok-free.app/") // FastAPI Public URL
                .build();
    }

    public ChatResponse getAnswer(String content) {
        ChatRequest request = new ChatRequest(content);

        try {
            // WebClient를 통해 Python 서버로 요청
            ChatResponse response = webClient.post()
                    .uri("/api/ai")
                    .bodyValue(request)
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
