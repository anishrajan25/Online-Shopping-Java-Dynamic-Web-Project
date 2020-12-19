package com.onlineStore.dao;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.onlineStore.bean.Consumer;
import com.onlineStore.util.DBUtil;

public class DataBaseAdd {
	
public boolean AddConsumer(Consumer consumer)
{
	Connection con=DBUtil.getConnection();
	try
	{
	PreparedStatement ps=con.prepareStatement("INSERT INTO CUSTOMER_FOR_SHOPPINGPROJECT VALUES(?,?,?,?,?,?,?)");
	ps.setString(1, consumer.getFirstName());
	ps.setString(2,consumer.getLastName());
	ps.setString(3,consumer.getEmail());
	ps.setLong(4, consumer.getPhoneno());
	ps.setString(5, consumer.getAddress());
	ps.setString(6, consumer.getPassword());
	ps.setInt(7, consumer.getStatus());
	return ps.execute();
	}
	catch(Exception e)
	{
		
	}
	return false;
}
}
