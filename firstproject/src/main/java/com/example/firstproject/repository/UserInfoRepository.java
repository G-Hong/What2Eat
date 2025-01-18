package com.example.firstproject.repository;

import com.example.firstproject.model.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<Userinfo, String> {

//    @Modifying
//    @Query("UPDATE Userinfo u SET u.day = :day WHERE u.user_id = :userId")
//    int updateDay(@Param("userId") String userId, @Param("day") int day);

    Userinfo getByUserId(String userId);
    Userinfo findByUserId(String userId); // user_id로 데이터 조회

}
