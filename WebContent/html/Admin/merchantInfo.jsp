<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ page import="com.onlineStore.bean.Product,com.onlineStore.util.DBUtil,java.io.InputStream,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Merchant Information</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<style>
    h3 {
        padding-top: 0.4rem;
    }
</style>
<body>
	<%@ include file="../Public/header.jsp" %>
	
	<%
        Connection con=DBUtil.getConnection();
	    String n=request.getParameter("name");
        PreparedStatement ps=con.prepareStatement("SELECT * FROM SELLER_FOR_SHOPPINGPROJECT WHERE EMAIL=?");
        ps.setString(1,n);
        ResultSet rs=ps.executeQuery();
        rs.next();
    %>
    
    <div class="container">
        <div class="row my-5">
            <div class="col-xs-12 col-md-6">
                <img class="img-thumbnail" src="/Online_Shopping_Web/MerchantDisplay?username=<%= rs.getString(3) %>" alt="Merchant Picture">
            </div>
            <div class="col-xs-12 col-md-6 ">
                <h3>Name: <%= rs.getString(1)+" "+rs.getString(2) %></h3>
                <h3>Email: <%= rs.getString(3) %></h3>
				<h3>PhoneNo: <%= rs.getLong(4) %></h3>
				<h3>Address: <%= rs.getString(5) %></h3>
				<h3>Aadhar Number: <%= rs.getLong(7) %></h3>
            </div>
        </div>
        <%
         ps=con.prepareStatement("SELECT * FROM PRODUCT_FOR_SHOPPINGPROJECT WHERE SELLERUSERNAME=?");
        ps.setString(1,n);
         ResultSet rs2=ps.executeQuery();
        %>
        <div class="row">
            <div class="col-12">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                          <tr>
                            <th scope="col">#</th>
                            <th scope="col">PRODUCT NAME</th>
                            <th scope="col">PRODUCT ID</th>
                            <th scope="col">PRODUCT DESCRIPTION</th>
                            <th scope="col">PRODUCT PRICE</th>
							<th scope="col">PRODUCT QUANTITY</th>
                          </tr>
                        </thead>
                        <tbody>
                            <% int i=0; 
                            while(rs.next()){ %>
                                <tr>
                                    <th scope="row"><%= ++i %></th>
                                    <td><%= rs2.getString(1) %></td>
                                    <td> <%= rs2.getString(2) %></td>
                                    <td><%= rs2.getString(4) %></td>
                                    <td><%= rs2.getString(5) %></td>
                                    <td><%= rs2.getString(7) %></td>
                                </tr>
                                <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row my-4">
            <div class="col-12">
                <center>
                    <a class="btn btn-outline-danger" href="/Online_Shopping_Web/MerchantDelete?UserId=<%= n %>">
                        Delete Merchant's Account
                    </a> 
                </center>
            </div>
        </div>
    </div>
				
                     
	<%@ include file="../Public/footer.jsp" %>
</body>
</html>