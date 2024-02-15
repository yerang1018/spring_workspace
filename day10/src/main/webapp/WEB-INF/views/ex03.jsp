<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ex03 - 회원 중복 가입 체크</h1>
<hr>

<p>
	<input type="text" name="userid" placeholder="ID" required autofocus>
	<button id="btn">중복 확인</button>
</p>

<h3 id="result"></h3>



<!-- 주소창에 내용이 노출되지 않는다는 이점  -->
<script>

	//	1) 이벤트의 대상이 될 요소를 불러온다
	const btn = document.getElementById('btn')

	//	2) 이벤트 발생 시 실행할 함수를 정의한다
	const clickHandler = function() {
		const userid = document.querySelector('input[name="userid"]').value
		const url = '${cpath}/ex03Ajax'			//	주소지정
		const opt = {							//	요청의 옵션들을 지정
				method : 'POST',				//	옵션 1) 요청 메서드는 POST
				
				body : JSON.stringify({			//	옵션 2) POST의 전달 내용은 userid 를 포함하는 객체를 JSON 문자열 형식으로 전달
					userid: userid
				}),					
				
				headers : {						//	옵션 3) 헤더, 전송하는 데이터의 형식 및 인코딩을 지정
					'Content-Type' : 'application/json; charset=utf-8'		//	자바스크립트에서는 -(대시) 를 사용하지 않기 때문에
																			//	사용해야할 경우에는 '' 따옴표로 묶어서 처리 
				},
		}
		
		fetch(url, opt)		//	요청 주소와 옵션을 함께 전달한다
			.then(resp => resp.json())
			.then(json => {
				console.log(json)
				const result = document.getElementById('result')
				result.innerText = json.msg
				if(json.count == 0) {
					result.style.color = 'blue'
				}
				else {
					result.style.color = 'red'
				}
			})
	}
	
	//	3) 이벤트 대상의 특정 상황 (클릭, 키, 스크롤 등)을 지정하여 이벤트 함수를 연결
	btn.onclick = clickHandler
	
	
</script>


</body>
</html>