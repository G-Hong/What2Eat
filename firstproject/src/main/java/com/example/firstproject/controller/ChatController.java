package com.example.firstproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.*;

@Controller
public class ChatController {

    @PostMapping("user/chatbot")
    public String chat(@RequestParam String message, Model model){

        String answer = "thank you";   //인공지능 파트 호출해서 답변 얻기
        model.addAttribute("answer", answer);

        //프론트에 호출(redirect, fowarding?)
        return "chat.mustache";
    }
}
