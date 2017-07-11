package com.tcsantos.spring.data.multitenancy.configurator.sample.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcsantos.spring.data.multitenancy.configurator.sample.product.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	

}
