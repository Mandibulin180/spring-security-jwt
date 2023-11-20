package com.springsercurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsercurity.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
