<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty id }">
	<h1>${name } + ${message }</h1>
	<a href="studentLogout.do">로그아웃</a>
</c:if>
<c:if test="${empty id }">
	<h1>${message }</h1>
	<a href="studentLoginForm.do">로그인</a>
</c:if>
</body>
</html>