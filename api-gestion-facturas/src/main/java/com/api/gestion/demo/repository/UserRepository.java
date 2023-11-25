package com.api.gestion.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.gestion.demo.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(@Param(("email"))String email);
    
}
