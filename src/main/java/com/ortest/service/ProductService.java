package com.ortest.service;

import com.ortest.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
   List<Product> getProducts();
   Product saveProduct(Product product);

   Optional<Product> findById(Long id);

   void deleteById(Long id);
}
