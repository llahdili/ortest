package com.ortest.service.impl;

import com.ortest.model.Products;
import com.ortest.repository.ProductRepo;
import com.ortest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        product.setProductTVA((product.getProductVAT_Rate()/100)* product.getUnitPriceHorsTax());
        product.setPriceTTC(product.getProductTVA() + product.getUnitPriceHorsTax());
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

    public Products updateProduct(Products products, Long id){
        return productRepo.save(products);
    }

    public List<Products> getAllProductsPagination(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Products> pagedResult = productRepo.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Products>();
        }
    }

}
