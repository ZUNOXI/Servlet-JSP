<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = (String)request.getAttribute("id");
		String passwd = (String)request.getAttribute("passwd");
	%>
	
	<h1>로그인 성공</h1>
	<%=id%><br>
	<%=passwd%><br>
	<%= print*() %>
</body>
</html>