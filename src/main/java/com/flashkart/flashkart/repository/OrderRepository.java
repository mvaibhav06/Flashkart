package com.flashkart.flashkart.repository;

import com.flashkart.flashkart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}