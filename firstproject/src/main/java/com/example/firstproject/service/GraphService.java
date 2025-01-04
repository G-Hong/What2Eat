package com.example.firstproject.service;

import com.example.firstproject.repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphService {

    @Autowired
    private GraphRepository graphRepository;

}
