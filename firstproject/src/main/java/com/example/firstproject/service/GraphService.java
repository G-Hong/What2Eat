package com.example.firstproject.service;

import com.example.firstproject.model.Graph;
import com.example.firstproject.repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphService {

    @Autowired
    private GraphRepository graphRepository;

    public boolean setStartDate(Graph graph) {
        graphRepository.save(graph);
        return true;
    }
}
