package com.example.firstproject.service;

import com.example.firstproject.model.Userinfo;
import com.example.firstproject.model.Userlist;
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
    public String existsUser(String userId, String passwd) {
        String loginMessage = "";
        Userlist loginUserList = userlistRepository.getByUserId(userId);

        if (loginUserList != null) {
            if (loginUserList.getPasswd().equals(passwd)) {

                loginMessage = "login success" ;
                Userinfo existUser = userInfoRepository.getByUserId(userId);
                int day = existUser.calculateDay();

                if (day > 0) {
                    existUser.setDay(day);
                } else {
                    existUser.setDay(0);
                }
                existUser.setStep(existUser.calculateStep());
                userInfoRepository.save(existUser);
            }
            else{
                loginMessage = "비밀번호가 일치하지 않습니다.";
            }
        } else {
            loginMessage = "일치하는 아이디가 없습니다.";
        }

        return loginMessage;
    }

    //시작일 설정
    public String setStartDate(String userId, LocalDate startDate) {
        Userinfo userInfo = userInfoRepository.getByUserId(userId);
        userInfo.setStartDate(startDate);
        //설정된 시작일로 부터 며칠차 계산
        userInfo.setDay(userInfo.calculateDay());

        return userInfoRepository.save(userInfo).getUserlist().getUserId();
    }

    public Userinfo getUserInfo(String userId) {
        return userInfoRepository.getByUserId(userId);
    }
}
