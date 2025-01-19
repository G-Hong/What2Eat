package com.example.firstproject.controller;

import com.example.firstproject.model.Graph;
import com.example.firstproject.model.Userinfo;
import com.example.firstproject.service.GraphService;
import com.example.firstproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    private final GraphService graphService;
    private final UserService userService;

    @Autowired
    public UserInfoController(GraphService graphService, UserService userService) {
        this.graphService = graphService;
        this.userService = userService;
    }

    @GetMapping("/user/mypage/user-record/{id}")
    public ResponseEntity<Userinfo> getUserInfo(@PathVariable String id) {
        Userinfo userinfo = userService.getUserInfo(id);
        if (userinfo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(userinfo);
    }

    @GetMapping("/user/mypage/graph-records/{id}")
    public ResponseEntity<List<Graph>> getUserGraphRecords(@PathVariable String id) {
        List<Graph> graphRecords = graphService.getAllUserRecords(id);
        if (graphRecords == null || graphRecords.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(graphRecords);
    }
}
