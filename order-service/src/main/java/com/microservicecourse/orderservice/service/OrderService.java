package com.microservicecourse.orderservice.service;

import com.microservicecourse.orderservice.dto.InventoryResponse;
import com.microservicecourse.orderservice.dto.OrderLineItemsDto;
import com.microservicecourse.orderservice.dto.OrderRequest;
import com.microservicecourse.orderservice.model.Order;
import com.microservicecourse.orderservice.model.OrderLineItems;
import com.microservicecourse.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor //this is for injection of repository by constructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        // Call inventory service, and place order if product is in stock.
       InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get()
               //Build the URI getting the skucodes and putting into request parameters
                .uri("http://inventory-service/api/inventory", uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                        .retrieve()
                                .bodyToMono(InventoryResponse[].class)
                                        .block();

       assert inventoryResponseArray != null;
       //Verify if all the products that are in the array (response of inventory service) are in stock.
       boolean allProductsInStock = Arrays.stream(inventoryResponseArray)
               .allMatch(InventoryResponse::isInStock);

       //If the products are in stock (allProductsInStock = true), save the order.
       if (Boolean.TRUE.equals(allProductsInStock)){
           orderRepository.save(order);
       }else {
           throw new IllegalArgumentException("Product is not in stock, please try again later.");
       }

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;

    }

}
