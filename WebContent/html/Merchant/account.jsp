<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
</style>

<body>
	<%@ include file="../Public/header.jsp" %>
	
	<div class="container mt-3">
		<!-- Nav pills -->
		<ul class="nav nav-pills" role="tablist">
			<li class="nav-item">
				<a class="nav-link active" data-toggle="pill" href="#info">My Information</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" data-toggle="pill" href="#add">Add Products</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" data-toggle="pill" href="#delete">Delete Products</a>
			</li>
		</ul>
		  
		<!-- Tab panes -->
		<div class="tab-content">
			<div id="info" class="container tab-pane active"><br>
				<h3>My Information</h3>
				<p>Welcome <%= name %></p>
			</div>
			<div id="add" class="container tab-pane fade"><br>
				<h3>Add a New Product</h3>
				<form action="ProductAdd" enctype="multipart/form-data" method="post">	
					<label>Product Name</label>
					<input type="text" name="ProductName"><br>
					
					<label>Product Id</label>
					<input type="text" name="ProductId"><br>
					
					<label>Merchant Name</label>
					<input type="text" name="MerchantName"><br>
					
					<label>Product Description</label>
					<input type="text" name="ProductDescription"><br>
					
					<label>Product Price</label>
					<input type="number" name="ProductPrice"><br>
					
					<label>Product Image</label>
					<input type="file" name="ProductImage"><br>
					
					<input type="submit" value="Add">
				</form>
			</div>
			<div id="delete" class="container tab-pane fade"><br>
				<h3>Delete a Product</h3>
			</div>
		</div>
	</div>
	<%@ include file="../Public/footer.jsp" %>
</body>
</html>