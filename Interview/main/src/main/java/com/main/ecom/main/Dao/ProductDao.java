package com.main.ecom.main.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.ecom.main.model.ProductItem;

import java.util.List;


@Repository
	public interface ProductDao extends JpaRepository<ProductItem, Long> {

	//@Query(name = "Select * from dupe_ecommerce.product where id in ()",nativeQuery = true)
	List<ProductItem> findByIdIn(List<Integer> ids);

	}



