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

<script>
	const url = '${url}'
	const msg = '${msg}'
	const cpath = '${cpath}'
	
	if(url == '') {
		alert('비밀번호 재설정에 실패하였습니다 \n 계정과 이메일을 확인하세요')
		history.go(-1)
	}
	else {
		alert(msg)
		location.href = cpath + url
	}


</script>

</body>
</html>