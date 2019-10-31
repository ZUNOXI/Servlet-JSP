<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!  %>
<%  String result = (String)request.getAttribute("result"); 
	if(result == null){
		result = request.getParameter("result");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>결과화면</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<style type="text/css">
body{
width:300px;
margin: 0 auto;
}
table{
border:5px solid red;
}

</style>
</head>
<body>
	<h1 style="text-align:center;">회원가입 결과</h1>
	<table>
	<tr>
		<td><h3><%= result %></h3></td>
	</tr>	
	</table>
	<br>
	<div class="form-group text-center">
		<button type="button" id="modal_close_btn" onclick="location.href='Index.html' "
		class="btn btn-primary">닫기</button>
		<br>
	</div>
</body>
</html>