package com.projetohd.program.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.projetohd.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findById(Long id);
	Optional<Product> findByName(String name);
	public void deleteById(Long id);
	public void deleteByName(String name);
	
}
