<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>상품 매출 관리</h1>
<hr>

<h3>오늘은 <fmt:formatDate value="${today }" pattern="yyyy년  MM월 dd일" /> 입니다</h3>


<ul>
	<li><a href="${cpath }/product/list">상품 목록</a>
	<li><a href="${cpath }/product/add">상품 추가</a>
	<li><a href="${cpath }/sales/list">매출 목록</a>

</ul>

</body>
</html>