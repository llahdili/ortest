package com.ortest.service.impl;

import com.ortest.model.Order;
import com.ortest.ppattern.RefPatternImp;
import com.ortest.repository.OrderRepo;
import com.ortest.service.OrderService;
import com.ortest.utils.Statu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private RefPatternImp refPatternImp;

    private OrderRepo orderRepo;
    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, RefPatternImp refPatternImp) {
        this.orderRepo = orderRepo;
        this.refPatternImp=refPatternImp;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order saveOrder(Order order) throws ParseException {
        order.setActive(true);
        order.setValidation(true);
        order.setStatu(Statu.DONE);
        order.setDateCreatedOrder(new SimpleDateFormat("yyyy-MM-dd")
                .parse(LocalDate.now().toString()));
        order.setReference(refPatternImp.referencePatt(order.getDateCreatedOrder()));
        return orderRepo.save(order);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        orderRepo.deleteById(id);
    }

    /*****************************************************/
    public void placeOrder(){
        System.out.println("here order");;
    }

}
