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

	<div>
		<div><h1>학생목록</h1></div>
		<div>
			<!-- ${students} -> model 객체에 담겨있는 변수. List<StudentVO> 타입으로 담겨있음 -->
			<c:forEach items="${students }" var="student">
				${student.id } :
				${student.name } :
				${student.address } :
				${student.tel } :
				${student.birthday } :
				${student.age } <br>
			</c:forEach>
		</div>
	</div>

</body>
</html>