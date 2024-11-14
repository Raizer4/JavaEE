package com.example.marketplace.controller.response;

import com.example.marketplace.entity.Categories;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class GetProductResponse {

    private UUID id;

    private String name;

    private String description;

    private Categories categories;

    private double price;

    private Integer quantity;

    private LocalDateTime lastQuantityChange;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMMM yyyy")
    private LocalDateTime createdAt;

}
