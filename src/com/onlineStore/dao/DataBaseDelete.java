package com.onlineStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.onlineStore.util.DBUtil;

public class DataBaseDelete {
Connection con=DBUtil.getConnection();
public boolean deleteProduct(String Id,int Quantity)
{
	try
	{
		PreparedStatement ps=con.prepareStatement("SELECT PRODUCTQUANTITY FROM PRODUCT_FOR_SHOPPINGPROJECT WHERE PRODUCTID=?");
		ps.setString(1,Id);
		ResultSet rs=ps.executeQuery();
		int t=0;
		while(rs.next())
		{
			t=rs.getInt(1);
		}
		if(t<Quantity)
		{
			System.out.println("Less Quantity");
		}
		else 
		{
			int req=t-Quantity;
			System.out.println("before Sql Execution");
			ps=con.prepareStatement("UPDATE  PRODUCT_FOR_SHOPPINGPROJECT SET PRODUCTQUANTITY=? WHERE PRODUCTID=?");
			System.out.println(req);
			ps.setLong(1,req);
			ps.setString(2, Id);
			ps.executeUpdate();
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
		return false;
	}
	return true;
}
}
