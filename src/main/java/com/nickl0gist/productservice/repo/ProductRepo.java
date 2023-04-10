package com.nickl0gist.productservice.repo;

import com.nickl0gist.productservice.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 10.04.2023
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Repository
public interface ProductRepo extends ReactiveMongoRepository<Product, String> {
}
