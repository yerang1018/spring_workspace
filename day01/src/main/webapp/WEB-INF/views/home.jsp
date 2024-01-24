<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<h3>접속된 DB 버전 : ${version }</h3>
<h3>${sysdate }</h3>

<a href="member"><button>member</button></a>

</body>
</html>
