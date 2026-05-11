package com.flashkart.flashkart.config;

import com.flashkart.flashkart.entity.Product;
import com.flashkart.flashkart.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Only seed data if the products table is currently empty
        if (productRepository.count() == 0) {

            Product laptop = Product.builder()
                    .sku("TECH-LT-01")
                    .name("Developer Laptop Pro")
                    .price(new BigDecimal("1499.99"))
                    .stockQuantity(10)
                    .build();

            Product monitor = Product.builder()
                    .sku("TECH-MON-02")
                    .name("UltraWide 34-inch Monitor")
                    .price(new BigDecimal("499.50"))
                    .stockQuantity(5)
                    .build();

            Product keyboard = Product.builder()
                    .sku("TECH-KB-03")
                    .name("Mechanical Keyboard")
                    .price(new BigDecimal("120.00"))
                    .stockQuantity(50)
                    .build();

            productRepository.saveAll(List.of(laptop, monitor, keyboard));
            System.out.println("Test data seeded successfully!");
        }
    }
}