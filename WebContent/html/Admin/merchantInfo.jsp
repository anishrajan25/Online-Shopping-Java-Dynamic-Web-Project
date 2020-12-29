<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ page import="com.onlineStore.bean.Product,com.onlineStore.util.DBUtil,java.io.InputStream,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>My Account</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
	<%@ include file="../Public/header.jsp" %>
	
	<%
                		Connection con=DBUtil.getConnection();
	String n=request.getParameter("name");
                		PreparedStatement ps=con.prepareStatement("SELECT * FROM SELLER_FOR_SHOPPINGPROJECT WHERE EMAIL=?");
                		ps.setString(1,n);
                    	ResultSet rs=ps.executeQuery();
                        %>
                        <%while(rs.next()){ %>
                        <h6>Name <%= " : "+rs.getString(1)+" "+rs.getString(2) %></h6>
                        <h6>Email <%= " : "+rs.getString(3) %></h6>
				<h6>PhoneNo <%= " : "+rs.getLong(4) %></h6>
				<h6>Address <%= " : "+rs.getString(5) %></h6>
				<h6>Aadhar Number <%= " : "+rs.getLong(7) %></h6>
				<img src="/Online_Shopping_Web/MerchantDisplay?username=<%= rs.getString(3) %>">
                <a href="/Online_Shopping_Web/MerchantDelete?UserId=<%= rs.getString(3) %>"><button>Delete</button></a>
                <% } %>        
	<%@ include file="../Public/footer.jsp" %>
</body>
</html>