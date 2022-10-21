package com.ortest.mapstruct;

import lombok.*;
@Getter
@Setter
public class ProductDTO {

    private long id;

    private String name;

    private Double unitPriceHorsTax;

    private Double productTVA;

    private Double productVAT_Rate;

    private Double priceTTC;

    private Integer unitsToStock;

}
