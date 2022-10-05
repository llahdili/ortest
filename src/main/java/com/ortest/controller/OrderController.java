package com.ortest.controller;

import com.ortest.common.ApiResponse;
import com.ortest.mapstruct.CheckoutItemDTO;
import com.ortest.mapstruct.OrderDTO;
import com.ortest.mapstruct.ProductDTO;
import com.ortest.mapstruct.mappers.OrderMapper;
import com.ortest.mapstruct.mappers.OrderMapperImpl;
import com.ortest.model.Order;
import com.ortest.ppattern.OrderPattern;
import com.ortest.service.OrderService;
import com.ortest.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderPattern orderPattern;
    private final OrderServiceImpl orderService;
    private OrderMapper orderMapper;
    @Autowired
    public OrderController(OrderPattern orderPattern, OrderServiceImpl orderService, OrderMapper orderMapper) {
        this.orderPattern = orderPattern;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/create-checkout-session")
    public ResponseEntity<OrderDTO> checkoutList(@RequestBody List<CheckoutItemDTO> checkoutItemDtoList) throws Exception {
        // send the stripe session id in response
        return new ResponseEntity<OrderDTO>(HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> placeOrder(OrderDTO orderDTO) throws Exception {

            // place the order
        orderService.saveOrder(orderMapper.toOrder(orderDTO));
        return new ResponseEntity<>(new ApiResponse(true, "Order has been placed"), HttpStatus.CREATED);
    }

    /*
    @GetMapping("/all")
    public ResponseEntity<List<OrderDTO>> findAll() {
        return ResponseEntity.ok(orderMapper.toOrderDTOs(orderService.getOrders()));
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO orderDTO) {
        orderService.saveOrder(orderMapper.toOrder(orderDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        Optional<Order> order = orderService.findById(id);
        return ResponseEntity.ok(orderMapper.toOrderDTO(order));
    }


    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        Order order = orderMapper.toOrder(orderDTO);
        order.setId(id);
        orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        orderService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

     */
}
