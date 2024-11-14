package com.example.marketplace.service;

import com.example.marketplace.dto.ProductDto;
import com.example.marketplace.entity.Product;
import com.example.marketplace.exception.ProductNotFoundException;
import com.example.marketplace.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Override
    public UUID createProduct(ProductDto productDto) {
        final Product entity = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .categories(productDto.getCategories())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .build();

      return this.productDAO.save(entity).getId();
    }

    @Override
    public ProductDto getProductById(UUID id) {
        final Product productDto = productDAO.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Продукт с таким id не был найден "));

        return ProductDto.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .categories(productDto.getCategories())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .lastQuantityChange(productDto.getLastQuantityChange())
                .createdAt(productDto.getCreatedAt())
                .build();
    }

    @Override
    public UUID updateProduct(UUID id, ProductDto productDto) {
        final Product product = productDAO.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Продукт с таким id не был найден "));

        if (!Objects.equals(product.getQuantity(), productDto.getQuantity())) {
            product.setLastQuantityChange(LocalDateTime.now());
        }

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategories(productDto.getCategories());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        return productDAO.save(product).getId();
    }

    @Override
    public void deleteProduct(UUID id) {
        productDAO.findById(id).orElseThrow(() -> new ProductNotFoundException("Продукт с таким id не был найден "));

        productDAO.deleteById(id);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productDAO.findAll().stream()
                .map(entity -> ProductDto.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .description(entity.getDescription())
                        .categories(entity.getCategories())
                        .price(entity.getPrice())
                        .quantity(entity.getQuantity())
                        .lastQuantityChange(entity.getLastQuantityChange())
                        .createdAt(entity.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }


}
