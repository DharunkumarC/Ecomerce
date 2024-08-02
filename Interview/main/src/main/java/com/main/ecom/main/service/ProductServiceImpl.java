package com.main.ecom.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.ecom.main.Dao.ProductDao;

import com.main.ecom.main.model.ProductItem;



@Service
public class ProductServiceImpl  implements ProductService{
	
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductItem> getAllDetails() {
		return productDao.findAll();
	}

	@Override
	public ProductItem addProduct(ProductItem productItem) {
		return productDao.save(productItem);
	}
    @Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		productDao.deleteById(id);
	}
	public HashMap<String,Object> listingCartProduct(List<Integer> productId){
		List<ProductItem> list = productDao.findByIdIn(productId);
		HashMap<String,Object> output = new HashMap<>();
		double totalmaount =0.0;
		if(list!=null){
			for(ProductItem price :list){
			 	totalmaount+=price.getPrice();
			}
		}
		output.put("Total Amount", totalmaount);
		output.put("Selected Product",list);
		return output;
	}

	public  Optional<ProductItem> getProduct(Long productId) {
	Optional<ProductItem> productItem = productDao.findById(productId);
	return productItem;
	}


}
