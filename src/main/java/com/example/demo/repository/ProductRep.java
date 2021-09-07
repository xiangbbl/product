package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRep extends JpaRepository<Product, Long> {
    Product findByName(String name);
}
