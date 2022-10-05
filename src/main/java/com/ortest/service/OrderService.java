package com.ortest.service;

import com.ortest.model.Order;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getOrders();
    Order saveOrder(Order order) throws ParseException;

    Optional<Order> findById(Long id);

    void deleteById(Long id);

   void placeOrder();

}
