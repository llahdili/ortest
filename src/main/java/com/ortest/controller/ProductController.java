package com.ortest.controller;

import com.ortest.mapstruct.ProductDTO;
import com.ortest.mapstruct.mappers.ProductMapper;
import com.ortest.model.Products;
import com.ortest.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {
  private final ProductService productService;
  private final ProductMapper productMapper;
  @Autowired
  public ProductController(ProductService productService, ProductMapper productMapper) {
    this.productService = productService;
    this.productMapper = productMapper;
  }
  @GetMapping("/all")
  public ResponseEntity<List<ProductDTO>> findAll() {
    return ResponseEntity.ok(productMapper.toProductsDTO(productService.findProducts()));
  }
  @PostMapping("/add")
  public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
    productService.saveProduct(productMapper.toProduct(productDTO));
    return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
  }
  @PutMapping("/update/{id}")
  public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
    Products product = productMapper.toProduct(productDTO);
    product.setId(id);
    productService.saveProduct(product);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
  }
    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable Long productId) {
    productService.deleteById(productId);
    ResponseEntity.status(HttpStatus.ACCEPTED);
  }

  @GetMapping("/pagi")
  public ResponseEntity<List<Products>> getAllProductsPagination(
          @RequestParam(defaultValue = "1") Integer pageNo,
          @RequestParam(defaultValue = "6") Integer pageSize,
          @RequestParam(defaultValue = "id") String sortBy)
  {
    List<Products> listOfProductRequired = productService.getAllProductsPagination(pageNo, pageSize, sortBy);

    return new ResponseEntity<List<Products>>(listOfProductRequired, new HttpHeaders(), HttpStatus.OK);
  }
}


