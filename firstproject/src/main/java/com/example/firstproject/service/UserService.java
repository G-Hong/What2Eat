package com.example.firstproject.service;

import com.example.firstproject.model.Userinfo;
import com.example.firstproject.model.Userlist;
import com.example.firstproject.repository.UserInfoRepository;
import com.example.firstproject.repository.UserlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserlistRepository userlistRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    private static final String LOGIN_SUCCESS = "login success";
    private static final String PASSWORD_INCORRECT = "비밀번호가 일치하지 않습니다.";
    private static final String USER_NOT_FOUND = "일치하는 아이디가 없습니다.";

    // 로그인
    public String existsUser(String userId, String passwd) {
        if (userId == null || passwd == null) {
            throw new IllegalArgumentException("사용자 ID와 비밀번호는 필수입니다.");
        }

        Optional<Userlist> loginUserListOpt = Optional.ofNullable(userlistRepository.getByUserId(userId));
        if (loginUserListOpt.isEmpty()) {
            return USER_NOT_FOUND;
        }

        Userlist loginUserList = loginUserListOpt.get();
        if (!loginUserList.getPasswd().equals(passwd)) {
            return PASSWORD_INCORRECT;
        }

        updateUserInfoAfterLogin(userId);
        return LOGIN_SUCCESS;
    }

    private void updateUserInfoAfterLogin(String userId) {
        Optional<Userinfo> userInfoOpt = Optional.ofNullable(userInfoRepository.getByUserId(userId));
        if (userInfoOpt.isEmpty()) {
            throw new IllegalStateException("로그인 사용자 정보가 존재하지 않습니다.");
        }

        Userinfo userInfo = userInfoOpt.get();
        int day = userInfo.calculateDay();
        userInfo.setDay(Math.max(day, 0)); // 음수 방지
        userInfo.setStep(userInfo.calculateStep());
        userInfoRepository.save(userInfo);
    }

    // 시작일 설정
    public String setStartDate(String userId, LocalDate startDate) {
        if (userId == null || startDate == null) {
            throw new IllegalArgumentException("사용자 ID와 시작일은 필수입니다.");
        }

        Optional<Userinfo> userInfoOpt = Optional.ofNullable(userInfoRepository.getByUserId(userId));
        if (userInfoOpt.isEmpty()) {
            throw new IllegalStateException("사용자 정보가 존재하지 않습니다.");
        }

        Userinfo userInfo = userInfoOpt.get();
        userInfo.setStartDate(startDate);
        userInfo.setDay(userInfo.calculateDay());
        return userInfoRepository.save(userInfo).getUserlist().getUserId();
    }

    // 사용자 정보 조회
    public Userinfo getUserInfo(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("사용자 ID는 필수입니다.");
        }

        return Optional.ofNullable(userInfoRepository.getByUserId(userId))
                .orElseThrow(() -> new IllegalStateException("사용자 정보를 찾을 수 없습니다."));
    }

    // Userlist 생성
    public Userlist createUserlist(Userlist userlist) {
        if (userlist == null) {
            throw new IllegalArgumentException("아이디 비밀번호를 전부 입력해주세요.");
        }

        return userlistRepository.save(userlist);
    }

    // Userinfo 생성
    public Userinfo createUserInfo(Userinfo userinfo) {
        if (userinfo == null) {
            throw new IllegalArgumentException("회원 추가 정보를 입력해주세요.");
        }

        return userInfoRepository.save(userinfo);
    }
}
