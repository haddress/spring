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
	<div><h1>제품 등록</h1></div>
	<div>
		<form id="frm" action="productInsert.do" method="post" enctype="multipart/form-data">
			<div>
				<table border="1">
					<tr>
						<th width="100">제품코드</th>
						<td width="200">
							<input type="text" id="pcod" name="pcode" required="required">
						</td>
					</tr>
					<tr>
						<th width="100">제품명</th>
						<td width="200">
							<input type="text" id="pname" name="pname" required="required">
						</td>
					</tr>
					<tr>
						<th width="100">제조사</th>
						<td width="200">
							<input type="text" id="pbrand" name="pbrand" required="required">
						</td>
					</tr>
					<tr>
						<th width="100">제품단가</th>
						<td width="200">
							<input type="text" id="pamount" name="pamount" required="required">
						</td>
					</tr>
					<tr>
						<th width="100">판매가격</th>
						<td width="200">
							<input type="text" id="price" name="price" required="required">
						</td>
					</tr>
					<tr>
						<th width="100">제품이미지</th>
						<td width="200">
							<input type="file" id="file" name="file">
						</td>
					</tr>
				</table>
			</div><br>
			<input type="submit" value="저장">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소">
		</form>
	</div>
</div>
</body>
</html>