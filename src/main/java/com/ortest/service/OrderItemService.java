package com.ortest.service;

import com.ortest.model.OrderItems;

import java.util.List;

public interface OrderItemService {
    OrderItems save(OrderItems orderItem);
    List<OrderItems> findAllById(Iterable<Long> longs);

    List<OrderItems> findAllItems();
}
