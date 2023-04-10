package com.nickl0gist.productservice.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * Created on 10.04.2023
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Data
@ToString
public class Product {
    @Id
    private String id;
    private String description;
    private Double price;
}
