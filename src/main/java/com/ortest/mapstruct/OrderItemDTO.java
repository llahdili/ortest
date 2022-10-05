package com.ortest.mapstruct;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class OrderItemDTO {
    private @NotNull float prixUnitaire;
    private @NotNull int quantity;
    private @NotNull Long orderId;
    private @NotNull Long productId;
}
