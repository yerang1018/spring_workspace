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

<h1>add</h1>
<hr>

<form method="POST">
	<p>
		<label><input type="radio" name="category" value="버거" autofocus>버거</label>
		<label><input type="radio" name="category" value="음료">음료</label>
	</p>
	<p><input type="text" name="name" placeholder="name" required></p>
	<p><input type="number" name="price" placeholder="price" required></p>
	<p><input type="text" name="memo" placeholder="memo" required></p>
	<p><input type="text" name="imgName" placeholder="image" required></p>
	<p><input type="submit" value="추가"></p>
</form>


</body>
</html>