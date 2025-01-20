package com.example.firstproject.controller;

import com.example.firstproject.model.Userinfo;
import com.example.firstproject.model.Userlist;
import com.example.firstproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SignUpController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody Map<String, String> requestData) {
        String userId = requestData.get("userId");
        String password = requestData.get("password");
        String goalKg = requestData.get("goal");
        String startDate = requestData.get("startDate");

        LocalDate localDate = LocalDate.parse(startDate);
        Float goal = Float.parseFloat(goalKg);

        Map<String, String> response = new HashMap<>();
        try {
            Userlist newUser = new Userlist();
            Userinfo newUserinfo = new Userinfo();

            newUser.setUserId(userId);
            newUser.setPasswd(password);

            newUserinfo.setUserlist(newUser);
            newUserinfo.setStartDate(localDate);
            newUserinfo.setGoal(goal);

            if (userService.checkUserId(userId)) {
                userService.createUserInfo(newUserinfo);

                response.put("message", "회원가입 완료");
                response.put("success", "true");

                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }
        } catch (Exception e) {
            // 오류 발생 시 400 Bad Request
            response.put("message", e.getMessage());
            response.put("success", "false");
        }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}