package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.ProductsImages;

public interface ProductImageRepository  extends JpaRepository<ProductsImages, Long>{

}
