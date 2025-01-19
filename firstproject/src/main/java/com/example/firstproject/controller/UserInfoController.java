package com.example.firstproject.controller;

import com.example.firstproject.model.Graph;
import com.example.firstproject.model.Userinfo;
import com.example.firstproject.service.GraphService;
import com.example.firstproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
public class UserInfoController {
    @Autowired
    GraphService graphService;
    @Autowired
    UserService userService;

    @GetMapping("/user/mypage/user-record/{id}")
    public Userinfo UserInfo(@PathVariable String id){
        return userService.getUserInfo(id);
    }
    @GetMapping("/user/mypage/graph-records/{id}")
    public List<Graph> UserGraph(@PathVariable String id){
        return graphService.getAllUserRecords(id);
    }
}
