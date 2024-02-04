<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>





<section>
	<h3>정보 수정</h3>
		<form method="POST">
			<p><input type="text" name="userid" placeholder="ID" value="${dto.userid }" required readonly></p>
			<p><input type="password" name="userpw" placeholder="PW" value="${dto.userpw }" required></p>
			<p><input type="text" name="username" placeholder="Name" value="${dto.username }" required autofocus></p>
			<p><input type="email" name="email" placeholder="email" value="${dto.email }" required autofocus></p>
			<p><input type="submit" value="저장"></p>
		</form>		
</section>


</body>
</html>