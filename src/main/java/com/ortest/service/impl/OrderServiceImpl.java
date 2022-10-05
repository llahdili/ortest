package com.ortest.service.impl;
import com.ortest.common.patherns.IReferenceStrategy;
import com.ortest.model.Orders;
import com.ortest.model.OrderItems;
import com.ortest.repository.OrderRepo;
import com.ortest.service.OrderItemService;
import com.ortest.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderItemService orderItemService;
    private final OrderRepo orderRepo;
    private final IReferenceStrategy iReferenceStrategy;

    @Autowired
    public OrderServiceImpl(OrderItemService orderItemService, OrderRepo orderRepo, IReferenceStrategy iReferenceStrategy) {
        this.orderItemService = orderItemService;
        this.orderRepo = orderRepo;
        this.iReferenceStrategy = iReferenceStrategy;
    }

    @Override
    public List<Orders> findAll() {
        return orderRepo.findAll();
    }

    @Override
    public Orders saveOrder(Orders order){

        order.setDateCreatedOrder(LocalDateTime.now());
        order.getActive();
        order.getValidation();
        order.getStatu();
        order.setReference(iReferenceStrategy.generateReceiptNumber());

        Orders res = this.orderRepo.save(order);
        for (OrderItems orderItem : res.getOrderItems()) {
            orderItem.setOrders(res);
            this.orderItemService.save(orderItem);
        }
        return orderRepo.save(order);
        }

    @Override
    public void deleteById(Long id) {
          orderRepo.deleteById(id);
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return orderRepo.findById(id);
    }

    public Orders findMaxId(){
        return this.orderRepo.findMaxId();
    }

}