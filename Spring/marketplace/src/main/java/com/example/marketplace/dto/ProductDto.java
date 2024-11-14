package com.example.marketplace.dto;

import com.example.marketplace.entity.Categories;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ProductDto {

    UUID id;

    @Nullable
    String name;

    @Nullable
    String description;

    @Nullable
    Categories categories;

    double price;

    Integer quantity;

    LocalDateTime lastQuantityChange;

    LocalDateTime createdAt;

}
