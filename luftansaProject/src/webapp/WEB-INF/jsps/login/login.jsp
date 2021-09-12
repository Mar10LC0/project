<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logimi</title>
</head>
<body>
<h3>Logimi</h3>
<form action="login" method="post">
<pre>
Email : <input type="text" name="email"/><br><br>
Pass  : <input type="password" name="password"/>

<input type = "submit" value="Logohu">
<!-- Kjo perdoret per te vendosur vlerat e variablave -->
${msg} 
</pre>
</form>
</body>
</html>