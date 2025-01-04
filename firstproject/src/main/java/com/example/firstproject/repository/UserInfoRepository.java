package com.example.firstproject.repository;

import com.example.firstproject.model.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<Userinfo, String> {


}
