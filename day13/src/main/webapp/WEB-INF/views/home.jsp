<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/style.css">

<script>

	const cpath = '${cpath}'
		const urls = [ 
				'http://192.168.112.31:8080/day13/schedules', 
				'http://192.168.112.7:8080/day13/schedules',
				'http://192.168.112.24:8080/day13/schedules', 
				'http://192.168.112.18:8080/day13/schedules', 
				'http://192.168.112.17:8080/day13/schedules',
				'http://192.168.112.13:8080/day13/schedules',
				'http://192.168.112.22:8080/day13/schedules',
			]
</script>


<script src="${cpath }/resources/js/function.js">

</script>


</head>
<body>


<h1>day13</h1>
<hr>


<div id="modal" class="hidden">
	<div class="content">
		<form id="addForm">
			<h3>일정 추가하기</h3>
			<p><input type="text" name="memo" placeholder="메모" required></p>
			<p><input type="date" name="sDate" required></p>
			<p>
				<input type="submit" value="등록">
				<input id="close" type="button" value="돌아가기">
			</p>
		</form>
	</div>
	<div class="overlay"></div>
</div>

<div class="buttons">
	<button id="open">일정 추가</button>
</div>

<div id="root">
	<div class="menu">
		<div class="item selected">예랑</div>
		<div class="item">선생님</div>
		<div class="item">현웅</div>
		<div class="item">민정</div>
		<div class="item">진호</div>
		<div class="item">제은</div>
		<div class="item">유빈</div>
	</div>
	<div class="content">
		<img src="${cpath }/resources/image/loading.gif">
	</div>
</div>


<script>
	
	//	문서가 모두 불러지면 특정 요소를 호출하여 이벤트를 연결하는 함수
	function loadHandler() {
		//	상단 메뉴를 클릭했을 때 스타일 옮겨가는 내용
		const itemList = document.querySelectorAll('.menu > .item')		//	이벤트 대상
		itemList.forEach(element => element.addEventListener('click', itemListClickHandler))
		
		//	상단 메뉴를 클릭했을때 fetch 로 데이터를 불러와서 div#root > div.content 에 내용 띄우기 
		itemList.forEach(element => element.addEventListener('click', menuClickHandler)) //	콜백함수가 계속 중첩되면 관리하기 힘들다

		
		//	열기, 닫기 버튼에 모달 작동 연결
		const modal = document.getElementById('modal')
		
		const btns = [
			document.getElementById('open'),
			document.getElementById('close'),
			document.querySelector('div.overlay')
		]
		
		btns.forEach(b => b.onclick = event => modal.classList.toggle('hidden'))
	
		
		
		
		//	form을 제출하면 자신의 서버에 POST 로 등록하기
		const form = document.forms[0]
		
		
		form.onsubmit = submitHandler		//	form.onsubmit 에다가 submitHandler 를 대입하기 
	
	}
			
	

	window.addEventListener('DOMContentLoaded', loadHandler)
	



</script>


















</body>
</html>