<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-MANDI</title>
<link rel="stylesheet" href="./style/loginStyle.css" type="text/css">
</head>
<body>

	<div class="segment register">
		<a href="${pageContext.request.contextPath}/login">
			<button type="button" class="unit">Login</button>
		</a>
	</div>
	<div class="segment home">
		<a href="${pageContext.request.contextPath}/home">
			<button type="button" class="unit">Home</button>
		</a>
	</div>

	<form action="${pageContext.request.contextPath}/signup" method="post">
		<div class="segment">
			<h1>New Sign-Up</h1>
		</div>
		${message} 
		<br> 
		
		
		
		<label for="userName" class="label"> <input type="text" name="userName" placeholder="User name " id="userName"> </label>
		
		<label for="email" class="label"> <input type="text" name="email" placeholder="Email Address" id="email"> </label>
		
	     <label for="password" class="label"> <input type="password" name="password" placeholder="password" id="password"> </label> 
	     
	     <label for="confirmPassword" class="label"> <input type="password" name="confirmPassword" placeholder="confirm password" id="confirmPassword"> </label>
	     
		<div class="password-hint">Must consist of atleast 6 characters,
			a symbol, an upper and a lower case letter</div>
		<br>

		<button class="red" type="submit">
			<i class="fa fa-unlock-alt"> Sign Up </i>
		</button>
	</form>

</body>
</html>