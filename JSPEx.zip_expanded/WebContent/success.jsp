<%@page import="org.apache.catalina.connector.Response"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"
    import="java.util.ArrayList" %>
 <%! 
 	String name = "홍길동";
 	ArrayList list = new ArrayList();
 	
 	public String print(){
 		//System.out.println("Hello......");	 	
 		return name;
 	}
 	String msg;
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		msg = (String)request.getAttribute("msg");
	%>
	
	<h1> <%= msg %> </h1>
	<a href="login.html">login</a>
</body>
</html>