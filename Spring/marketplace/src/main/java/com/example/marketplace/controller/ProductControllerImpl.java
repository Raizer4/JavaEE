package com.example.marketplace.controller;

import com.example.marketplace.controller.request.CreateProductRequest;
import com.example.marketplace.controller.request.UpdateProductRequest;
import com.example.marketplace.controller.response.GetProductResponse;
import com.example.marketplace.dto.ProductDto;
import com.example.marketplace.entity.Product;
import com.example.marketplace.exception.ProductNotFoundException;
import com.example.marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController{

    private final ProductService productService;
    private final ConversionService conversionService;

    @Override
    public UUID createProduct(CreateProductRequest request) {
      return productService.createProduct(conversionService.convert(request,ProductDto.class));
    }

    @Override
    public GetProductResponse getProductById(UUID id) {
        ProductDto productById = productService.getProductById(id);
        return conversionService.convert(productById,GetProductResponse.class);
    }

    @Override
    public UUID updateProduct(UUID id, UpdateProductRequest request) {
       return productService.updateProduct(id,conversionService.convert(request, ProductDto.class));
    }

    @Override
    public ResponseEntity<Void> deleteProduct(UUID id) {
        try{
            productService.deleteProduct(id);
        }catch (ProductNotFoundException ex){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().build();
    }

    @Override
    public List<GetProductResponse> findAll() {
       final List<ProductDto> allProducts = productService.getAllProducts();

       return allProducts.stream()
                .map(product -> conversionService.convert(product, GetProductResponse.class))
                .collect(Collectors.toList());
    }

}
