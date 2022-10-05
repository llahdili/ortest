package com.ortest.mapstruct.mappers;

import com.ortest.mapstruct.ProductDTO;
import com.ortest.model.Product;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toProductDTO(Optional<Product> product);

    List<ProductDTO> toProductDTOs(List<Product> products);

    Product toProduct(ProductDTO productDTO);
}
