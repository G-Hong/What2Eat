package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ChatController {

    @PostMapping("/api/user/chatbot")
    public Map<String, Object> chat(@RequestBody Map<String, String> requestData){

        String message = requestData.get("message");
        Object answer = "thank you";   //인공지능 파트 호출해서 답변 얻기

        Map<String, Object> response = new HashMap<>();
        response.put("success", answer);

        return response;
    }
}
