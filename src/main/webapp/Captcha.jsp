<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CAPTCHA </title>
</head>
<body>

	<center>
		<h3>CAPTCHA </h3>
	<img src="simpleCaptcha.jpg" />
	<form action="testCaptcha" method="post">
	<input type="text" name="answer" /><br>
	<input type="submit" value="Submit"></form>
	</center>
</body>

</html>
