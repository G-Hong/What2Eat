package com.example.firstproject.repository;

import com.example.firstproject.model.Graph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GraphRepository extends JpaRepository<Graph, Integer> {
    //List<Graph> findByUserId(String userId);
    Optional<Graph> findTopByUser_UserIdOrderByDateDesc(String userId);
    List<Graph> findByUser_UserId(String userId);

}
