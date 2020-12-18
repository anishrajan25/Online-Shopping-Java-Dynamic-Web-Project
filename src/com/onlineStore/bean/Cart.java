package com.onlineStore.bean;

import javax.servlet.http.Part;

public class Cart extends ParentRecordProduct{
public Cart(String name, String id, String merchant, String description, int price, Part image, String consumer) {
		super(name, id, merchant, description, price, image);
		Consumer = consumer;
	}

String Consumer;

protected String getConsumer() {
	return Consumer;
}

protected void setConsumer(String consumer) {
	Consumer = consumer;
}
}
