package com.ortest.mapstruct;

import com.ortest.model.Order;
import com.sun.istack.NotNull;

public class PlaceOrderDto {
    private Long id;
    private @NotNull
    float totalHorsTaxx;

    public PlaceOrderDto(){}
    public PlaceOrderDto(Order order) {
        this.setOrderId(order.getId());
        this.setOrderTotalHorsTaxx(order.getTotaleHorsTax());
    }
    private Long setOrderId(Long id) {
        return this.id;
    }
    public float setOrderTotalHorsTaxx(float totalHorsTaxx){
        return this.totalHorsTaxx;
    }
}
