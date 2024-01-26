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
	<h3>회원가입</h3>
		<form method="POST">
			<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
			<p><input type="password" name="userpw" placeholder="PW" required></p>
			<p><input type="text" name="username" placeholder="Name" required autofocus></p>
			<p><input type="email" name="email" placeholder="email" required autofocus></p>
			<p><input type="submit" value="가입신청"></p>
		</form>		
</section>


</body>
</html>