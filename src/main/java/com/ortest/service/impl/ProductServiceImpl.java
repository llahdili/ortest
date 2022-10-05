package com.ortest.service.impl;

import com.ortest.model.Products;
import com.ortest.repository.ProductRepo;
import com.ortest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @Override
    public List<Products> findProducts() {
        return productRepo.findAll();
    }
    @Override
    public Products saveProduct(Products product) {
        return productRepo.save(product);
    }
    @Override
    public void deleteById(Long id) {
         productRepo.deleteAllById(id);
    }

    @Override
    public Optional<Products> findById(Long id) {
        return productRepo.findById(id);
    }

}
