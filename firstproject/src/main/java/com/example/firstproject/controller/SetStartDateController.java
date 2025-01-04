package com.example.firstproject.controller;

import com.example.firstproject.model.Userinfo;
import com.example.firstproject.model.Userlist;
import com.example.firstproject.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SetStartDateController {

    private UserService userService;

    public SetStartDateController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user/SetStart-date")
    public Map<String, String> setStartDate(@RequestBody Map<String, Object> requestData) {

        String userId = requestData.get("id").toString();
        LocalDate startDate = LocalDate.parse(requestData.get("date").toString());  // 프론트에서 전달된 "date"를 LocalDate로 파싱

        //시작일은 처음 한번만 설정 가능
        Userlist userlist = new Userlist();
        Userinfo newUserInfo = new Userinfo();

        userlist.setUserId(userId);
        newUserInfo.setUserlist(userlist);
        newUserInfo.setStartDate(startDate);

        String insertId = userService.setStartDate(newUserInfo).getUserlist().getUserId();
        Map<String, String> response = new HashMap<>();
        response.put("setStartId", insertId);
        return response;
    }
}
