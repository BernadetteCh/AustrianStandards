package com.aswebshop.demo.service;

import com.aswebshop.demo.entitiy.Product;
import com.aswebshop.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> find(long productId) {
        return productRepository.findById(productId);
    }

    public List<Product> findAllById(List<Long> productIds) {
        return productRepository.findAllById(productIds);

    }
}
