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

<script>
	const url = '${url}'
	const msg = '${msg}'
	const cpath = '${cpath}'
	
	if(url == '') {
		alert('실패')
		location.href = cpath 
	}
	else {
		alert(msg)
		location.href = cpath + url
	}


</script>

</body>
</html>