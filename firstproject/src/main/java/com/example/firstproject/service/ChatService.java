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
                .baseUrl("https://4288-34-143-133-250.ngrok-free.app") // FastAPI Public URL
                .build();
    }

    public ChatResponse getAnswer(String question) {
        try {
            return webClient.post()
                    .uri("/api/v1/chat") // FastAPI에서 질문 처리 엔드포인트
                    .bodyValue(new ChatRequest(question))
                    .retrieve()
                    .bodyToMono(ChatResponse.class)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException("AI API 호출 중 오류 발생: " + e.getMessage());
        }
    }
}
