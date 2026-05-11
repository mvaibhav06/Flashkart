package com.flashkart.flashkart.controller;

import com.flashkart.flashkart.dto.OrderRequest;
import com.flashkart.flashkart.entity.Order;
import com.flashkart.flashkart.entity.Product;
import com.flashkart.flashkart.repository.ProductRepository;
import com.flashkart.flashkart.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;
    private final ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> placeOrder(@Valid @RequestBody OrderRequest request) {
        Order savedOrder = orderService.placeOrder(request);
        return ResponseEntity.ok(savedOrder);
    }
}