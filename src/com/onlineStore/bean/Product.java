package com.onlineStore.bean;

import javax.servlet.http.Part;

public class Product extends ParentRecordProduct{

	public Product(String name, String id, String merchant, String description, int price, Part image) {
		super(name, id, merchant, description, price, image);
		// TODO Auto-generated constructor stub
	}

}
