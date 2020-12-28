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

<style>
	.nav-item .active {
    	background-color: rgba(72, 72, 72, 0.6) !important;
    }
    .nav-item .nav-link {
    	color: #000
	}
	/* #main {
		background-color: rgba(154, 154, 154, 0.3);
	} */
	#addProduct input, textarea,
	#deleteProduct input,
	#updateProduct input{
		width: 85%;
		border: none;
		padding: 15px 20px;
		border-radius: 25px;
		background: rgba(87, 87, 87, 0.1)
	}
	#addProduct label,
	#updateProduct label,
	#deleteProduct label {
		font-size: large;
	}
	#addProduct input[type="submit"],
	#deleteProduct input[type="submit"],
	#updateProduct input[type="submit"] {
		width: auto;
		background: rgb(39, 38, 38);
		color: white;
	}
	::placeholder {
		color: #8f8c8c
	}
</style>

<body>
	<%@ include file="../Public/header.jsp" %>
	
	<div class="container my-3" id="main">
		<!-- Nav pills -->
		<ul class="nav nav-pills" role="tablist">
			<li class="nav-item">
				<a class="nav-link active" data-toggle="pill" href="#outline-primary">My Information</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" data-toggle="pill" href="#add">Add Products</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" data-toggle="pill" href="#delete">Delete Product</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" data-toggle="pill" href="#update">Update Products</a>
			</li>
		</ul>
		  
		<!-- Tab panes -->
		<%
		String merchantname=(String)session.getAttribute("name");
		Connection con=DBUtil.getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM SELLER_FOR_SHOPPINGPROJECT WHERE EMAIL=?");
		ps.setString(1,merchantname);
		ResultSet rs=ps.executeQuery();
		rs.next();
		%>
		<div class="tab-content">
			<div id="outline-primary" class="container tab-pane active"><br>
				<h3>My Information</h3>
				<h6>Name <%= " : "+rs.getString(1)+" "+rs.getString(2) %></h6>
				<h6>PhoneNo <%= " : "+rs.getLong(4) %></h6>
				<h6>Address <%= " : "+rs.getString(5) %></h6>
				<h6>Aadhar Number <%= " : "+rs.getLong(7) %></h6>
				<img src="/Online_Shopping_Web/MerchantDisplay?username=<%= rs.getString(3) %>">
				
			</div>
			<div id="add" class="container tab-pane fade"><br>
				<h3>Add a New Product</h3>
				<hr>
				<form action="/Online_Shopping_Web/ProductAdd" id="addProduct" enctype="multipart/form-data" method="post">
					<div class="row py-1 align-items-center">
						<div class="col-md-6">
							<label for="name" >Product Name</label>
						</div>
						<div class="col-md-6">
							<input id="name" type="text" name="ProductName" placeholder="Product Name" required>
						</div>
					</div>
					<div class="row py-1 align-items-center ">
						<div class="col-md-6">
							<label for="pid">Product Id</label>
						</div>
						<div class="col-md-6">
							<input id="pid" type="text" name="ProductId" placeholder="Product Id" required>
						</div>
					</div>
					<!--  <div class="row py-1 align-items-center ">
						<div class="col-md-6">
							<label for="mName">Merchant Name</label>
						</div>
						<div class="col-md-6">
							<input id="mName" type="text" name="MerchantName" placeholder="Merchant Name" required>
						</div>
					</div>-->
					<div class="row py-1 align-items-center">
						<div class="col-md-6">
							<label for="description">Product Description</label>
						</div>
						<div class="col-md-6">
							<textarea maxlength="100" rows="5" cols="25" id="description" placeholder="Description..." name="ProductDescription" required></textarea>
						</div>
					</div>
					<div class="row py-1 align-items-center">
						<div class="col-md-6">
							<label for="price">Product Price</label>
						</div>
						<div class="col-md-6">
							<input id="price" min="0.00" max="10000000" step="0.01" type="number" name="ProductPrice" placeholder="499.99" required>
						</div>
					</div>
					<div class="row py-1 align-items-center">
						<div class="col-md-6">
							<label for="quantity">Updated Quantity</label>
						</div>
						<div class="col-md-6">
							<input id="quantity" min="0" max="1000000" step="1" type="number" name="ProductQuantity" placeholder="100" required>
						</div>
					</div>
					<div class="row py-1 align-items-center">
						<div class="col-md-6">
							<label for="img">Product Image</label>
						</div>
						<div class="col-md-6">
							<input id="img" type="file" name="ProductImage" required><br>
							<input type="file" id="img2" class="mt-1" name="ProductImage2"><br>
							<input type="file" id="img3" class="mt-1" name="ProductImage3"><br>
							<p type="menu" style="border-radius: 25px;" class="btn btn-outline-primary mt-1 disabled">Add one more image</p>
						</div>
					</div>
					<div class="row px-auto py-1 mt-3 mx-auto">
						<div class="col-12">
							<center><input type="submit" value="Add to Inventory"></center>
						</div>
					</div>
				</form>
			</div>
			<div id="delete" class="container tab-pane fade"><br>
				<h3>Delete a Product</h3>
				<hr/>
				<form action="/Online_Shopping_Web/ProductDelete" id="deleteProduct" method="post">
					<div class="row py-1 align-items-center ">
						<div class="col-md-6">
							<label for="pid">Product Id</label>
						</div>
						<div class="col-md-6">
							<input id="pid" type="text" name="ProductId" placeholder="Product Id" required>
						</div>
					</div>
					<div class="row px-auto py-1 mt-3 mx-auto">
						<div class="col-12">
							<center><input type="submit" value="Delete from Inventory"></center>
						</div>
					</div>
				</form>
			</div>
			<div id="update" class="container tab-pane fade"><br>
				<h3>Update a Product</h3>
				<hr/>
				<form action="/Online_Shopping_Web/ProductUpdate" id="updateProduct"  method="post">
					<div class="row py-1 align-items-center ">
						<div class="col-md-6">
							<label for="pid">Product Id</label>
						</div>
						<div class="col-md-6">
							<input id="pid" type="text" name="ProductId" placeholder="Product Id" required>
						</div>
					</div>
					<div class="row py-1 align-items-center">
						<div class="col-md-6">
							<label for="quantity">Updated Quantity</label>
						</div>
						<div class="col-md-6">
							<input id="quantity" min="0" max="1000000" step="1" type="number" name="ProductQuantity" placeholder="100" required>
						</div>
					</div>
					<div class="row px-auto py-1 mt-3 mx-auto">
						<div class="col-12">
							<center><input type="submit" value="Update Inventory"></center>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../Public/footer.jsp" %>
</body>
<script>
	$(document).ready(function() {
		$("#img2").hide();
		$("#img3").hide();
		var i = 0;
		$(".btn-outline-primary").click(function() {
			if(i === 0) {
				$("#img2").slideDown();
			}
			else if(i == 1) {
				$("#img3").slideDown();
				$(".btn-outline-primary").attr("disabled", true);
			}
			i = i + 1;
			console.log(i);
		});
	});
</script>
</html>