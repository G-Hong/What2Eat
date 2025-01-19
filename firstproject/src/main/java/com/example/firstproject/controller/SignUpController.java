package com.example.firstproject.controller;

import com.example.firstproject.model.Userinfo;
import com.example.firstproject.model.Userlist;
import com.example.firstproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
public class SignUpController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(
            @RequestParam String userId,
            @RequestParam String password,
            @RequestParam String startDate) {
        try {
            Userlist newUser = new Userlist();
            Userinfo newUserinfo = new Userinfo();

            newUser.setUserId(userId);
            newUser.setPasswd(password);

            LocalDate localStartDate = LocalDate.parse(startDate);
            newUserinfo.setUserlist(newUser);
            newUserinfo.setStartDate(localStartDate);

            userService.createUserlist(newUser);
            userService.createUserInfo(newUserinfo);

            return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 완료");
        } catch (Exception e) {
            // 오류 발생 시 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
}
