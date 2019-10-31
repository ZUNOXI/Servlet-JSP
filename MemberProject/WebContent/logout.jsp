<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function logout() {
	location.href="main.do?action=logout"
}
</script>
<style type="text/css">
#loginid{
	top:30px;
	right:30px
	position:fixed;
	border : 1px solod;
}</style>
</head>
<body>
    <div id="loginid">
		<h3>id : ${id }</h3>
		<button onclick="logout()">로그아웃</button>
	</div>
</body>
</html>