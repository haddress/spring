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
<div align="center">
	<div><h1>회원목록</h1></div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th width="150">아이디</th>
					<th width="150">이  름</th>
					<th width="150">전화번호</th>
					<th width="200">주  소</th>
					<th width="150">Email</th>
					<th width="150">권  한</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members }" var="member">
					<tr>
						<td>${member.id }</td>
						<td>${member.name }</td>
						<td>${member.tel }</td>
						<td>${member.adr }</td>
						<td>${member.email }</td>
						<td>${member.author }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>