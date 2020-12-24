package com.onlineStore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineStore.service.ConsumerOperations;
import com.onlineStore.service.MerchantOperations;
import com.onlineStore.service.ProductOperations;

/**
 * Servlet implementation class DeleteOperations
 */
@WebServlet("/DeleteOperations")
public class DeleteOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOperations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entered in post of DeleteOperations");
		if(request.getParameter("task").equals("Deletion of Product"))
		{
			ProductOperations proope=new ProductOperations();
			System.out.println("Going to be deleted");
			proope.deleteProduct(request.getParameter("ProductId"));
		}
		else if(request.getParameter("task").equals("Deletion of User"))
		{
			if(request.getParameter("UserType").equals("2"))
			{
				MerchantOperations merope=new MerchantOperations();
				merope.deleteMerchant(request.getParameter("UserId"));
			}
			else
			{
				ConsumerOperations conope=new ConsumerOperations();
				conope.deleteConsumer(request.getParameter("UserId"));
			}
			System.out.println(request.getParameter("UserId")+" "+request.getParameter("UserType"));
			
		}
		else if(request.getParameter("task").equals("Deletion From Cart"))
		{
			ProductOperations proope=new ProductOperations();
			proope.deleteFromCart(request.getParameter("customername"),request.getParameter("id"));
		}
		
	}

}
