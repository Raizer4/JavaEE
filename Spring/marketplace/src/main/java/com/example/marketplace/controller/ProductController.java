package com.example.marketplace.controller;

import com.example.marketplace.controller.request.CreateProductRequest;
import com.example.marketplace.controller.request.UpdateProductRequest;
import com.example.marketplace.controller.response.GetProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;
@Component
public interface ProductController {

    @PostMapping("")
    UUID createProduct(@RequestBody  @Valid CreateProductRequest request);

    @GetMapping("/{id}")
    GetProductResponse getProductById(@PathVariable UUID id);

    @PutMapping("/{id}")
    UUID updateProduct(@PathVariable final UUID id, @RequestBody @Valid final UpdateProductRequest request);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable final UUID id);

    @GetMapping
    List<GetProductResponse> findAll();

}

