package com.ortest.controller;

import com.ortest.common.DateConfig;
import com.ortest.mapstruct.ProductDTO;
import com.ortest.mapstruct.mappers.ProductMapper;
import com.ortest.model.Product;
import com.ortest.ppattern.OrderPattern;
import com.ortest.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
  private final ProductService productService;
  private final ProductMapper productMapper;



  @GetMapping("/all")
  public ResponseEntity<List<ProductDTO>> findAll() {
    return ResponseEntity.ok(productMapper.toProductDTOs(productService.getProducts()));
  }

  @PostMapping("/create")
  public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) throws Exception {

    productService.saveProduct(productMapper.toProduct(productDTO));

    return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
    Optional<Product> product = productService.findById(id);

    return ResponseEntity.ok(productMapper.toProductDTO(product));
  }


  @PutMapping("/{id}")
  public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
    Product product = productMapper.toProduct(productDTO);
    product.setId(id);

    productService.saveProduct(product);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
    productService.deleteById(id);

    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
  }
}
