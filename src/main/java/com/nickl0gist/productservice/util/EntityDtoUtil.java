package com.nickl0gist.productservice.util;

import com.nickl0gist.productservice.dto.ProductDTO;
import com.nickl0gist.productservice.entity.Product;
import org.springframework.beans.BeanUtils;

/**
 * Created on 10.04.2023
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class EntityDtoUtil {
    public static ProductDTO toDto(Product product) {
        ProductDTO dto = new ProductDTO();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }

    public static Product toProduct(ProductDTO dto) {
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return product;
    }
}
