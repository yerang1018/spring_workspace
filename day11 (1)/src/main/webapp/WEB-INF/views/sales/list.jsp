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

<h1>매출 목록</h1>
<hr>

<c:forEach var="dto" items="${list }">
	<div class="flex">
	
	<p>${dto.s_count }</p>
	<p>${dto.s_name }</p>
	</div>



</c:forEach>


</body>
</html>