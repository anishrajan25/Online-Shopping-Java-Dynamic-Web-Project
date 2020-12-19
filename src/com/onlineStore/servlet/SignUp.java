package com.onlineStore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineStore.bean.Consumer;
import com.onlineStore.service.ConsumerOperations;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
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
	if(request.getParameter("status").equals("3"))
	{
		Consumer consumer=new Consumer(request.getParameter("FirstName"),request.getParameter("LastName"),request.getParameter("Email"),request.getParameter("Passwd"),request.getParameter("Address"),Integer.valueOf(request.getParameter("status")),Long.valueOf(request.getParameter("MobileNumber")));
		System.out.println("consumer object saved");
		ConsumerOperations conope=new ConsumerOperations();
		conope.addConsumer(consumer);
		//System.out.println(request.getParameter("FirstName")+" "+request.getParameter("LastName")+" "+request.getParameter("MobileNumber")+" "+request.getParameter("Address")+" "+request.getParameter("Email")+" "+request.getParameter("Passwd")+" "+request.getParameter("status"));
	}
	}

}
