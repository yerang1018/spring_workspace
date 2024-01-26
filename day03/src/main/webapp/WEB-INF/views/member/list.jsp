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
	<h3>회원목록</h3>

	<table border="1" cellpadding="10" cellspacing="0">
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.idx }</td>
				<td>${dto.userid }</td>
				<td>${dto.userpw }</td>
				<td>${dto.username }</td>
				<td>${dto.email }</td>
				<td><a href="${cpath }/member/${dto.idx }"><button>상세보기</button></a></td>
				<td><a href="${cpath }/member/delete/${dto.idx }"><button>삭제</button></a></td>
			</tr>
		</c:forEach>
	</table>
</section>

</body>
</html>