<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--  아이디와 이메일을 입력하면, 비밀번호를 랜덤으로 재발급 : 임시 비밀번호  (DTO 로 데이터 받아서 처리하기)-->
<section>
	<h3>비밀번호 재설정</h3>
	
	<form method="POST">
		<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
		<p><input type="email" name="email" placeholder="email" required></p>
		<p><input type="submit" value="발급"></p>
	</form>
</section>

</body>
</html>