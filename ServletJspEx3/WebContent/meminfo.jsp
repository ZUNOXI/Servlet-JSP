<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "edu.ssafy.model.MemVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<% MemVO mem = (MemVO)request.getAttribute("mem"); %>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 조회</title>
<script type="text/javascript">
	function updatemem() {
		rform.submit();
	}
	function deletemem() {
		var id = pid.value;
		location.href="main.do?action=deletemem&pid="+id;
	}
	
</script>
</head>
<body>
	<div align="center">
	<h1>회원정보</h1>
	<form action="main.do?action=updatemem" method = "post" id = "rform">
		<table>
			<tr><td>아이디: </td><td><input type = "text" name = "pid" id = "pid" value = '${mem.id }' readonly="readonly"></td></tr>
			<tr><td>이름: </td><td><input type = "text" name = "pname" id = "pname" value = <%= mem.getName() %>></td></tr>
			<tr><td>비번: </td><td><input type = "password" name = "ppw" id = "ppw" value = <%= mem.getPw() %>></td></tr>
			<tr><td>주소: </td><td><input type = "text" name = "paddr" id = "paddr" value = <%= mem.getAddr() %>></td></tr>
			<tr><td>나이: </td><td><input type = "number" name = "page" id = "page" value = <%= mem.getAge() %>></td></tr>
			<tr><td>전화번호: </td><td><input type = "tel" name = "ptel" id = "ptel" value = <%= mem.getTel() %>></td></tr>
			<tr><td colspan = "2">
			<input type = "button" value = "수정" onclick = "updatemem()">
			<input type = "reset" value = "삭제" onclick = "deletemem()"></td></tr>
		</table>
	</form>
	<a href = "login.html">로그아웃</a>
	</div>
</body>
</html>