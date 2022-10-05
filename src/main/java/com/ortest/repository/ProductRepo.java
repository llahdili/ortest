package com.ortest.repository;

import com.ortest.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long> {
    Optional<Products> findById(Long id);
    void deleteAllById(Long id);
}
