<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	width: 1000px;
}
.label {
	width: 100px;
}
</style>
</head>
<body>
	<div id="container" align="center">
		<div>
			<table id="tb">
				<tr>
					<th class="label">작성자</th>
					<td>${b.boardName }</td>
				</tr>
				<tr>
					<th class="label">제  목</th>
					<td>${b.boardTitle }</td>
				</tr>
				<tr>
					<th class="label">작성일</th>
					<td>${b.boardDate }</td>
				</tr>
				<tr>
					<th class="label">조회수</th>
					<td>${b.boardHit }</td>
				</tr>
				<tr>
					<td colspan="2" style="padding:50px 50px 50px 30px;">${b.boardContent }</td>
				</tr>
			</table>
			<div>
				<button type="button" onclick="location.href='boardUpdateForm.do?boardId=${b.boardId }'">
					수정</button>
				<button type="button" onclick="deleteCheck()">
					삭제</button>
				<button type="button" onclick="location.href='boardList.do'">
					목록</button>
			</div>
		</div>
	</div>
</body>
<script>
	function deleteCheck() {
		if(confirm('정말 삭제하시겠습니까?') == true) {
			location.href='boardDelete.do?boardId='+${b.boardId };
		} else {
			return false;
		}
	}
</script>
</html>