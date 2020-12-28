package com.onlineStore.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineStore.service.ProductOperations;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/CartAdd")
public class CartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Cart add");
		ProductOperations proope=new ProductOperations();
		HttpSession session=request.getSession(false);
		String t=(String) session.getAttribute("name");
		proope.addToCart(t,request.getParameter("id"));
		System.out.println("/html/Public/productDescription.jsp?id="+request.getParameter("id"));
//		RequestDispatcher rd=request.getRequestDispatcher("/html/Public/productDescription.jsp?id="+request.getParameter("id"));
//		rd.include(request,response);
		response.sendRedirect("/Online_Shopping_Web/html/Public/CartDisplay.jsp");
	}

}
