package com.flashkart.flashkart.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class OrderRequest {
    @NotNull
    private List<ItemRequest> items;

    @Data
    public static class ItemRequest {
        @NotNull
        private Long productId;
        @Min(1)
        private Integer quantity;
    }
}