package com.advert.restecommerce.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByActiveTrue();
    List<Product> findByActiveTrueAndNameContainingIgnoreCase(String name);
    Optional<Product> findByIdAndActiveTrue(Long id);
}
