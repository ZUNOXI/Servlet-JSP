<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름: ${member.name }<br>
	아이디: ${member.userid }<br>
	이메일: ${member.email }<br>
	폰번호: ${member.phone }<br>
	<input type ="button" value="메인으로"
	onclick="location.href='member.do?action=main'">
</body>
</html>