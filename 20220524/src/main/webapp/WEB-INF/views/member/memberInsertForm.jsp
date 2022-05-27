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
	<div><h1>회원가입</h1></div>
	<div>
		<form id="frm" action="memberJoin.do" onsubmit="return formCheck()" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">아이디</th>
						<td width="300">
							<input type="text" id="id" name="id" required="required">&nbsp;
							<button type="button" onclick="idCheck()" id="btn">중복체크</button>
							<input type="hidden" id="checkId" value="N">
						</td>
					</tr>
					<tr>
						<th width="150">패스워드</th>
						<td width="200">
							<input type="password" id="pass" name="pass" required="required">
						</td>
					</tr>
					<tr>
						<th width="150">패스워드확인</th>
						<td width="200">
							<input type="password" id="pass1" required="required">
						</td>
					</tr>
					<tr>
						<th width="150">이  름</th>
						<td width="200">
							<input type="text" id="name" name="name" required="required">
						</td>
					</tr>
					<tr>
						<th width="150">전화번호</th>
						<td width="200">
							<input type="text" id="tel" name="tel">
						</td>
					</tr>
					<tr>
						<th width="150">주   소</th>
						<td width="200">
							<input type="text" id="adr" name="adr">
						</td>
					</tr>
					<tr>
						<th width="150">이메일</th>
						<td width="200">
							<input type="email" id="email" name="email">
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="회원가입">&nbsp;&nbsp;
				<input type="reset" value="취 소">
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">

	function idCheck() {
		let id = frm.id.value;  //or document.getElementById("id")
		// ajax 처리하면 됨
		fetch("ajaxIdCheck.do?id="+id,{
			method : 'GET',			
		}).then((response) => {
			return response.text()
			.then((data) => {
				if(data != 'N') {
					alert(id + "는 사용할 수 있는 아이디 입니다.");
					const target = document.getElementById('btn');
					target.disabled = true;
					frm.checkId.value = data;
				}else{
					alert(id + "는 사용할 수 없습니다.");
					frm.id.value = "";
					frm.id.focus();
				}
			})
		});
	}
	
	function formCheck() {
		if(frm.checkId.value == 'N'){
			alert("아이디 중복체크를 하세요");
			return false;
		}
		
		if(frm.pass.value != frm.pass1.value) {
			alert("패스워드가 일치 하지 않습니다.");
			frm.pass.value="";
			frm.pass1.value="";
			frm.pass.focus();
			return false;
		}
		
		return true;
	}
</script>
</body>
</html>