<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../../css/signIn.css">
		<link rel="stylesheet" href="../../css/Demo.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div id="ProductPage">
    <%@ include file="header.jsp" %>
    <% String username=(String)(request.getSession(false)).getAttribute("consumername"); %>
    <h1>Cart Display Page</h1>
    <%--<%
    response.setContentType("image/jpeg");
    %>--%>
    <%
    Class.forName("oracle.jdbc.driver.OracleDriver");
	 System.out.println("verified");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","demodbjava","parteek@1234");
	PreparedStatement ps=con.prepareStatement("SELECT * FROM CART_FOR_SHOPPINGPROJECT WHERE CUSTOMERUSERNAME=?");
	String t=(String) session.getAttribute("consumername");
	ps.setString(1,t);
	ResultSet rs=ps.executeQuery();
    %>
    <% while(rs.next()){  %>
    <% System.out.println(1);%>
    <%  String str=rs.getString(5);%>
    <a href="productDescription.jsp?id=<%= rs.getString(2) %>"><div class="card card-custom bg-white border-white border-0">
          <div class="card-custom-img" style="background-image: url(/Online_Shopping_Web/CartDisplay?id=<%= rs.getString(2) %>);"></div>
          <div class="card-custom-avatar">
            <img class="img-fluid" src="/Online_Shopping_Web/CartDisplay?id=<%= rs.getString(2) %>" alt="Avatar" />
          </div>
          
          <div class="card-body" style="overflow-y: auto">
            <h4 class="card-title"><%= rs.getString(1) %></h4>
             <p class="card-text"><%= str %></p>
          </div>
          <div class="card-footer" style="background: inherit; border-color: inherit;">
            <a href="#" class="btn btn-primary"><%= rs.getInt(6) %></a>
             <a href="#" class="btn btn-outline-primary"><%= str %></a>
          </div>
          <a href="/Online_Shopping_Web/CartDelete?id=<%= rs.getString(2) %>"><button>Delete From the Cart</button></a>
        </div>
        </a>
    
    
    
    
    	<%-- <h1></h1>
    	<h1><%= rs.getString(2) %></h1>
    	<h1><%= rs.getString(3) %></h1>
    	<h1></h1>
    	<h1></h1>
    	<% request.setAttribute("task","displayproduct"); %>
    	<img width='300' height='300' src="/Online_Shopping_Web/ImageDisplay?id=<%= rs.getString(2) %>"  >
    	<%-- <img width='300' height='300' src="/Online_Shopping_Web/ImageDisplay?id=<%= rs.getString(2) %>"  >
    	<h1><%= rs.getInt(7) %></h1>--%>
    	
    	
    <%  }
    %>
    <%@ include file="footer.jsp" %>
    </div>
</body>
</html>