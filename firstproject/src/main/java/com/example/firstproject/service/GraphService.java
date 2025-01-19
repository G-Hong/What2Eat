package com.example.firstproject.service;

import com.example.firstproject.model.Graph;
import com.example.firstproject.repository.GraphRepository;
import com.example.firstproject.repository.UserlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphService {

    @Autowired
    private GraphRepository graphRepository;

    @Autowired
    private UserlistRepository userlistRepository; // Userlist 검증을 위해 추가

    public Graph addGraphRecord(Graph graph) {
        if (graph.getUser() == null || graph.getUser().getUserId() == null) {
            throw new IllegalArgumentException("User information is required to save the record.");
        }
        String userId = graph.getUser().getUserId();
        if (!userlistRepository.existsById(userId)) {
            throw new IllegalArgumentException("User with userId '" + userId + "' does not exist.");
        }
        return graphRepository.save(graph);
    }

    public List<Graph> getAllUserRecords(String userId) {
        if (!userlistRepository.existsById(userId)) {
            throw new IllegalArgumentException("User with userId '" + userId + "' does not exist.");
        }
        return graphRepository.findAllByUser_UserIdOrderByDateAsc(userId);
    }

    public Graph updateGraphRecord(Integer id, Graph updatedGraph) {
        Graph existingGraph = graphRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found for id: " + id));
        existingGraph.setDate(updatedGraph.getDate());
        existingGraph.setWeight(updatedGraph.getWeight());
        existingGraph.setBodyMass(updatedGraph.getBodyMass());
        existingGraph.setMuscleMass(updatedGraph.getMuscleMass());
        return graphRepository.save(existingGraph);
    }
}
