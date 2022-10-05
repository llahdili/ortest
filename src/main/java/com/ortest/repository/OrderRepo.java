package com.ortest.repository;

import com.ortest.model.Order;
import com.ortest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Product findAllById(Long id);
    void deleteAllById(Long id);
}
