package com.onlineStore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineStore.bean.Product;
import com.onlineStore.service.ProductOperations;

/**
 * Servlet implementation class ProductAdd
 */
@WebServlet("/ProductAdd")
@MultipartConfig
public class ProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAdd() {
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
		// TODO Auto-generated method stub
				HttpSession session=request.getSession();
				String merchantname=(String)session.getAttribute("name");
				Product product=new Product(request.getParameter("ProductName"),request.getParameter("ProductId"),merchantname,request.getParameter("ProductDescription"),Integer.valueOf(request.getParameter("ProductPrice")),request.getPart("ProductImage"),Integer.valueOf(request.getParameter("ProductQuantity")));
				System.out.println("Product Object Created");
				ProductOperations proope=new ProductOperations();
				proope.addProduct(product);
				System.out.println(request.getParameter("ProductName")+" "+request.getParameter("ProductId")+" "+request.getParameter("ProductDescription")+" "+request.getParameter("ProductPrice"));
				response.sendRedirect("html/Merchant/account.jsp");
	}

}
