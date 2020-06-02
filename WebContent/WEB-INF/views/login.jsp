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
		<a href="${pageContext.request.contextPath}/signup">
			<button type="button" class="unit">Sign Up</button>
		</a>
	</div>
	<div class="segment home">
		<a href="${pageContext.request.contextPath}/home">
			<button type="button" class="unit">Home</button>
		</a>
	</div>

	<form action="${pageContext.request.contextPath}/login" method="post">
		<div class="segment">
			<h1>Login</h1>
		</div>
		<label for="email" class="label"> <input type="text"
			placeholder="Email Address" name="email" id="email">
		</label> <label for="password" class="label"> <input type="password"
			placeholder="password" name="password" id="password">
		</label>
		<button class="red" type="submit">
			<i class="fa fa-unlock-alt"> Log In </i>
		</button>
		<div class="segment">
			<button type="button" class="unit">Forgot Password</button>
		</div>

	</form>

</body>
</html>