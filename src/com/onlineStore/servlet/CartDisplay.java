package com.onlineStore.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineStore.util.DBUtil;

/**
 * Servlet implementation class CartDisplay
 */
@WebServlet("/CartDisplay")
public class CartDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		System.out.println("connection established");
		System.out.println(request.getParameter("id"));
			String id=request.getParameter("id");
			System.out.println(id);
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("SELECT IMAGE FROM CART_FOR_SHOPPINGPROJECT WHERE PRODUCTID=?");
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				System.out.println("step2");
				while(rs.next())
				{
					Blob b=rs.getBlob(1);
					response.setContentType("image/jpeg");
//					response.setContentLength((int)b.length());
					InputStream is=b.getBinaryStream();
					OutputStream os=response.getOutputStream();
					byte buf[]=new byte[(int)b.length()];
					is.read(buf);
					os.write(buf);
					System.out.println("reached");
					os.close();		
				}
				System.out.println("step3");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
