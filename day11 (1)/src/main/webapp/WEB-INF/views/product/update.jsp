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

<h1>상품 수량 수정</h1>
<hr>

<form method="POST">
	<p><input type="text" name="name" value="${dto.name }"></p>
	<p><input type="number" min="0" max="500" step="1" name="count" value="${dto.count }"></p>
	<p><input type="submit" value="수정"></p>
	<input type="hidden" name="idx" value="${dto.idx }">

</form>

</body>
</html>