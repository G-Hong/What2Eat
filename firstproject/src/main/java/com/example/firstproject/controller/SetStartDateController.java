package com.example.firstproject.controller;

import com.example.firstproject.model.Graph;
import com.example.firstproject.model.Userlist;
import com.example.firstproject.service.GraphService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@RestController
public class SetStartDateController {

    private GraphService graphService;

    public SetStartDateController(GraphService graphService) {
        this.graphService = graphService;
    }

    @PostMapping("/api/user/SetStart-date")
    public void setStartDate(@RequestBody Map<String, Object> requestData) {

        String userId = requestData.get("id").toString();
        LocalDate startDate = LocalDate.parse(requestData.get("date").toString());  // 프론트에서 전달된 "date"를 LocalDate로 파싱

        Graph newGraph = new Graph();

        Userlist userlist = new Userlist();
        userlist.setUserId(userId);

        newGraph.setUser(userlist);
        newGraph.setDate(startDate);

        graphService.setStartDate(newGraph);

    }
}
