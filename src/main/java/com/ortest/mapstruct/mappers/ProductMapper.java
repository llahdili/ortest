package com.ortest.mapstruct.mappers;

import com.ortest.mapstruct.ProductDTO;
import com.ortest.model.Products;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Products toProduct(ProductDTO productDTO);

    List<ProductDTO> toProductsDTO(List<Products> products);

}
