package com.nickl0gist.productservice.dto;

import lombok.*;

/**
 * Created on 10.04.2023
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String id;
    private String description;
    private Double price;
}
