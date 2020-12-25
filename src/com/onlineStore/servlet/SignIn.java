package com.onlineStore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineStore.service.ConsumerOperations;
import com.onlineStore.service.MerchantOperations;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session = request.getSession();
		String email = request.getParameter("Email"), pass = request.getParameter("Passwd");
		if(email.equals("abc@xyz.com")) {
			if(pass.equals("java")) {
				session.setAttribute("type", "consumer");
				session.setAttribute("consumername", request.getParameter("Email"));
				response.sendRedirect("html/Public/DemoHead.jsp");
			}
			else if(pass.equals("jsp")) {
				session.setAttribute("type", "merchant");
				session.setAttribute("merchantname", request.getParameter("Email"));
				response.sendRedirect("html/Public/home.jsp");
			}
			else {
				response.sendRedirect("html/Public/signIn.jsp");
			}
		}
		else {
			ConsumerOperations conope=new ConsumerOperations();
			MerchantOperations merope=new MerchantOperations();
			if(conope.verifyConsumer(email,pass))
			{
				session.setAttribute("type", "consumer");
				session.setAttribute("consumername", request.getParameter("Email"));
				response.sendRedirect("html/Public/DemoHead.jsp");
			}
			else if(merope.verifyMerchant(email,pass))
			{
				session.setAttribute("type", "merchant");
				session.setAttribute("merchantname", request.getParameter("Email"));
				response.sendRedirect("html/Public/home.jsp");
			}
			else {
//				RequestDispatcher rd = request.getRequestDispatcher("html/Public/signIn.jsp");
//				response.setContentType("text/html");
//				PrintWriter out = response.getWriter();
//				System.out.println("was here");
//				out.print("ftghujiok");
//				rd.include(request, response);
				response.sendRedirect("html/Public/signIn.jsp");
			}
		}
		
	}

}
