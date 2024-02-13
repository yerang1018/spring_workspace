<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div.title > p {
		padding: 30px;
	}

</style>
</head>
<body>

<h1>설문 목록</h1>

<hr>
<!-- /upload 로 경로가 잡혀있으니까 servlet-context 에서 upload 경로를 mapping 추가해주기  -->


<c:forEach var="dto" items="${list }">

	<div style="display: flex; flex-flow: wrap; width: 900px; margin: auto;">
		<div class="title">
			<p>${dto.sur_title }</p>
		</div>
		<div style="display: flex; flex-flow: wrap; width: 900px; margin: auto;">
		<p><img src="${cpath }/upload/${dto.sur_image_saved1 }" width="200px"></p>
		<p><img src="${cpath }/upload/${dto.sur_image_saved2 }" width="200px"></p>
		</div>
	<div style="display: block; flex-flow: wrap; width: 900px; margin: auto;">
	<form method="POST">
	<label>
		<input type="radio" name="cho_choice" value="1">${dto.sur_option1 }
		<input type="radio" name="cho_choice" value="2">${dto.sur_option2 }
	</label>
		<input type="hidden" name="cho_surveyNo" value="${dto.sur_no }">
		<input type="hidden" name="cho_surveyUserid" value="${login.userid }">
		<input type="submit" value="제출">
	

	</form>
	</div>
	</div>
	<a href="${cpath }/survey/result/${dto.sur_no}"><button>설문 결과</button></a>
</c:forEach>



	<details>
		<summary>설문 결과</summary>
			<li></li>
	</details>


	
</body>
</html>