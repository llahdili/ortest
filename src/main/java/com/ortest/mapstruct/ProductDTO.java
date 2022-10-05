package com.ortest.mapstruct;

import lombok.*;
@Getter
@Setter
public class ProductDTO {
    private long id;
    private String name;
    private float unitPrice;
    private int unitsInStock;
}
