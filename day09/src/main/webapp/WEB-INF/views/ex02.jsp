<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#root {
		width: 900px;
		margin: 20px auto;
	}
	.item {
		width: 800px;
		margin: 10px auto;
		border: 1px solid grey;
		padding: 10px;
	}


</style>



<script>
	const cpath = '${cpath}'		//	JSP 의 변수를 자바 스크립트에 먼저 선언해둔다 
</script>

<!-- 작성된 자바스크립트를 불러온다 == festival.js 파일 -->
<script type="text/javascript" src="${cpath }/resources/js/festival.js"></script>


</head>
<body>


<h1>ex02 - AJAX 로 API 데이터 요청하여 출력하기</h1>
<hr>

<h3>AJAX : Asynchoronous Javascript And XML</h3>
<!--  AJAX 는 
	이미 jsp 에서 다 보여주고 있는 상황이라도
	사용자에게 이벤트 받고, 그에 맞는 처리를 하기 위해 사용됨 
 -->


<p><button id="run">실행</button></p>	<!--  사용자에게 어떠한 이벤트(= 클릭) 를 부여받고나서   함수가 실행되게 만든 코드   : 사용자의 상호작용을 통해서 불러오는 -->



<div id="root"></div>	<!--  root.innerHTML = text 때문에
							비어있던 div 태그(== root)에 들어감 
							
							즉, <div id="root"> ★ 이 공간 사이로 들어온다는 것★  </div> -->


<script>
	//	문서에서 이벤트 대상 요소(HTML element) 를 불러온다
	const run = document.getElementById('run')
	
	//	이벤트가 발생하면 실행할 함수를 정의한다 (.js 파일에서 정의하는 것이 더 좋다)
	const clickHandler1 = async function(event) {					//	실행 버튼 클릭 -> Handler1 호출 -> Handler2 호출 
		alert('테스트')
		
		const text = await clickHandler2()	//	jsp 안에 있는 Handler1 함수가 	script 내부에 있는 Handler2 함수를 호출 
		console.log(text)
		root.innerHTML = text
	}
	
	
	
	//	문서 요소의 특정 조건에 함수를 연결한다 (클릭하면 실행되도록 연결)
	run.onclick = clickHandler1

</script>

</body>
</html>