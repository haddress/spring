<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<br />
		</div>
		<div>
			<!-- 메뉴부분 -->
			<ul>
				<li><a class="active" href="main.do">Home</a></li>
				<c:if test="${empty id}">
					<li><a href="memberLoginForm.do">Login</a></li>
				</c:if>
				<c:if test="${not empty id}">
					<li><a href="memberLogout.do">LogOut</a></li>
				</c:if>
				<li><a href="productList.do">Product</a></li>
				<li><a href="#">About</a></li>
				<li><a href="memberInsertForm.do">MeberJoin</a></li>
				<li><a href="#">Service</a></li>
				<c:if test="${author eq 'ADMIN' }">
					<li><a href="memberSelectList.do">Members</a></li>
				</c:if>
				<c:if test="${not empty name }">
					<li class="logname">${name } 입장</li>
				</c:if>
			</ul>			
		</div>
	</div>
</body>
</html>