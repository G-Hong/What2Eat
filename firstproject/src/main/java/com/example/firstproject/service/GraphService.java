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


    /*public Graph getUserGoal(String userId) {
        return graphRepository.findTopByUser_UserIdOrderByDateDesc(userId)
                .orElseThrow(() -> new RuntimeException("User goal not found for userId: " + userId));
    }*/

    public Graph addGraphRecord(Graph graph) {
        // 1. user 필드와 userId 검증
        if (graph.getUser() == null || graph.getUser().getUserId() == null) {
            throw new IllegalArgumentException("User information is required to save the record.");
        }

        // 2. user_id가 userlist 테이블에 존재하는지 확인
        String userId = graph.getUser().getUserId(); // userId는 String 타입으로 처리
        if (!userlistRepository.existsById(userId)) {
            throw new IllegalArgumentException("User with userId '" + userId + "' does not exist.");
        }

        // 3. 데이터 저장
        return graphRepository.save(graph);
    }

    public List<Graph> getAllUserRecords(String userId) {
        return graphRepository.findByUser_UserId(userId);
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
