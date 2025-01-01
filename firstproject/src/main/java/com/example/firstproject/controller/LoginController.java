package com.example.firstproject.controller;

import com.example.firstproject.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private UserService userService;

    @PostMapping("/api/login")
    public String login(@RequestParam("id") String id, Model model) {
        Boolean exist = userService.existsById(id);

        if (exist) {
            // 아이디가 존재하면 메인 페이지로 이동
            return "redirect:/mainPage";
        } else {
            // 아이디가 존재하지 않으면 로그인 페이지 유지 및 에러 메시지 추가
            model.addAttribute("errorMessage", "일치하는 아이디가 존재하지 않습니다.");
            return "login"; // 현재 로그인 페이지 렌더링
        }
    }
}
