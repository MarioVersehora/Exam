package com.example.Exam.repository;

import com.example.Exam.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByIdIn(List<Integer> list);
}
