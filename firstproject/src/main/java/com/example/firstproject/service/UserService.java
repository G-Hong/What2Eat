package com.example.firstproject.service;

import com.example.firstproject.model.Userinfo;
import com.example.firstproject.repository.UserInfoRepository;
import com.example.firstproject.repository.UserlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    @Autowired
    private UserlistRepository userlistRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    //로그인
    public boolean existsByUserId(String userId){
        boolean exist = userlistRepository.existsById(userId);

        if(exist){
            Userinfo existUser = userInfoRepository.getByUserId(userId);
            int day = existUser.calculateDay();

            if(day>0){
                existUser.setDay(day);
            }
            else{   //시작 날짜 아직 설정x 며칠차 -> 0일
                existUser.setDay(0);
            }
            userInfoRepository.save(existUser);
        }
        return exist;
    }

    //시작일 설정
    public String setStartDate(String userId, LocalDate startDate) {
        Userinfo userInfo = userInfoRepository.getByUserId(userId);
        userInfo.setStartDate(startDate);
        //설정된 시작일로 부터 며칠차 계산
        userInfo.setDay(userInfo.calculateDay());
        return userInfoRepository.save(userInfo).getUserlist().getUserId();
    }
}
