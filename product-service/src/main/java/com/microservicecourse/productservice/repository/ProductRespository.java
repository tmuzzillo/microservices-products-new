package com.microservicecourse.productservice.repository;

import com.microservicecourse.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRespository extends MongoRepository<Product, String>{


}
