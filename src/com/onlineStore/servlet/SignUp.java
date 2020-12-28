package com.onlineStore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineStore.bean.Consumer;
import com.onlineStore.bean.Merchant;
import com.onlineStore.service.ConsumerOperations;
import com.onlineStore.service.MerchantOperations;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
@MultipartConfig
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(true);
		HttpSession session = request.getSession();
	if(request.getParameter("status").equals("3"))
	{
		Consumer consumer=new Consumer(request.getParameter("FirstName"),request.getParameter("LastName"),request.getParameter("Email"),request.getParameter("Passwd"),request.getParameter("Address"),Integer.valueOf(request.getParameter("status")),Long.valueOf(request.getParameter("MobileNumber")));
		System.out.println("consumer object saved");
		ConsumerOperations conope=new ConsumerOperations();
		conope.addConsumer(consumer);
		session.setAttribute("type", "consumer");
		session.setAttribute("name", request.getParameter("Email"));
		response.sendRedirect("html/Public/DemoHead.jsp");
		//System.out.println(request.getParameter("FirstName")+" "+request.getParameter("LastName")+" "+request.getParameter("MobileNumber")+" "+request.getParameter("Address")+" "+request.getParameter("Email")+" "+request.getParameter("Passwd")+" "+request.getParameter("status"));
	}
	else
	{
		System.out.println(request.getParameter("FirstName")+" "+request.getParameter("LastName")+" "+request.getParameter("MobileNumber")+" "+request.getParameter("Address")+" "+request.getParameter("Email")+" "+request.getParameter("Passwd")+" "+request.getParameter("status")+" "+request.getParameter("AadharNumber"));
	Merchant merchant=new Merchant(request.getParameter("FirstName"),request.getParameter("LastName"),request.getParameter("Email"),request.getParameter("Passwd"),request.getParameter("Address"),Integer.valueOf(request.getParameter("status")),Long.valueOf(request.getParameter("MobileNumber")),Long.valueOf(request.getParameter("AadharNumber")),request.getPart("picture"));
	System.out.println("merchant object created");
	MerchantOperations merop=new MerchantOperations();
	merop.addMerchant(merchant);
	session.setAttribute("type", "merchant");
	session.setAttribute("name", request.getParameter("Email"));
	response.sendRedirect("html/Merchant/account.jsp");
	}
	}

}
