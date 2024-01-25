<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.flex {
		display: flex;
		padding-top: 10px;
	}


</style>
</head>
<body>

<div>

	<c:forEach var="dto" items="${list }">
		
	<div class="flex">
		<div>
			<div>${dto.idx }</div>
			<div><img src="${cpath }/resources/image/${dto.imgName }" height="100"></div>
		</div>
		<div>
			<div>${dto.category }</div>
			<div>${dto.name }</div>
			<div>${dto.price }</div>
			<div>${dto.memo }</div>
		</div>
	</div>
	</c:forEach>
</div>




</body>
</html>