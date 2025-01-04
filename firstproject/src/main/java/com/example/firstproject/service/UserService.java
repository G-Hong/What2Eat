package com.example.firstproject.service;

import com.example.firstproject.model.Userinfo;
import com.example.firstproject.repository.UserInfoRepository;
import com.example.firstproject.repository.UserlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserlistRepository userlistRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    public boolean existsByUserId(String userId){
        return userlistRepository.existsByUserId(userId);
    }

    public Userinfo setStartDate(Userinfo userinfo) {
        return userInfoRepository.save(userinfo);
    }
}
