package com.example.firstproject.controller;

import com.example.firstproject.model.Graph;
import com.example.firstproject.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5175")
@RequestMapping("/user")
public class GraphController {
    @Autowired
    private GraphService graphService;

    @PostMapping("/set/record")
    public List<Graph> addGraphRecord(@RequestBody Graph graph) {
        graphService.addGraphRecord(graph);
        return graphService.getAllUserRecords(graph.getUser().getUserId());
    }

    @GetMapping("/modify/me")
    public List<Graph> getAllUserRecords(@RequestParam String userId) {
        System.out.println("Received request for userId: " + userId);
        return graphService.getAllUserRecords(userId);
    }

    @PutMapping("/modify/record/{id}")
    public String updateGraphRecord(@PathVariable Integer id, @RequestBody Graph updatedGraph) {
        graphService.updateGraphRecord(id, updatedGraph);
        return "{\"message\": \"User record updated successfully.\"}";
    }
}
