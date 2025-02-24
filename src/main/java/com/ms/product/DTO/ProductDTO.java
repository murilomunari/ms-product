package com.ms.product.DTO;

import java.math.BigDecimal;

public record ProductDTO(String name,
                         String description,
                         BigDecimal price,
                         Long categoryId) {
}
