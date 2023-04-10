package com.nickl0gist.productservice.dto;

import lombok.Data;
import lombok.ToString;

/**
 * Created on 10.04.2023
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Data
@ToString
public class ProductDTO {
    private String id;
    private String description;
    private Double price;
}
