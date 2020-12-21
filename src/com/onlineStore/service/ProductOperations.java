package com.onlineStore.service;

import com.onlineStore.bean.Product;
import com.onlineStore.dao.DataBaseAdd;
import com.onlineStore.dao.DataBaseDelete;

public class ProductOperations {
public boolean addProduct(Product product)
{
	System.out.println("Add Product");
	DataBaseAdd db=new DataBaseAdd();
	
	return db.addProduct(product);
}
public boolean deleteProduct(String Id,int Quantity)
{
	DataBaseDelete db=new DataBaseDelete();
	db.deleteProduct(Id, Quantity);
	return true;
}
}
