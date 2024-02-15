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


<h1>상품 목록</h1>

<div class="frame productList">
<c:forEach var="dto" items="${list }">
	<div class="flex box">
		<img src="${cpath }/upload/${dto.save_img}" height="250px">
		<p class="bold">${dto.name }</p>
		<p class="sp">${dto.price }</p>
		<p class="sp">${dto.count }</p>
		<p><a href="${cpath }/product/update/${dto.idx}"><button>수량 변경</button></a>
		<p><a href="${cpath }/product/delete/${dto.idx}"><button>삭제</button></a>
		
	</div>
</c:forEach>
</div>


</body>
</html>