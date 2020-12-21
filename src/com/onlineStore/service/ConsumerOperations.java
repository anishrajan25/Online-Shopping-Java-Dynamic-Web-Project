package com.onlineStore.service;

import com.onlineStore.bean.Consumer;
import com.onlineStore.dao.DataBaseAdd;
import com.onlineStore.dao.DataBaseDelete;
import com.onlineStore.dao.DataBaseVerify;

public class ConsumerOperations {

public boolean addConsumer(Consumer consumer)
{
	DataBaseAdd db=new DataBaseAdd();
	return db.AddConsumer(consumer);
}
public boolean verifyConsumer(String email,String Password)
{
	DataBaseVerify db=new DataBaseVerify();
	return db.verifyConsumer(email,Password);
}
public boolean deleteConsumer(String Id)
{
	DataBaseDelete db=new DataBaseDelete();
	db.deleteConsumer(Id);
	return true;
}
}
