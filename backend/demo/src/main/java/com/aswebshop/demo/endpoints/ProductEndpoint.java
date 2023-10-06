package com.aswebshop.demo.endpoints;

import com.aswebshop.demo.entitiy.Product;
import com.aswebshop.demo.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductEndpoint {

    private final ProductService productService;

    public ProductEndpoint(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }
}