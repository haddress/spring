<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>게시글 등록</h1></div>
		<div>
			<form id="frm" action="boardInsert.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th>작성자</th>
							<td width="100"><input type="text" id="boardName" name="boardName" size="25"></td>
							<th>작성일자</th>
							<td width="100"><input type="date" id="boardDate" name="boardDate" width="200"></td>						
						</tr>
						<tr>
							<th>제 목</th>
							<td colspan="3"><input type="text" id="boardTitle" name="boardTitle" size="58"></td>
						</tr>
						<tr>
							<th>내 용</th>
							<td colspan="3"><textarea id="boardContent" name="boardContent" cols="60" rows="15"></textarea></td>
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