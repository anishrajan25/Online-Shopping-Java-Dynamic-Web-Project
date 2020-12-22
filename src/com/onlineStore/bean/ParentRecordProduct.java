package com.onlineStore.bean;

import javax.servlet.http.Part;

public class ParentRecordProduct {
public ParentRecordProduct(String name, String id, String merchant, String description, int price, Part image) {
		super();
		Name = name;
		Id = id;
		this.merchant = merchant;
		Description = description;
		Price = price;
		this.image = image;
	}
public ParentRecordProduct() {
	// TODO Auto-generated constructor stub
}
String Name,Id,merchant,Description;
int Price;

Part image;
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getMerchant() {
	return merchant;
}
public void setMerchant(String merchant) {
	this.merchant = merchant;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public int getPrice() {
	return Price;
}
public void setPrice(int price) {
	Price = price;
}
public Part getImage() {
	return image;
}
public void setImage(Part image) {
	this.image = image;
}

}
