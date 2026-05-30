package com.example.product_service.controller;

import com.example.product_service.entity.Product;
import com.example.product_service.repository.ProductRepository;
import jdk.internal.org.jline.reader.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    //create a product
    @PostMapping
    public product addProduct(RequestBody Product product) {

        return ProductRepository.save(product);
    }

    //Get all product
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findALL();
    }

    //Get product by id
    @GetMapping("/(productID")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId)
        Product product = productRepository.findbyId(productId)
                .orElseThrow(()-> new RuntimeException("product no found with ID: "+productId));
        return ResponseEntity.ok(product);


}