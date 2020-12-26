package com.onlineStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.onlineStore.util.DBUtil;

public class DataBaseUpdate {
	Connection con=DBUtil.getConnection();
	public boolean updateProduct(String Id,int Quantity)
	{
		try
		{
				System.out.println("before Sql Execution");
				PreparedStatement ps=con.prepareStatement("UPDATE  PRODUCT_FOR_SHOPPINGPROJECT SET PRODUCTQUANTITY=? WHERE PRODUCTID=?");
				ps.setLong(1,Quantity);
				ps.setString(2, Id);
				ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		return true;
	}
}
