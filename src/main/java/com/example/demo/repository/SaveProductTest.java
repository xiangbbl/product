package com.example.demo.repository;

import com.example.demo.entity.AddProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveProductTest extends JpaRepository<AddProduct, Long> {

}
