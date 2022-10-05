package com.ortest.service.impl;

import com.ortest.common.patherns.ISortingStrategy;
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

    @Autowired
    private final ISortingStrategy iSortingStrategy;

    private final OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderItemService orderItemService, ISortingStrategy iSortingStrategy, OrderRepo orderRepo) {
        this.orderItemService = orderItemService;
        this.iSortingStrategy = iSortingStrategy;
        this.orderRepo = orderRepo;
    }
    @Override
    public List<Orders> findAll() {
        return orderRepo.findAll();
    }
    @Override
    public Orders saveOrder(Orders order){
        order.setDateCreatedOrder(LocalDateTime.now());
        order.isActive();
        order.isValidation();
        order.getStatu();
       order.setReference("BC");
            Orders res = this.orderRepo.save(order);
            for(OrderItems orderItem: res.getOrderItems()){
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
}
