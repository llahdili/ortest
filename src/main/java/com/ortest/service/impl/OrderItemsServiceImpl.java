package com.ortest.service.impl;

import com.ortest.model.OrderItems;
import com.ortest.model.Products;
import com.ortest.repository.OrderItemRepository;
import com.ortest.service.OrderItemService;
import com.ortest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemsRepository;

    private final ProductService productService;

    @Autowired
    public OrderItemsServiceImpl(OrderItemRepository orderItemsRepository, ProductService productService) {
        this.orderItemsRepository = orderItemsRepository;
        this.productService = productService;
    }

    @Override
    public OrderItems save(OrderItems orderItem) {
        Products products = productService.findById(orderItem.getProducts().getId()).orElseThrow(() ->
        new RuntimeException("Product not found with id = " + orderItem.getProducts().getId()));
        orderItem.setProducts(products);
        return orderItemsRepository.save(orderItem);
    }

    @Override
    public List<OrderItems> findAllItems() {
        return orderItemsRepository.findAll();
    }
}