package com.example.firstproject.controller;

import com.example.firstproject.model.Graph;
import com.example.firstproject.model.Userinfo;
import com.example.firstproject.service.GraphService;
import com.example.firstproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {
    @Autowired
    GraphService graphService;
    @Autowired
    UserService userService;

    @GetMapping("/user/main/state")
    public Userinfo UserInfo(@RequestParam String id){
        return userService.getUserInfo(id);
    }
    @GetMapping("/user/main/graph")
    public List<Graph> UserGraph(@RequestParam String id){
        return graphService.getAllUserRecords(id);
    }
}
