<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <c:if test="${4>3 }">
	4 는 3보다 크다
${memberList}

<c:forEach begin="1" end="10" step="1" varStatus="st">
	Hello
	${st.index}<br>
	</c:forEach>	
</c:if> --%>
<c:choose>
	<c:when test="${empty id }">
	<form action = "member.do">
		아이디 : <input type="text" name = "userid"> <br>
		패스워드 : <input  type="text" name = "pwd"> <br>
		<input type="hidden" name="action" value="login">
		<input type="submit" value="로그인">
	</form>	
	</c:when>
	<c:otherwise>
		${id }님 안녕하세요
		<input type="button"  value="로그아웃"
		onclick = "location.href='member.do?action=logout'">
	</c:otherwise>
</c:choose>
<table border="7">
<tr> 
	<td width = "200">이름</td>
	<td width = "200">아이디</td>
	<td width = "200">이메일</td>
</tr>
<tr>
	<td colspan="3" bgcolor="pink"></td>
</tr>		
	<c:forEach items="${memberList}" var="member">
	<tr>
		<td><a href="member.do?action=viewMember&userid=${member.userid }">${member.name }</a></td>
		<td>${member.userid }</td>
		<td>${member.email }</td>
	</tr>
</c:forEach>
<tr>
	<td colspan="3" bgcolor="pink"></td>
</tr>
<tr>
	<td colspan="3"><input onclick = "location.href='member.do?action=addMemberForm'" type ="button" value ="회원가입"></td>
</tr>
</table>
</body>
</html>