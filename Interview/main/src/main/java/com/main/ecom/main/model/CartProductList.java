package com.main.ecom.main.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CartProductList {
    private Long id;
    private String productname;
    private int price;
    private double amount;
}
