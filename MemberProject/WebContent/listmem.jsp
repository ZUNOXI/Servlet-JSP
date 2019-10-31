<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList, edu.ssafy.model.MemVO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%-- <% ArrayList<MemVO>list = (ArrayList<MemVO>)request.getAttribute("list"); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>

</head>
<body>
	<jsp:include page="logout.jsp"></jsp:include>
	<div align="center">
	<h1>회원 목록</h1>
	<form action="registermem.do?action=namefind" method="post">
	<table border = "7">
		<tr><th>아이디</th><th>이름</th><th>주소</th><th>나이</th><th>전화번호</th></tr>
		<c:forEach items="${list }" var="memvo">
			<tr>
			<td>${memvo.id }</td>
			<td><a href = "main.do?action=meminfo&pid=${memvo.id }">${memvo.name }</a></td>
			<td>${memvo.addr }</td>
			<td>${memvo.age }</td>
			<td>${memvo.tel }</td>
			</tr>
		</c:forEach>
		<br>
			<%-- <tr><td><%= list.get(i).getId() %></td><td><a href = "main.do?action=meminfo&pid=<%=list.get(i).getId() %>"> <%= list.get(i).getName() %></a></td><td><%= list.get(i).getAddr() %></td><td><%= list.get(i).getAge() %></td><td><%= list.get(i).getTel() %></td></tr>
			<%} %> --%>
	</table>
	<input type="text" id="namefind" name="namefind"><input type="submit" value="이름검색">
	<a href = "login.html">로그아웃</a>
	</div>
</body>	
</html>