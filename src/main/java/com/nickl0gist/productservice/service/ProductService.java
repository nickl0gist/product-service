package com.nickl0gist.productservice.service;

import com.nickl0gist.productservice.dto.ProductDTO;
import com.nickl0gist.productservice.repo.ProductRepo;
import com.nickl0gist.productservice.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created on 10.04.2023
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Flux<ProductDTO> getAll() {
        return this.productRepo.findAll()
                .map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDTO> getProductByID(String id) {
        return this.productRepo.findById(id)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDTO> insertProduct(Mono<ProductDTO> productDTOMono) {
        return productDTOMono.map(EntityDtoUtil::toProduct)
                .flatMap(this.productRepo::insert)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDTO> updateProduct(String id, Mono<ProductDTO> productDTOMono) {
        return this.productRepo.findById(id)
                .flatMap(p -> productDTOMono
                        .map(EntityDtoUtil::toProduct)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(this.productRepo::save)
                .map(EntityDtoUtil::toDto);
    }

    /**
     * In usual MVC approach void method with line {@code his.productRepo.deleteById(id)} will work.
     * In reactive style you have to subscribe to make the code to be executed. To do that return type has to be
     * {@code Mono<Void>}
     * @param id the Id of the product to be removed.
     */
    public Mono<Void> deleteProduct(String id){
        return this.productRepo.deleteById(id);
    }

    public Flux<ProductDTO> getProductInPriceRange(Double min, Double max) {
        return this.productRepo.findByPriceBetween(Range.closed(min, max))
        // return this.productRepo.findAll()
        //       .filter(p -> p.getPrice() > min && p.getPrice() < max)
                .map(EntityDtoUtil::toDto);
    }

}
