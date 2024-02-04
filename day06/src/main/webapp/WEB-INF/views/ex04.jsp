<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>ex04 - 다중 파일 업로드(multiple)</h1>
<hr>


<!--	<p><input type="file" ..... multiple 
		
		multiple 을 적용해뒀기 때문에 한번에 여러 파일이 선택이 가능해짐 

 -->

<form method="POST" enctype="multipart/form-data">
	<p><input type="file" name="upload" multiple required></p>
	<p><input type="text" name="memo" placeholder="내용 설명"></p>
	<p><input type="submit" value="업로드"></p>

</form>


</body>
</html>