package com.ortest.controller;

import com.ortest.model.Orders;
import com.ortest.mapstruct.OrderDTO;
import com.ortest.mapstruct.mappers.OrderMapper;
import com.ortest.service.OrderService;
import com.ortest.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    @Autowired
    public OrderController(OrderServiceImpl orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }
    @PostMapping("/add")
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO orderDTO) {
        orderService.saveOrder(orderMapper.toOrder(orderDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<List<OrderDTO>> findall(){
        return new ResponseEntity<>(orderMapper.toOrderDTO(orderService.findAll()), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@RequestBody OrderDTO orderDTO) {
        // we should have some condition here
        orderService.deleteById(orderDTO.getId());
        return new ResponseEntity<>("Order deleted successfully!", HttpStatus.OK);
    }
    @GetMapping("/order/{id}")
    public Optional<Orders> getOrderById(@PathVariable("id") long id) {
        return orderService.findById(id);
        }
}