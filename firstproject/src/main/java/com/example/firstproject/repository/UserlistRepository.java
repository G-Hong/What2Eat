package com.example.firstproject.repository;

import com.example.firstproject.model.Userlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserlistRepository extends JpaRepository<Userlist, String> {

    Userlist getByUserId(String userId);
}
