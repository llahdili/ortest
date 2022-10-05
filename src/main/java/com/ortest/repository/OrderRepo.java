package com.ortest.repository;
import com.ortest.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {
    List<Orders> findAll();
    Optional<Orders> findById(Long id);

    @Query(value = "SELECT * FROM orders WHERE id = (SELECT MAX(id) FROM orders)", nativeQuery = true)
    Orders findMaxId();


}
