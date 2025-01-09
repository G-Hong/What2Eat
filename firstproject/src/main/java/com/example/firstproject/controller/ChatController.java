package com.example.firstproject.controller;


import com.example.firstproject.DTO.ChatResponse;
import com.example.firstproject.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody String question) {
        ChatResponse response = chatService.getAnswer(question);
        return ResponseEntity.ok(response);
    }
}
