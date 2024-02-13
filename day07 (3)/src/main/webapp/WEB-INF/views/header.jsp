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
	ul > li {
		list-style: none;
		padding-left: 0px;
		text-decoration: none;
	}



</style>

</head>
<body>



<header>
	<h1><a href="${cpath }">day07</a></h1>
	
	<hr>
	<div class="flex">
	<ul>
		<li><a href="${cpath }/member/login">로그인</a></li>
		<c:if test="${login.userid == null }">
		<li><a href="${cpath }/member/join">회원가입</a></li>
		</c:if>
		<c:if test="${login.userid != null }">
		<div>${login.userid } 님 접속중</div> 
		<li><a href="${cpath }/member/logout">로그아웃</a></li>
		</c:if>
	</ul>
	</div>
	
	<nav class="flex">
		<ul>
			<li><a href="${cpath }/survey/add">설문등록</a></li>
			<li><a href="${cpath }/survey/list">설문참여</a></li>
			<li><a href="${cpath }/survey/result">설문결과</a></li>
		</ul>
	</nav>
</header>

