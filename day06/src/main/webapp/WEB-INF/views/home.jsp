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



<h1>파일 업로드</h1>
<hr>

<fieldset>
	스프링에서의 MultipartRequest 는 이름만 같을 뿐 <br>
	jsp의 MultipartRequest 와는 다른 클래스이다<br>
	목적은 같지만 다름 
</fieldset>


<ul>
	<li><a href="${cpath }/ex01">ex01 - MultipartRequest</a></li>
	<li><a href="${cpath }/ex02">ex02 - MultipartFile</a></li>
	<li><a href="${cpath }/ex03">ex03 - DTO</a></li>
	<li><a href="${cpath }/ex04">ex04 - multiple(외래키 없이)</a></li>
</ul>

</body>
</html>