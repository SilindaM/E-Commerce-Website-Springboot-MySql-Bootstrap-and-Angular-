package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
