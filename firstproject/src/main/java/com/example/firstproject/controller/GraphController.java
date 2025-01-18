package com.example.firstproject.controller;

import com.example.firstproject.model.Graph;
import com.example.firstproject.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/user")
public class GraphController {
    @Autowired
    private GraphService graphService;

    /*@GetMapping("/set/goal")
    public Graph getUserGoal(@RequestParam String userId) {
        return graphService.getUserGoal(userId);
    }*/

    @PostMapping("/set/record")
//    public Graph addGraphRecord(@RequestBody Graph graph) {
//        graphService.addGraphRecord(graph);
//        return graphService.getAllUserRecords()
//    }

    @GetMapping("/user/modify/me")
    public List<Graph> getAllUserRecords(@RequestParam String userId) {
        return graphService.getAllUserRecords(userId);
    }

    @PutMapping("/user/modify/record/{id}")
    public String updateGraphRecord(@PathVariable Integer id, @RequestBody Graph updatedGraph) {
        graphService.updateGraphRecord(id, updatedGraph);
        return "{\"message\": \"User record updated successfully.\"}";
    }
}
