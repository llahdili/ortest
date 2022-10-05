package com.ortest.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutItemDTO {
    private String productName;
    private int  quantity;
    private float prixUnitairee;
    private long productId;
}
