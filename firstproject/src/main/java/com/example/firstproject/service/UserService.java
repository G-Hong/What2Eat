package com.example.firstproject.service;

import com.example.firstproject.repository.UserlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserlistRepository userlistRepository;

    public boolean existsById(String id){
        return userlistRepository.existsById(id);
    }
}
