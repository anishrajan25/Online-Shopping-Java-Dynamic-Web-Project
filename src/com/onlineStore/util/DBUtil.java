package com.onlineStore.util;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {
	 static Connection con;
	 public static void main(String [] args)
	 {
		 DBUtil.getConnection();
	 }
	 public static Connection getConnection()
	 {
		 if(con==null)
		 {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","demodbjava","parteek@1234");
			} 
			catch (Exception e) {
				System.out.println(e);
			} 
		 }
		 System.out.println("done");
			return con;
	 }
}
