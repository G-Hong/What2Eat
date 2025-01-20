package com.example.firstproject.controller;

import com.example.firstproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> requestData) {
        String id = requestData.get("id");
        String password = requestData.get("password");

        String loginMessage = userService.existsUser(id, password);
        Map<String, Object> response = new HashMap<>();

        if ("login success".equals(loginMessage)) {
            // UUID를 세션 토큰으로 사용
            String sessionToken = UUID.randomUUID().toString();

            response.put("login", "success");
            response.put("sessionToken", sessionToken); // 생성된 UUID 토큰 반환
            return ResponseEntity.ok(response); // 200 OK
        } else {
            response.put("error", loginMessage);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // 401 Unauthorized
        }
    }
}
