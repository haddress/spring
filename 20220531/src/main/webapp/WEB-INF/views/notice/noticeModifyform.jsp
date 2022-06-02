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
		<div><h1>게시글 수정</h1></div>
		<div>
			<form id="frm" action="noticeModify.do" method="post" enctype="multipart/form-data">
				<input type="hidden" id="noticeId" name="noticeId" value="${notice.noticeId }">
				<div>
					<table border="1">
						<tr>
							<th width="100">작성자</th>
							<td width="150">${notice.noticeName }</td>
							<th width="100">작성일자</th>
							<td width="150">${notice.noticeDate }</td>						
						</tr>
						<tr>
							<th>제 목</th>
							<td colspan="3">
								<input type="text" id="noticeTitle" name="noticeTitle" size="58" value="${notice.noticeTitle }"></td>
						</tr>
						<tr>
							<th>내 용</th>
							<td colspan="3">
								<textarea id="noticeContents" name="noticeContents" cols="60" rows="15">${notice.noticeContents }</textarea></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="3"><input type="file" id="file" name="file"></td>
						</tr>
					</table>
				</div>	
				<div>
					<input type="submit" value="수정">&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='noticeList.do'">
				</div>
			</form>
		</div>
	</div>
</body>
</html>