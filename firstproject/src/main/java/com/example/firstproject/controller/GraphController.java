package com.example.firstproject.controller;

import com.example.firstproject.model.Graph;
import com.example.firstproject.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class GraphController {

    private final GraphService graphService;

    // 생성자 주입을 사용하여 의존성 주입
    @Autowired
    public GraphController(GraphService graphService) {
        this.graphService = graphService;
    }

    // 그래프 기록 추가
    @PostMapping("/set/record")
    public ResponseEntity<List<Graph>> addGraphRecord(@RequestBody Graph graph) {
        graphService.addGraphRecord(graph);
        List<Graph> userRecords = graphService.getAllUserRecords(graph.getUser().getUserId());
        return new ResponseEntity<>(userRecords, HttpStatus.CREATED);
    }

    // 사용자 ID로 모든 그래프 기록 조회
    @GetMapping("/modify/me/{userId}")
    public ResponseEntity<List<Graph>> getAllUserRecords(@PathVariable String userId) {
        System.out.println("Received request for userId: " + userId);
        List<Graph> records = graphService.getAllUserRecords(userId);
        if (records == null || records.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 그래프 기록이 없을 때 404 반환
        }
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    // 그래프 기록 수정
    @PutMapping("/modify/record/{id}")
    public ResponseEntity<Map<String, String>> updateGraphRecord(@PathVariable Integer id, @RequestBody Graph updatedGraph) {
        graphService.updateGraphRecord(id, updatedGraph);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User record updated successfully.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
