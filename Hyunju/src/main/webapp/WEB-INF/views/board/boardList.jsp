<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jquery-3.6.0.min.js"></script>
<style>
@import url('https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css');

* { 
font-family: Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo', 'Noto Sans KR', 'Malgun Gothic', sans-serif;
}
#container {
	width: 1000px;
	margin: 20px auto;
}
#tb {
	margin-top: 10px;
	border-collapse: collapse;
	width: 1000px;
}
#tableth {
	border-top:	1px solid black;
	border-bottom: 1px solid black;
}
#tableth th {
	text-align:center;
	background: black;
	color: white;
}
.tablecon {
	border-bottom: 1px solid #ddd;
	height: 40px;
}
tr td {
	text-align:center;
}
.write {
	margin-top: 10px;
	text-align: right;
}
.hov:hover {
	color: #ddd;
}
</style>
</head>
<body>
	<div id="container">
	<div align="center">
		<form id="search" action="cateSearchList.do" method="post">
			<select id="state" name="state">
				<option hidden value="1">전 체</option>
				<option value="2">전 체</option>
				<option value="3">제 목</option>
				<option value="4">작성자</option>
				<option value="5">글내용</option>
			</select>&nbsp;
			<input type="text" id="key" name="key">&nbsp;
			<button type="button" onclick="searchBoard()">검색</button>
		</form>
	</div>
	<br>
	<div align="center">
		<table id="tb">
			<thead>
				<tr id="tableth">
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty boards }">
					<c:forEach var="b" items="${boards }">
						<tr class="tablecon">
							<td width="60">${b.boardId }</td>
							<td onclick="boardDetail(${b.boardId})" class="hov">${b.boardTitle }</td>
							<td width="80">${b.boardName }</td>
							<td width="60">${b.boardHit }</td>
							<td width="150">${b.boardDate }</td>
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
			<form id="add" action="boardInsertForm.do">
				<input type="hidden" id="boardId" name="boardId">
			</form>
			<div class="write">
				<button type="button" onclick="location.href='boardInsertForm.do'">WRITE</button>
			</div>
		</div>
	</div>
	</div>
</body>
<script>
	function boardDetail(num) {
		add.boardId.value = num;
		add.action='boardDetail.do';
		add.submit();
	}

	function searchBoard() {
		let state = $('#state').val();
		let key = $('#key').val();
		
		$.ajax({
			url : "cateSearchList.do",
			type : "post",
			data : {"state" : state, "key" : key},
			dataType : "json",
			success : function(result) {
				if(result.length>0) {
					dataOut(result);
				}
			},
			error: function() {
				alert('잘못된 접근입니다.')
			}
		})
	}
	
	function dataOut(data) {
		$('tbody').remove();
		let tbody = $('<tbody/>');
		$.each(data,function(index, b) {
			var row = $('<tr class="tablecon"/>').append(
				$("<td width='60'/>").text(b.boardId),
				$("<td onclick='boardDetail("+b.boardId+")' class='hov'/>").text(b.boardTitle),
				$("<td width='80'/>").text(b.boardName),
				$("<td width='60'/>").text(b.boardHit),
				$("<td width='150'/>").text(b.boardDate)
			)
			tbody.append(row);
		})
		$('#tb').append(tbody);
	}
</script>
</html>