package com.main.ecom.main.service;

import java.util.List;

import com.main.ecom.main.model.ProductItem;



public interface ProductService {
	
	List<ProductItem> getAllDetails();

	ProductItem addProduct(ProductItem product);



	//Product getProductById(Long id);

	void deleteById(Long id);




}
