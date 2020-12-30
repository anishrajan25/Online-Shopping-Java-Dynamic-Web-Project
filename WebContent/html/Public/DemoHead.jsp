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
<title>Online Store</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../../css/Demo.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

    <%@ include file="header.jsp" %>

	<div class="container">
    <div id="ProductPage" class="row py-4">
      <% String username=(String)(request.getSession(false)).getAttribute("name"); %>
      <%--<%
      response.setContentType("image/jpeg");
      %>--%>
      <%
      Class.forName("oracle.jdbc.driver.OracleDriver");
    System.out.println("verified");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","demodbjava","parteek@1234");
    PreparedStatement ps=con.prepareStatement("SELECT * FROM PRODUCT_FOR_SHOPPINGPROJECT");
    ResultSet rs=ps.executeQuery();
      %>
      <% while(rs.next()){  %>
      <% System.out.println(1);%>
      <div class="col-12 col-md-6 col-lg-4 my-3">
      <a href="productDescription.jsp?id=<%= rs.getString(2) %>"><div class="card card-custom bg-white border-white border-0">
          <div class="card-custom-img" style="background-image: url(/Online_Shopping_Web/ProductDisplay?id=<%= rs.getString(2) %>)"></div>
          <div class="card-custom-avatar">
            <img class="img-fluid" src="/Online_Shopping_Web/ProductDisplay?id=<%= rs.getString(2) %>" alt="Avatar" />
          </div>
          <div class="card-body" style="overflow-y: auto">
            <h4 style="color: black;" class="card-title"><%= rs.getString(1) %></h4>
            <p style="color: black;" class="card-text"><%= rs.getString(4) %></p>
          </div>
          <div class="card-footer" style="background: inherit; border-color: inherit;">
            <a href="productDescription.jsp?id=<%= rs.getString(2) %>" class="btn btn-primary">₹<%= rs.getInt(5) %></a>
            <a href="productDescription.jsp?id=<%= rs.getString(2) %>" class="btn btn-outline-primary"><%= rs.getInt(7) %></a>
          </div>
        </div>
        </a>
      </div>
    	
    <%  }
    %></div></div>

    <%@ include file="footer.jsp" %>
    
</body>
</html>