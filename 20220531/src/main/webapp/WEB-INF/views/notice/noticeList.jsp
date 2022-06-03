<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jquery-3.6.0.min.js"></script>
<style>
table tr:hover {
	cursor: pointer;
	background: #ddd;
}
</style>
</head>
<body>
	<div align="center">
		<div>
			<h1>공지사항 목록</h1>
		</div>
		<div>
			<form id="frm" action="ajaxSearchList.do" method="post">
				<select id="state" name="state">
					<option value="1">전 체</option>
					<option value="2">작성자</option>
					<option value="3">제 목</option>
					<option value="4">내 용</option>
				</select>&nbsp; <input type="text" id="key" name="key">&nbsp;
				<button type="button" onclick="searchList()">검색</button>
			</form>
		</div>
		<br />
		<div>
			<table id="tb" border="1">
				<thead>
					<tr>
						<th width="70">순 번</th>
						<th width="150">작성자</th>
						<th width="300">제 목</th>
						<th width="150">작성일</th>
						<th width="70">조회수</th>
						<th width="70">첨부파일</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty notices }">
						<c:forEach items="${notices }" var="n">
							<tr onclick="eventList(${n.noticeId })">
								<td>${n.noticeId }</td>
								<td>${n.noticeName }</td>
								<td>${n.noticeTitle }</td>
								<td>${n.noticeDate }</td>
								<td>${n.noticeHit }</td>
								<td>${n.noticeAttech }</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty notices }">
						<tr>
							<td colspan="6" align="center">조회된 결과가 없습니다.</td>
						</tr>
					</c:if>
				</tbody>
			</table>
			<div>
				<form id="frm2" method="post">
					<input type="hidden" id="noticeId" name="noticeId">
				</form>
				<div></div>
				<button type="button" onclick="location.href='noticeInsertForm.do'">글
					등록</button>
			</div>
		</div>
	</div>
</body>

<!-- 그룹이벤트 생성(상세조회) -->
<script>
	function eventList(n) {
		//let list = document.querySelector('tbody');
		//list.addEventListener('click', function(ev) {
		//	if (ev.target.tagName === 'TD') {
				//console.log(ev.target.parentNode.children[0].textContent);
				//location.href = 'getContent.do?noticeId='+ev.target.parentNode.children[0].textContent;
				frm2.noticeId.value = n;
				frm2.action="getContent.do";
				frm2.submit();
		//	}
		//});
	}
	
	function searchList() {
		let state = $('#state').val(); // let state=document.getElementById("state").value
		let key = $('#key').val();
		
		// ajax의 기본타입
		$.ajax({
			url : "ajaxSearchList.do",
			type : "post", // 전송방식 (생략시 get)
			data : {"state" : state, "key" : key}, // 전달할 데이터
			dataType : "json", // 돌려받을 결과의 데이터 타입 (html, text, xml, json, jsonp)
			success : function(result) { // 성공했을때 실행할 함수 결과는 result에 담김
				// 수행할 영역 -> 콜백함수 만들기
				if(data.length>0) {
					htmlConvert(result);
				}
			},
			error : function() { // 실패했을때 수행할 함수
				alert('의도치 않은 오류가 발생했습니다.');
			}
		});
	}
	
	function htmlConvert(data) {
		$('tbody').remove(); // tbody 삭제
		let tbody = $('<tbody/>');
		$.each(data,function(index, n){ // 배열형태인 data로 each(반복), n이 한 행 이름
			var row = $("<tr onclick='eventList("+n.noticeId+")'/>").append(
				$("<td/>").text(n.noticeId),		
				$("<td/>").text(n.noticeName),		
				$("<td/>").text(n.noticeTitle),		
				$("<td/>").text(n.noticeDate),		
				$("<td/>").text(n.noticeHit),		
				$("<td/>").text(n.noticeAttech)
			);
			tbody.append(row); // 행 추가
		});
		$('#tb').append(tbody);
	}
</script>
<script type="text/javascript">
	/* function searchList() {
		let list = document.querySelector('tbody');
		fetch('ajaxSearchList.do', {
			method: 'POST',
			body : new FormData(document.getElementById('frm'))
		})
		.then(response => response.json())
		.then(data => {
				//list.remove();
				makeTr(data);
				data.forEach(n => {
					//console.log(makeTr(n));
					//list.append(makeTr(n));
					
					
			})
		})
	} */
	
	function makeTr(dataList) {
		/* let tr = document.createElement('tr');
		for (let field of obj) {
			let td = document.createElement('td');			
			td.innerHTML = obj[field];
			tr.append(td);
		}
		return tr; */
		let list = document.querySelector('tbody');
		let arr = ['noticeId', 'noticeName', 'noticeTitle', 'noticeDate', 'noticeHit', 'noticeAttech'];
		
		list.innerHTML = '';
		for(let data of dataList) {
			let mtr = document.createElement('tr');
			arr.forEach(v => {
				let mtd = document.createElement('td');
				mtd.innerText = data[v];
				mtr.appendChild(mtd);
			})
			list.appendChild(mtr);
		}
	}
	
</script>
</html>