package com.onlineStore.service;

import com.onlineStore.bean.Product;
import com.onlineStore.dao.DataBaseAdd;
import com.onlineStore.dao.DataBaseDelete;
import com.onlineStore.dao.DataBaseUpdate;

public class ProductOperations {
public boolean addProduct(Product product)
{
	System.out.println("Add Product");
	DataBaseAdd db=new DataBaseAdd();
	
	return db.addProduct(product);
}
public boolean updateProduct(String Id,int Quantity)
{
	DataBaseUpdate db=new DataBaseUpdate();
	db.updateProduct(Id, Quantity);
	return true;
}
public boolean deleteProduct(String Id)
{
	DataBaseDelete db=new DataBaseDelete();
	return db.deleteProduct(Id);
}
public boolean addToCart(String ConsumerName,String Id)
{
	DataBaseAdd db=new DataBaseAdd();
	System.out.println("addToCart funcion called");
	return db.addToCart(ConsumerName,Id);
}
public boolean deleteFromCart(String ConsumerName,String Id)
{
	DataBaseDelete db=new DataBaseDelete();
	db.deleteFromCart(ConsumerName,Id);
	return true;
}
}
