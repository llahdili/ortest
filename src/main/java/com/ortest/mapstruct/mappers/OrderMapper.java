package com.ortest.mapstruct.mappers;

import com.ortest.mapstruct.OrderDTO;
import com.ortest.model.Order;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO toOrderDTO(Optional<Order> order);

    List<OrderDTO> toOrderDTOs(List<Order> orders);

    Order toOrder(OrderDTO orderDTO);


}