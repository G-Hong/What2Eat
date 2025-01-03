package com.example.firstproject.repository;

import com.example.firstproject.model.Graph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphRepository extends JpaRepository<Graph, Integer> {

}
