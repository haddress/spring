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
	<div><h1>제품 전체 목록</h1></div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th width="100">제품번호</th>
					<th width="150">제품명</th>
					<th width="150">회사명</th>
					<th width="100">단 가</th>
					<th width="100">판매가격</th>
					<th width="100">이미지</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products }" var="p">
					<tr>
						<td>${p.pcode }</td>
						<td>${p.pname }</td>
						<td>${p.pbrand }</td>
						<td>${p.pamount }</td>
						<td>${p.price }</td>
						<td><img src="${p.pimg}"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div><br>
	<c:if test="${author eq 'ADMIN' }"> <!-- 어드민 만 상품등록 가능 -->
		<div>
			<button type="button" onclick="location.href='productInsertForm.do'">제품등록</button>
		</div>
	</c:if>
</div>
</body>
</html>