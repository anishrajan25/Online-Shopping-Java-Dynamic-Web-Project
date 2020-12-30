<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Online Store</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../../css/ProductPage.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
  <%@ include file="header.jsp" %>
    <%
	    String id=request.getParameter("id");
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    System.out.println("parteek");
		 System.out.println("verified");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","demodbjava","parteek@1234");
		PreparedStatement ps=con.prepareStatement("SELECT * FROM PRODUCT_FOR_SHOPPINGPROJECT WHERE PRODUCTID=?");
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		rs.next();
    %>
    <% System.out.println(id);
    	String description=rs.getString(4);
    %>
<div class="container-fluid">
    <div class="single_product">
        <div class="container-fluid" style=" background-color: #fff; padding: 11px;">
            <div class="row">
                <div class="col-xs-12 col-md-2 order-md-1 order-2">
                	<div class="row">
                		<ul class="image_list">
	                		<div class="col-xs-4 col-md-12">
	                			<li data-image="/Online_Shopping_Web/ProductDisplay?id=<%= rs.getString(2) %>"><img class="ïmg-responsive" src="/Online_Shopping_Web/ProductDisplay?id=<%= rs.getString(2) %>" alt=""></li>
	                		</div>
	                		<div class="col-xs-4 col-md-12">
                       	 		<li data-image="/Online_Shopping_Web/ProductDisplay?id=<%= rs.getString(2) %>"><img class="ïmg-responsive" src="/Online_Shopping_Web/ProductDisplay?id=<%= rs.getString(2) %>" alt=""></li>
	                		</div>
	                		<div class="col-xs-4 col-md-12">
	                			<li data-image="/Online_Shopping_Web/ProductDisplay?id=<%= rs.getString(2) %>"><img class="ïmg-responsive" src="/Online_Shopping_Web/ProductDisplay?id=<%= rs.getString(2) %>" alt=""></li>
	                		</div>
                		</ul>
                	</div>
                </div>
                <div class="col-xs-12 col-md-4 order-md-2 order-1">
                    <div class="image_selected"><img class="ïmg-responsive" src="/Online_Shopping_Web/ProductDisplay?id=<%= rs.getString(2) %>" alt=""></div>
                </div>
                <div class="col-xs-12 col-md-6 order-3">
                        <div class="product_name"><h3><%= rs.getString(1) %></h3></div>
                        <div class="product-rating"><span class="badge badge-success"><i class="fa fa-star"></i> 4.5 Star</span> <span class="rating-review">35 Ratings & 45 Reviews</span></div>
                        <div> <span class="product_price">₹<%= rs.getString(5)%></span> <strike class="product_discount"> <span style='color:black'>₹ 2,000<span> </strike> </div>
                        <div> <span class="product_saved">You Saved:</span> <span style='color:black'>₹ 2,000<span> </div>
                        <hr class="singleline">
                        <div> <span class="product_info">EMI starts at ₹ 2,000. No Cost EMI Available<span><br> <span class="product_info">Warranty: 6 months warranty<span><br> <span class="product_info">7 Days easy return policy<span><br> <span class="product_info">7 Days easy return policy<span><br> <span class="product_info">In Stock: 25 units sold this week<span> </div>
                        <!-- <div class="row" style="margin-top: 15px;">
                            <div class="col-xs-6" style="margin-left: 15px;"> <span class="product_options">RAM Options</span><br> <button class="btn btn-primary btn-sm">4 GB</button> <button class="btn btn-primary btn-sm">8 GB</button> <button class="btn btn-primary btn-sm">16 GB</button> </div>
                            <div class="col-xs-6" style="margin-left: 55px;"> <span class="product_options">Storage Options</span><br> <button class="btn btn-primary btn-sm">500 GB</button> <button class="btn btn-primary btn-sm">1 TB</button> </div>
                        </div> -->
                        <hr class="singleline">
                        <div class="order_info d-flex flex-row">
                            <form action="#">
                        </div>
                        <div class="row">
                            <div class="col-xs-6" style="margin-left: 13px;">
                                <div class="product_quantity"> <span>QTY: </span> <input style="color: black;" id="quantity_input" type="text" pattern="[0-9]*" value="1">
                                    <div class="quantity_buttons">
                                        <div id="quantity_inc_button" class="quantity_inc quantity_control"><i class="fas fa-chevron-up"></i></div>
                                        <div id="quantity_dec_button" class="quantity_dec quantity_control"><i class="fas fa-chevron-down"></i></div>
                                    </div>
                                </div>
                            </div>
                            <% if(type.equals("consumer")){ %>
                                <div class="col-xs-6"> 
                                    <a href="/Online_Shopping_Web/CartAdd?id=<%= rs.getString(2) %>">
                                        <button type="button" class="btn btn-primary shop-button">Add to Cart</button>
                                    </a> 
                                </div>
                            <% } %>
                            
                        </div>
                    </div>
                </div>
            </div>
            <div class="row row-underline">
                <div class="col-md-6"> <span class=" deal-text">Product Description</span> </div>
                <div class="col-md-6"> <a href="#" data-abc="true"> <span class="ml-auto view-all"></span> </a> </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <p style="color: black"><%= description %></p>
                </div>
            </div>
        </div>
    </div>
	</div>
	 <%@ include file="footer.jsp" %>
</body>
</html>