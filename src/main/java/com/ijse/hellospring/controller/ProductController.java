package com.ijse.hellospring.controller;

import com.ijse.hellospring.entity.Product;
import com.ijse.hellospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product>  getProductById(@PathVariable Long id) {
        Product product =productService.getProductById(id);
        if (product==null){
            return ResponseEntity.status(404).build();
        }else {
            return ResponseEntity.ok(product);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createProduct= productService.createProduct(product);
        return ResponseEntity.status(201).body(createProduct);
    }
}
