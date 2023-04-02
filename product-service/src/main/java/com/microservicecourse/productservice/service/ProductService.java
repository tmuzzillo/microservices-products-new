package com.microservicecourse.productservice.service;

import com.microservicecourse.productservice.dto.ProductRequest;
import com.microservicecourse.productservice.dto.ProductResponse;
import com.microservicecourse.productservice.model.Product;
import com.microservicecourse.productservice.repository.ProductRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //Nos crea un constructor con todos los atributos final, por ejemplo el repository
@Slf4j
public class ProductService {

    private final ProductRespository productRespository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRespository.save(product);
        log.info("Product {} is saved", product.getId()); //toma el id del product y utiliza el place holder {} para insertar el id entre las llaves
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRespository.findAll();

        return products.stream().map(this::mapToProductresponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductresponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
