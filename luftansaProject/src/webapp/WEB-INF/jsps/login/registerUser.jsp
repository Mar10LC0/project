<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Regjistro Userin</title>
</head>
<body>
<h3>Regjistrohu</h3>
	<form action="registerUser" method="post">
	<pre>
	Emri    : <input type="text" name="firstName"/><br>
	Mbiemri : <input type="text" name="lastName"/><br>
	Email   : <input type="text" name="email"/><br>
	password: <input type="password" name="password"/><br>
	Konfirmo: <input type="password" name="confirmPassword"/><br>
	
	<input type="submit" value="Regjistrohu"/>
	<a href="login">Logohu nqs je i regjistruar</a>
	</pre>
	</form>
</body>
</html>