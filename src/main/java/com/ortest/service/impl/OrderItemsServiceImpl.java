package com.ortest.service.impl;
import com.ortest.model.OrderItems;
import com.ortest.model.Orders;
import com.ortest.model.Products;
import com.ortest.repository.OrderItemRepository;
import com.ortest.repository.OrderRepo;
import com.ortest.service.OrderItemService;
import com.ortest.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Slf4j
public class OrderItemsServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemsRepository;
    private final ProductService productService;

    private final OrderRepo orderRepo;
    @Autowired
    public OrderItemsServiceImpl(OrderItemRepository orderItemsRepository, ProductService productService, OrderRepo orderRepo) {
        this.orderItemsRepository = orderItemsRepository;
        this.productService = productService;
        this.orderRepo = orderRepo;
    }
    @Override
    public OrderItems save(OrderItems orderItem) {
        Orders orders = orderRepo.findById(orderItem.getOrders().getId()).orElseThrow(() ->
        new RuntimeException("Order not found with id = " + orderItem.getOrders().getId()));

        Products products = productService.findById(orderItem.getProducts().getId()).orElseThrow(() ->
        new RuntimeException("Product not found with id = " + orderItem.getProducts().getId()));

        if(products.getUnitsToStock() == null)
            log.error("the stock is empty");
        products.setUnitsToStock(products.getUnitsToStock() + orderItem.getQuantity());
            log.info("we added " + orderItem.getQuantity() + " units to our " + products.getName()+ " product stock ! ");

        orderItem.setTotalItemPriceHostTax(orderItem.getQuantity() * products.getUnitPriceHorsTax());
        orderItem.setTotalItemPriceTTC(orderItem.getQuantity() * products.getPriceTTC());

        orders.setTotaleOrdersPriceTTC(orders.getTotaleOrdersPriceTTC() + orderItem.getTotalItemPriceTTC());
        orders.setTotaleOrdersPriceHorsTax(orders.getTotaleOrdersPriceHorsTax() + orderItem.getTotalItemPriceHostTax());
        return orderItemsRepository.save(orderItem);
    }
    @Override
    public List<OrderItems> findAllItems() {
        return orderItemsRepository.findAll();
    }
    @Override
    public List<OrderItems> findAllById(Iterable<Long> longs) {
        return orderItemsRepository.findAllById(longs);
    }
}