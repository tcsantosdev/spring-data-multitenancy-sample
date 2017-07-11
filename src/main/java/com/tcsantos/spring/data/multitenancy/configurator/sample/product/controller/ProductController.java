package com.tcsantos.spring.data.multitenancy.configurator.sample.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcsantos.spring.data.multitenancy.configurator.sample.product.domain.Product;
import com.tcsantos.spring.data.multitenancy.configurator.sample.product.service.ProductService;

@RestController
@RequestMapping("/{tenant}/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping
	public List<Product> find() {
		return productService.findAll();
	}

	@RequestMapping(value = "/{id}")
	public Product find(@PathVariable("id") Long id) {
		return productService.find(id);
	}

}
