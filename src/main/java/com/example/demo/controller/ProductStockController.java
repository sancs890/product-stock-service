package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.ProductStockBean;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductStockRepository;

@RestController
public class ProductStockController {
	
	@Autowired
	Environment environment;
	@Autowired
	ProductStockRepository productStockRepository;
	
	@GetMapping("check-product-stock/productName/{productName}/productAvailability/{productAvailability}")
	public ProductStockBean checkProductStock(@PathVariable String productName,@PathVariable String productAvailability)
	{
		Product product = productStockRepository.findByProductNameAndProductAvailability(productName, productAvailability);
		ProductStockBean productStockBean = new ProductStockBean(product.getId(), 
																product.getProductName(), 
																product.getProductPrice(), 
																product.getProductAvailability(), 
																product.getDiscountOffer(), 
																Integer.parseInt(environment.getProperty("local.server.port")));
		return productStockBean;
	}
}
