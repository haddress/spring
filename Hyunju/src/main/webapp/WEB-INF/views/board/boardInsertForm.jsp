<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
.label {
	width: 90px;
}
.trhe {
	height: 40px;
}
</style>
</head>
<body>
	<div id="container" align="center">
		<div>
			<form id="frm" action="boardInsert.do" method="post">
				<div>
					<table width="1000">
						<tr class="trhe">
							<th class="label">작성자</th>
							<td><input type="text" id="boardName" name="boardName" size="25"></td>
						</tr>
						<tr class="trhe">
							<th class="label">제 목</th>
							<td colspan="3"><input type="text" id="boardTitle" name="boardTitle" size="58"></td>
						</tr>
						<tr>
							<td colspan="4" style="padding:30px;"><textarea id="boardContent" name="boardContent" cols="130" rows="15"></textarea></td>
						</tr>
					</table>
				</div>	
				<div>
					<input type="submit" value="등록">
					<input type="reset" value="취소">
					<input type="button" value="목록" onclick="location.href='boardList.do'">
				</div>
			</form>
		</div>
	</div>
</body>
</html>