package com.onlineStore.dao;
import java.sql.DriverManager;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.onlineStore.bean.Consumer;
import com.onlineStore.bean.Merchant;
import com.onlineStore.bean.Product;
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

		PreparedStatement ps=con.prepareStatement("INSERT INTO SELLER_FOR_SHOPPINGPROJECT VALUES(?,?,?,?,?,?,?,?,?)");
		ps.setString(1,merchant.getFirstName());
		ps.setString(2, merchant.getLastName());
		ps.setString(3, merchant.getEmail());
		ps.setLong(4, merchant.getPhoneno());
		ps.setString(5,merchant.getAddress());
		ps.setString(6, merchant.getPassword());
		ps.setLong(7, merchant.getAadharNumber());
		ps.setBinaryStream(8, (merchant.getImage()).getInputStream(),(int)(merchant.getImage()).getSize());
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
public boolean addProduct(Product product)
{
	try
	{
		System.out.println("Entered");
		PreparedStatement ps=con.prepareStatement("INSERT INTO PRODUCT_FOR_SHOPPINGPROJECT VALUES(?,?,?,?,?,?,?)");
		ps.setString(1,product.getName());
		ps.setString(2,product.getId());
		ps.setString(3,product.getMerchant());
		ps.setString(4, product.getDescription());
		ps.setInt(5, product.getPrice());;
		ps.setBinaryStream(6,(product.getImage()).getInputStream(), (product.getImage()).getSize());
		ps.setInt(7, product.getQuantity());
		ps.execute();
		System.out.println("Product Added");
	}
	catch(Exception e)
	{
		System.out.println(e);
		return false;
	}
	return true;
}
public boolean addToCart(String ConsumerName,String Id)
{
	int count=0;
	try
	{
		PreparedStatement ps=con.prepareStatement("SELECT * FROM PRODUCT_FOR_SHOPPINGPROJECT WHERE PRODUCTID=?");
		ps.setString(1,Id);
		ResultSet rs=ps.executeQuery();
		if(rs!=null)
		{
			count=1;
			String Productname = null,id = null,merchantname = null,description = null;
			int price = 0;
			InputStream is = null;
			while(rs.next())
			{
				Productname=rs.getString(1);
				id=rs.getString(2);
				merchantname=rs.getString(3);
				description=rs.getString(4);
				price=rs.getInt(5);
				is=rs.getBinaryStream(6);
			}
			ps=con.prepareStatement("INSERT INTO CART_FOR_SHOPPINGPROJECT VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, Productname);
			ps.setString(2, id);
			ps.setString(3, merchantname);
			ps.setString(4, ConsumerName);
			ps.setString(5,description);
			ps.setInt(6, price);
			ps.setBinaryStream(7, is);
			ps.executeUpdate();
		}
	}
	catch(Exception e)
	{
		
	}
	return true;
}
}
