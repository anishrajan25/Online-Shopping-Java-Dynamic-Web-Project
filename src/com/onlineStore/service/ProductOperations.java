package com.onlineStore.service;

import com.onlineStore.bean.Product;
import com.onlineStore.dao.DataBaseAdd;

public class ProductOperations {
public boolean addProduct(Product product)
{
	System.out.println("Add Product");
	DataBaseAdd db=new DataBaseAdd();
	
	return db.addProduct(product);
}
}
