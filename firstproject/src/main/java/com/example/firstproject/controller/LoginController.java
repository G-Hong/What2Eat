package com.example.firstproject.controller;

import com.example.firstproject.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/login")
    public Map<String, Object> login(@RequestBody Map<String, String> requestData) {
        String id = requestData.get("id"); // JSON 데이터에서 "id" 추출
        Boolean exist = userService.existsByUserId(id);

        Map<String, Object> response = new HashMap<>();
        response.put("success", exist);

        if (!exist) {
            response.put("errorMessage", "일치하는 아이디가 존재하지 않습니다.");
        }
        return response;
    }
}
