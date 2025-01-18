package com.example.firstproject.controller;

import com.example.firstproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5175")
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

        if (id == null || id.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "아이디와 비밀번호는 필수 입력 값입니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        String loginMessage = userService.existsUser(id, password);

        if ("login success".equals(loginMessage)) {
            Map<String, Object> response = new HashMap<>();

            response.put("login", "success");
            return ResponseEntity.ok(response); // 200 OK
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("error", loginMessage);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // 401 Unauthorized
        }
    }

}
