package com.ortest.mapstruct.mappers;

import com.ortest.mapstruct.OrderDTO;
import com.ortest.model.Orders;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Orders toOrder(OrderDTO orderDTO);

    List<OrderDTO> toOrderDTO(List<Orders> orders);
}