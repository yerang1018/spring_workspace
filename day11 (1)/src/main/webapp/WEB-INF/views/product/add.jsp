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

<h1>상품 추가</h1>
<hr>

<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="name" placeholder="상품명" required autofocus></p>
	<p><input type="file" name="upload"></p>
	<p><input type="number" name="price" placeholder="가격" required></p>
	<p><input type="submit" value="상품 등록"></p>

</form>

</body>
</html>