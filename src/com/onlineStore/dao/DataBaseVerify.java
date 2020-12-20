package com.onlineStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.onlineStore.util.DBUtil;

public class DataBaseVerify {
	Connection con=DBUtil.getConnection();
	public boolean verifyConsumer(String email,String pass)
	{
		int count=0;
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM CUSTOMER_FOR_SHOPPINGPROJECT WHERE EMAIL=? AND PASSWORD=?");
			ps.setString(1,email);
			ps.setString(2, pass);
			count=ps.executeUpdate();
		    } 
	    catch (SQLException e) {
			e.printStackTrace();
			return false;
			}
		
		return count>0;
	}
	public boolean verifyMerchant(String email,String pass)
	{
		int count=0;
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM SELLER_FOR_SHOPPINGPROJECT WHERE EMAIL=? AND PASSWORD=?");
			ps.setString(1,email);
			ps.setString(2, pass);
			count=ps.executeUpdate();
		    } 
	    catch (SQLException e) {
			e.printStackTrace();
			return false;
			}
		
		return count>0;
	}
}
