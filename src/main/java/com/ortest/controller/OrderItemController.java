package com.ortest.controller;

import com.ortest.mapstruct.OrderItemDTO;
import com.ortest.mapstruct.mappers.OrderItemMapper;
import com.ortest.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class OrderItemController {
    private final OrderItemMapper orderItemMapper;
    private final OrderItemService orderItemService;
    @Autowired

    public OrderItemController(OrderItemMapper orderItemMapper, OrderItemService orderItemService) {
        this.orderItemMapper = orderItemMapper;
        this.orderItemService = orderItemService;
    }
    @PostMapping("/add")
    public ResponseEntity<OrderItemDTO> saveOrderItem(@RequestBody OrderItemDTO orderItemDTO) {

        orderItemService.save(orderItemMapper.toOrderItem(orderItemDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(orderItemDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<List<OrderItemDTO>> findAll() {
        return ResponseEntity.ok(orderItemMapper.toOrderItemDTOs(orderItemService.findAllItems()));
    }
}
