package com.ortest.service;

import com.ortest.model.Orders;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Orders> findAll();
    Orders saveOrder(Orders order);

    void deleteById(Long id);
    Optional<Orders> findById(Long id);
}
