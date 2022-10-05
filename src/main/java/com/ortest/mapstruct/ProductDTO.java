package com.ortest.mapstruct;

import lombok.Data;


import java.util.Date;

@Data
public class ProductDTO {

    private String name;
    private float unitPrice;
    private boolean active=true;
    private int unitsInStock;
    private Date dateCreatedProduct;
    private String reference;


}
