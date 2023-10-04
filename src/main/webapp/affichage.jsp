<%@page import="beans.Player"%>
<%@page import="beans.Knight"%>
<%@page import="beans.Wizard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.Player"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Player Info</title>
<style>
body {
	background-image: url('battle.jpg');
	background-size: cover;
	background-position: center center;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-color: black;
	color: black;
	font-family: Arial, sans-serif;
	font-size: 34px;
	margin: 0;
	font-weight:bold;
	padding: 0;
	text-align: center;
}


h1 {
	font-size: 36px;
	margin-top: 50px;
}

p {
	font-size: 24px;
	margin-top: 20px;
}

form {
	margin-top: 50px;
}

input[type=submit] {
	background-color: #8b0000;
	border: none;
	color: white;
	font-size: 24px;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	margin: 4px 2px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #b22222;
}
</style>
</head>
<body>
	<%
	Player player = (Player) request.getAttribute("player");
	%>
	<h1>Welcome brave player!</h1>
	<p>
		Your session ID:
		<%=player.getName()%></p>
	<p>
		Current Health Points:
		<%=player.getPv()%></p>
	<%
	if (player instanceof Knight) {
	%>
	<p>Type: Knight</p>
	<%
	} else if (player instanceof Wizard) {
	%>
	<p>Type: Wizard</p>
	<p>
		Magic Points:
		<%=((Wizard) player).getMp()%></p>
	<%
	}
	%>
	<form action="Attacking" method="post">
		<input type="hidden" name="playerId" value="${player.getName()}">
		<input type="submit" value="Attack">
	</form>

</body>
</html>
