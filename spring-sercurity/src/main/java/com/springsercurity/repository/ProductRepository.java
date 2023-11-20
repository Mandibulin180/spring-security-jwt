package com.springsercurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsercurity.domain.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
