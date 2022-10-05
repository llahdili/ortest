package com.ortest.service.impl;

import com.ortest.model.OrderItem;
import com.ortest.repository.OrderItemRepository;
import com.ortest.service.OrderItemSerivice;
import com.ortest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderItemsServiceImpl implements OrderItemSerivice{

    @Autowired
    private OrderItemRepository orderItemsRepository;

    public void addOrderedProducts(OrderItem orderItem) {
        orderItemsRepository.save(orderItem);
    }


}