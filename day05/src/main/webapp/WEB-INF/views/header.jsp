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
		header, section {
			width: 900px;
			margin: auto;
		}
	
	</style>

</head>
<body>

<header>
	<h1><a href="${cpath }">day05</a></h1>
	
	<!--  	<h3>스프링 인터셉터</h3>
	<h5>프로젝트 내부 하위 각 주소에 대해 요청을 가로채서 <br>
	특정 작업을 수행하고 다른 쪽으로 응답보내거나, 그대로 사용할 수 있는 스프링 객체</h5> -->

	<div id="login" style="height: 40px; text-align: right;">
		<c:if test="${not empty login }">
		<p>
			${login.username } 님 로그인 중
			<a href="${cpath }/member/logout"><button>로그아웃</button></a>
		</p>
		</c:if>
	</div>
	
	<nav>
		<ul style="display: flex; padding: 0; list-style: none; justify-content: space-around;">
			<li><a href="${cpath }/member/list">회원목록</a></li>
			<li><a href="${cpath }/member/login">로그인</a></li>
			<li><a href="${cpath }/board/list">게시판</a></li>

		</ul>
	</nav>
	
	
</header>
