package com.main.ecom.main.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class ProductItem {

	    //PRODUCTNAME, PRICE
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY) //SEQUENCE
		@Column(name = "ID",nullable=false)
		private Long id;
		@Column(name="PRODUCTNAME",nullable=false)
		 private String productname;
		@Column(name="PRICE")
		 private int price;
		
		public ProductItem() {
			// TODO Auto-generated constructor stub
		}
		
		public ProductItem(Long id, String productname, int price) {
			
			this.id = id;
			this.productname = productname;
			this.price = price;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getProductname() {
			return productname;
		}

		public void setProductname(String productname) {
			this.productname = productname;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
		 
		 
		 

		    
	}


