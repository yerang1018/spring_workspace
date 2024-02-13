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

<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="sur_title" placeholder="title"></p>
	<p>
		<input type="file" name="upload1">
		<input type="text" name="sur_option1" placeholder="option">
	</p>
	<p>
		<input type="file" name="upload2">
		<input type="text" name="sur_option2" placeholder="option">
	</p>
	<p><input type="submit" value="등록"></p>
	<p><input type="hidden" value="${login.userid }" name="sur_writer"></p>
</form>


</body>
</html>