package com.example.firstproject.controller;


import com.example.firstproject.DTO.ChatResponse;
import com.example.firstproject.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody Map<String, Object> payload) {
        String content = (String) payload.get("content"); // content 추출
        String userId = (String) payload.get("user_id"); // user_id 추출

        // payload를 그대로 Service로 전달
        ChatResponse response = chatService.getAnswer(content, userId);

        // 응답 반환
        return ResponseEntity.ok(response);
    }
}