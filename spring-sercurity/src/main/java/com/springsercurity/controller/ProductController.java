package com.springsercurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsercurity.domain.Product;
import com.springsercurity.repository.ProductRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = productRepository.findAll();

        if(products != null && !products.isEmpty()){
            return ResponseEntity.ok(products);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> createOne(@RequestBody @Valid Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(
            productRepository.save(product)
        );
    }
    
}
