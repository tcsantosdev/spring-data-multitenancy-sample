package com.tcsantos.spring.data.multitenancy.configurator.sample.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcsantos.spring.data.multitenancy.configurator.sample.product.domain.Product;
import com.tcsantos.spring.data.multitenancy.configurator.sample.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public Product find(Long id) {
		return productRepository.findOne(id);
	}

	@Transactional
	public List<Product> findAll() {
		return productRepository.findAll();
	}

}
