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
String Name,Id,merchant,Description;
int Price;
Part image;
protected String getName() {
	return Name;
}
protected void setName(String name) {
	Name = name;
}
protected String getId() {
	return Id;
}
protected void setId(String id) {
	Id = id;
}
protected String getMerchant() {
	return merchant;
}
protected void setMerchant(String merchant) {
	this.merchant = merchant;
}
protected String getDescription() {
	return Description;
}
protected void setDescription(String description) {
	Description = description;
}
protected int getPrice() {
	return Price;
}
protected void setPrice(int price) {
	Price = price;
}
protected Part getImage() {
	return image;
}
protected void setImage(Part image) {
	this.image = image;
}

}
