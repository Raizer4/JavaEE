package com.example.marketplace.controller.request;

import com.example.marketplace.entity.Categories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductRequest {

    @NotBlank
    private String name;

    private String description;

    private Categories categories;

    @Positive
    private double price;

    private Integer quantity;
}
