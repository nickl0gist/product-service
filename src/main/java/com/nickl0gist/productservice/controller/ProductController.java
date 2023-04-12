package com.nickl0gist.productservice.controller;

import com.nickl0gist.productservice.dto.ProductDTO;
import com.nickl0gist.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created on 10.04.2023
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("all")
    public Flux<ProductDTO> all(){
        return this.service.getAll();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<ProductDTO>> getProductById(@PathVariable String id){
        return this.service.getProductByID(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("price-range")
    public Flux<ProductDTO> getProductsFilteredByPrice(@RequestParam("min") Double min,
                                                                       @RequestParam("max") Double max){
        return this.service.getProductInPriceRange(min, max);
    }

    @PostMapping
    public Mono<ProductDTO> insertProduct(@RequestBody Mono<ProductDTO> productDTOMono){
        return this.service.insertProduct(productDTOMono);
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<ProductDTO>> updateProduct(@PathVariable String id,
                                                          @RequestBody Mono<ProductDTO> productDTOMono){
        return this.service.updateProduct(id, productDTOMono)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return this.service.deleteProduct(id);
    }

}
