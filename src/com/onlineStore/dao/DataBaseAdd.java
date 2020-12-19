package com.onlineStore.dao;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.onlineStore.bean.Consumer;
import com.onlineStore.bean.Merchant;
import com.onlineStore.util.DBUtil;

public class DataBaseAdd {
	Connection con=DBUtil.getConnection();
public boolean AddConsumer(Consumer consumer)
{
	
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
	 ps.execute();
	}
	catch(Exception e)
	{
		return false;
	}
	return false;
}
public boolean addMerchant(Merchant merchant)
{
	//System.out.println("Add Merchant Function Entered");
	try
	{
//		System.out.println(1);
		PreparedStatement ps=con.prepareStatement("INSERT INTO SELLER_FOR_SHOPPINGPROJECT VALUES(?,?,?,?,?,?,?,?,?)");
//		System.out.println(2);
		ps.setString(1,merchant.getFirstName());
//		System.out.println(3);
		ps.setString(2, merchant.getLastName());
//		System.out.println(4);
		ps.setString(3, merchant.getEmail());
//		System.out.println(5);
		ps.setLong(4, merchant.getPhoneno());
//		System.out.println(6);
		ps.setString(5,merchant.getAddress());
//		System.out.println(7);
		ps.setString(6, merchant.getPassword());
//		System.out.println(8);
		ps.setLong(7, merchant.getAadharNumber());
//		System.out.println(9);
		ps.setBinaryStream(8, (merchant.getImage()).getInputStream(),(int)(merchant.getImage()).getSize());
//		System.out.println(10);
		ps.setLong(9, merchant.getStatus());
		ps.execute();
		System.out.println("Data added");
	}
	catch(Exception e)
	{
		System.out.println(e);
		return false;
	}
	return true;
}
}
