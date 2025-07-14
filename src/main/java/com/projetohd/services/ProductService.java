package com.projetohd.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetohd.entities.Product;
import com.projetohd.program.repository.ProductRepository;
@Service
public class ProductService {
	 @Autowired
	    private ProductRepository productRepository;

	    public void saveProduct(Product product) {
	        productRepository.save(product);
	    }

	    public Optional<Product> existsByName(String name) {
	        return productRepository.findByName(name);
	    }

	    public void deleteById(Long id) {
	        productRepository.deleteById(id);
	    }
	    public void deleteByName(String name) {
	        productRepository.deleteByName(name);
	    }

	    public Optional<Product> findById(Long id) {
	        return productRepository.findById(id);
	    }
}
