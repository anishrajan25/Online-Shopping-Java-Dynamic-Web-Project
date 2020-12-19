<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../../css/signIn.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<title>Sign In</title>
	</head>

	<body class="text-center">
		<div class="container">
			<div class="row">
				<div class="col-md-6 mx-auto p-0">
					<div class="card">
						<div class="login-box">
							<div class="login-snip"> 
								<input id="tab-1" type="radio" name="tab" class="sign-in" checked>
								<label for="tab-1" class="tab">Login</label> 
								<input id="tab-2" type="radio" name="tab" class="sign-up">
								<label for="tab-2" class="tab">Sign Up</label>
								<div class="login-space">
									<form action="/Online_Shopping_Web/SignIn" method="post">
										<div class="login">
											<div class="group"> 
												<label for="user" class="label">E-Mail</label> 
												<input id="user" type="email" class="input" name="Email" placeholder="Enter your E-Mail" required > 
											</div>
											<div class="group"> 
												<label for="pass" class="label">Password</label> 
												<input id="pass" type="password" class="input" name="Passwd" data-type="password" placeholder="Enter your password" required> 
											</div>
											<div class="group"> 
												<input type="submit" class="button" value="Sign In"> 
											</div>
											<div class="hr"></div>
											<!-- <div class="foot"> 
												<a href="#">Forgot Password?</a> 
											</div> -->
										</div>
									</form>
									<form action="/Online_Shopping_Web/SignUp" enctype="multipart/form-data" method="post">
										<div class="sign-up-form" id="1">
											<div class="group"> 
												<label for="firstname" class="label">Firstname</label> 
												<input id="firstname" type="text" class="input" name="FirstName" placeholder="Enter your Firstname" > 
											</div>
											<div class="group"> 
												<label for="lastname" class="label">Lastname</label> 
												<input id="lastname" type="text" class="input" name="LastName" placeholder="Enter your LastName" > 
											</div>
											<div class="group"> 
												<label for="mail" class="label">E-mail</label> 
												<input id="mail" type="email" class="input" name="Email" placeholder="Enter your E-Mail" > 
											</div>
											<div class="group"> 
												<label for="pass" class="label">Password</label> 
												<input id="pass" type="password" class="input" name="Passwd" data-type="password" placeholder="Create your password" > 
											</div>
											<div class="group"> 
												<label for="passConfirmed" class="label">Repeat Password</label> 
												<input id="passConfirmed" type="password" class="input" name="passConfirmed" data-type="password" placeholder="Repeat your password" > 
											</div>
											<div class="group"> 
												<input id="next" type="button" class="button" value="Next"> 
											</div>
											<div class="hr"></div>
											<div class="foot"> 
												<label for="tab-1">Already Member?</label> 
											</div>
										</div>
										<div class="sign-up-form" id="2">
											<div class="group"> 
												<input id="back" type="button" class="button" value=" <- Back"> 
											</div>
											<div class="group"> 
												<label for="inputMobile" class="label">Mobile Number</label>
												<input type="tel" pattern="[0-9]{10}" name="MobileNumber" id="inputMobile" class="input" placeholder="Mobile Number: 9574621830" >
											</div>
											<div class="group"> 
												<label for="inputAddress" class="label"></label>
												<textarea style="resize: none;" rows="5" cols="30" maxlength="60" name="Address" id="inputAddress" class="input" placeholder="Address" ></textarea> 
											</div>
											<div class="group"> 
												<input id="hidden" type="hidden" name="status" value="3"> 
											</div>
											<div class="group"> 
												<input id="customer" type="submit" class="button" value="Sign Up as Customer"> 
											</div>
											<div class="group"> 
												<input id="merchant" type="button" class="button" value="Sign Up as Merchant -> "> 
											</div>
											<div class="hr"></div>
											<div class="foot"> 
												<label for="tab-1">Already Member?</label> 
											</div>
										</div>
										<div class="sign-up-form" id="3">
											<div class="group"> 
												<input id="back2" type="button" class="button" value=" <- Back"> 
											</div>
											<div class="group"> 
												<label for="inputAadhar" class="label">Aadhar Number</label>
												<input type="text" pattern="[0-9]{16}" name="AadharNumber" id="inputAadhar" class="input" placeholder="Aadhar Number" >
											</div>
											<div class="group"> 
												<label for="inputPic" class="label">Upload your picture</label>
												<input type="file" name="picture" id="inputPic" class="input" >
											</div>
											<div class="group"> 
												<input id="" type="submit" class="button" value="Sign Up as Merchant"> 
											</div>
											<div class="hr"></div>
											<div class="foot"> 
												<label for="tab-1">Already Member?</label> 
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
  <script type="text/javascript">
  	$(document).ready(function() {
		$("#2").hide();
  		$("#3").hide();
		  
  		$("#next").click(function() {
  			$("#1").hide();
  			$("#2").fadeIn();
		});
		
		$("#back").click(function() {
  			$("#2").hide();
  			$("#1").fadeIn();
		});

		$("#merchant").click(function() {
  			$("#2").hide();
			$("#3").fadeIn();
			$("#hidden").val("2");
		});
		  
		$("#back2").click(function() {
  			$("#3").hide();
  			$("#2").fadeIn();
			$("#hidden").val("3");
  		});
  	});
  </script>
</html>
