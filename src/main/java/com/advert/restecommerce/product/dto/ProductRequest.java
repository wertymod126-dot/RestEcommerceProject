package com.advert.restecommerce.product.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank @Size(max=400)
        String name,
        String description,
        @NotBlank
        @Size(max=400)
        String imageUrl,
        @PositiveOrZero
        int stockQuantity,
        @Positive
        @NotNull
        BigDecimal price
        )
    {
}
