package com.example.marketplace.controller.request;

import com.example.marketplace.entity.Categories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductRequest {

    @NotBlank
    private String name;

    private String description;

    private Categories categories;

    @Positive
    private double price;

    @NotNull
    private Integer quantity;
}
