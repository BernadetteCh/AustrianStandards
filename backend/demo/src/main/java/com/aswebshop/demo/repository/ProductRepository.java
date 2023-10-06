package com.aswebshop.demo.repository;

import com.aswebshop.demo.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
