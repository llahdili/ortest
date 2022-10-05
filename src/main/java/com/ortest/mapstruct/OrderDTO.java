package com.ortest.mapstruct;

import com.ortest.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class OrderDTO {
    private Set<OrderItem> orderItems;
}
