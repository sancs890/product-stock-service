package com.example.demo.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository extends JpaRepository<Product, Long> {
	
	Product findByProductNameAndProductAvailability(String productName,String productAvailability);
	
}
