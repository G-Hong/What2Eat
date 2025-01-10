package com.example.firstproject.controller;

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

    @PostMapping("/api/user/set-startDate")
    public Map<String, String> setStartDate(@RequestBody Map<String, Object> requestData) {

        String userId = requestData.get("id").toString();
        LocalDate startDate = LocalDate.parse(requestData.get("date").toString());  // 프론트에서 전달된 "date"를 LocalDate로 파싱

        //시작일 등록
        String updateStartDateId = userService.setStartDate(userId, startDate);
        Map<String, String> response = new HashMap<>();
        response.put("setStartId", updateStartDateId);

        return response;
    }
}
