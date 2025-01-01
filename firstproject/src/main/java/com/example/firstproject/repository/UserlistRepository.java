package com.example.firstproject.repository;

import com.example.firstproject.model.Userlist; // 엔티티 클래스 임포트
import org.springframework.data.repository.CrudRepository;

public interface UserlistRepository extends CrudRepository<Userlist, Long> {

    public boolean existsById(String id);  // 특정 id가 존재하는지 확인
}
