package com.ortest.service.impl;

import com.ortest.model.Product;
import com.ortest.repository.ProductRepo;
import com.ortest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }
    @Override
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
         productRepo.deleteAllById(id);
    }
}
