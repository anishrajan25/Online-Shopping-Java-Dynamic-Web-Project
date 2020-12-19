package com.onlineStore.service;

import com.onlineStore.bean.Consumer;
import com.onlineStore.dao.DataBaseAdd;

public class ConsumerOperations {

public boolean addConsumer(Consumer consumer)
{
	DataBaseAdd db=new DataBaseAdd();
	return db.AddConsumer(consumer);
}

}
