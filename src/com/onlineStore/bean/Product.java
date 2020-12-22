package com.onlineStore.bean;

import javax.servlet.http.Part;

public class Product extends ParentRecordProduct{
	int Quantity;
	public Product(String name, String id, String merchant, String description, int price, Part image,int quantity) {
		super(name, id, merchant, description, price, image);
		// TODO Auto-generated constructor stub
		this.Quantity=quantity;
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
		super();
	}

	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
}
