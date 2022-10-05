package com.ortest.service;

import com.ortest.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
public interface ProductService {
   List<Products> findProducts();
   Products saveProduct(Products product);
   void deleteById(Long id);
   Optional<Products> findById(Long id);
   List<Products> getAllProductsPagination(Integer pageNo, Integer pageSize, String sortBy);

}
