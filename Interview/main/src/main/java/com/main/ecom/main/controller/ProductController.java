package com.main.ecom.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.main.ecom.main.model.UserDTO;
import com.main.ecom.main.model.UserInfo;
import com.main.ecom.main.service.ProductServiceImpl;
import com.main.ecom.main.service.UserAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.main.ecom.main.model.ProductItem;
import com.main.ecom.main.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	

            @Autowired
			private ProductServiceImpl productService;



		    @GetMapping("/getProduct")
			public List<ProductItem>getAllDetails() {
		    	 return productService.getAllDetails();
			}
		    
		    @PostMapping("/addProduct1")
			public ProductItem addProduct1(@RequestBody ProductItem productItem) {
		    	 return productService.addProduct(productItem);
			}
		    
		    @DeleteMapping("/deleteProduct1/{id}")
		    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
		        productService.deleteById(id);
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }

	@GetMapping("/cartProduct")
	public HashMap<String,Object> getCartProduct(@RequestParam List<Integer> productIds) {

				return productService.listingCartProduct(productIds);
	}
	@GetMapping("/getProductById {productId}")
	public Optional<ProductItem> getProductById(@PathVariable Long productId) {
		return productService.getProduct(productId);
	}
	}


