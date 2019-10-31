<%@page import="org.apache.catalina.connector.Response"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"
    import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = (String)request.getAttribute("msg");
	%>
	<fieldset>
	<h1> <%= msg %> </h1>
	<a href="book.html">도서등록</a>
	<br>
	<a href="Login.html">로그아웃</a>
	</fieldset>
</body>
</html>