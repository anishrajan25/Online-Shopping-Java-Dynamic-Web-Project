package com.onlineStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlineStore.util.DBUtil;

public class DataBaseDelete {
	Connection con=DBUtil.getConnection();
	
	public boolean deleteProduct(String id)
	{
		int count=0;
		PreparedStatement ps;
		try 
		{
			ps = con.prepareStatement("DELETE FROM  PRODUCT_FOR_SHOPPINGPROJECT WHERE PRODUCTID=?");
			ps.setString(1, id);
			ps=con.prepareStatement("DELETE FROM  CART_FOR_SHOPPINGPROJECT WHERE PRODUCTID=?");
			ps.setString(1,id);
			count=ps.executeUpdate();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
		
	}
	public boolean deleteConsumer(String id)
	{
		int count=0;
		try
		{
			PreparedStatement ps=con.prepareStatement("DELETE FROM  CUSTOMER_FOR_SHOPPINGPROJECT WHERE EMAIL=?");
			ps.setString(1, id);
			count=ps.executeUpdate();
			ps=con.prepareStatement("DELETE FROM  CART_FOR_SHOPPINGPROJECT WHERE CUSTOMERUSERNAME=?");
			ps.setString(1,id);
			ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return count>0;
	}
	public boolean deleteMerchant(String id)
	{
		int count=0;
		try
		{
			PreparedStatement ps=con.prepareStatement("DELETE FROM  SELLER_FOR_SHOPPINGPROJECT WHERE EMAIL=?");
			ps.setString(1, id);
			count=ps.executeUpdate();
			System.out.println("merchant deleted");
			ps=con.prepareStatement("DELETE FROM  PRODUCT_FOR_SHOPPINGPROJECT WHERE SELLERUSERNAME=?");
			ps.setString(1,id);
			ps.executeUpdate();
			System.out.println("product deleted");
			ps=con.prepareStatement("DELETE FROM  CART_FOR_SHOPPINGPROJECT WHERE SELLERUSERNAME=?");
			ps.setString(1,id);
			ps.executeUpdate();
			System.out.println("cart deleted");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return count>0;
	}
	public boolean deleteFromCart(String ConsumerName,String Id)
	{
		int count=0;
		try
		{
			PreparedStatement ps=con.prepareStatement("DELETE FROM  CART_FOR_SHOPPINGPROJECT WHERE CUSTOMERUSERNAME=? AND PRODUCTID=?");
			ps.setString(1,ConsumerName);
			ps.setString(2, Id);
			count=ps.executeUpdate();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return count>0;
	}
}
