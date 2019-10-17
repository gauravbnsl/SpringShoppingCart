package com.flip.service;

import java.util.List;

import com.flip.entity.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	
	public Product getProduct(int theId);

	public void deleteProduct(int theId);
	
}
