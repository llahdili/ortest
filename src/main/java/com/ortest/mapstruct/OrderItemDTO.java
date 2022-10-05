package com.ortest.mapstruct;
import lombok.*;
@Getter
@Setter
public class OrderItemDTO {
    private Long id;
    private Integer quantity;
    private Long orderId;
    private Long productId;
}
