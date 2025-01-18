package com.example.firstproject.repository;

import com.example.firstproject.model.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<Userinfo, String> {

    Userinfo getByUserId(String userId);
    Userinfo findByUserId(String userId); // user_id로 데이터 조회

}
