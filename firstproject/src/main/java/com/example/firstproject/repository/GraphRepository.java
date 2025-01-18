package com.example.firstproject.repository;

import com.example.firstproject.model.Graph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GraphRepository extends JpaRepository<Graph, Integer> {
    //List<Graph> findByUserId(String userId);
    List<Graph> findAllByUser_UserIdOrderByDateAsc(String userId);
    List<Graph> findByUser_UserId(String userId);

}
