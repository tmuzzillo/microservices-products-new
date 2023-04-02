package com.microservicecourse.orderservice.repository;

import com.microservicecourse.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
