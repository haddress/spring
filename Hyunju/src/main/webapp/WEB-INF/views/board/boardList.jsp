<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form id="frm" action="ajaxSearchList.do" method="post">
			<select id="state" name="state">
				<option value="1">전체</option>
				<option value="2">제목</option>
				<option value="3">작성자</option>
			</select>&nbsp;
			<input type="text" id="key" name="key">&nbsp;
			<button type="button" onclick="searchBoard()">검색</button>
		</form>
	</div>
	<br>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>글번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>조회수</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty boards }">
					<c:forEach var="b" items="${boards }">
						<tr>
							<td>${b.boardId }</td>
							<td>${b.boardName }</td>
							<td>${b.boardTitle }</td>
							<td>${b.boardHit }</td>
							<td>${b.boardDate }</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty boards }">
					<tr>
						<td colspan="5"><h4>등록된 게시글이 없습니다.</h4></td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<div>
			<form id="frm2">
			
			</form>
		</div>
	</div>

</body>
</html>