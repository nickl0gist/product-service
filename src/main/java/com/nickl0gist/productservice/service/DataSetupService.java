package com.nickl0gist.productservice.service;

import com.nickl0gist.productservice.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created on 12.04.2023
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Service
public class DataSetupService implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        ProductDTO p1 = ProductDTO.builder().description("FPV dron V1").price(1000.0).build();
        ProductDTO p2 = ProductDTO.builder().description("DJI Mavick V2").price(1500.0).build();
        ProductDTO p3 = ProductDTO.builder().description("CD-RW").price(5.0).build();
        ProductDTO p4 = ProductDTO.builder().description("DVD-RW").price(15.0).build();
        ProductDTO p5 = ProductDTO.builder().description("Adapter USB-HDMI").price(45.0).build();

        Flux.just(p1, p2, p3, p4, p5)
                .flatMap(p -> this.productService.insertProduct(Mono.just(p)))
                .subscribe(System.out::println);
    }
}
