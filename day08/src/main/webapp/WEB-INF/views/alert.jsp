<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<script>
	const msg = '${msg}'
	const e = '${e}'
	const url = '${url}'		//	url이 없으면 빈 문자열이 된다 
	const cpath = '${pageContext.request.contextPath}'
	
	alert(msg + ' : ' + e)
	if(url == '') {
		history.go(-1)		//	0으로 나눈다면 예외가 발생하면서 
							//	alert 메시지를 띄워주고, 
							//	이전 페이지로 되돌아감
	}
	else {
		location.href = cpath + url	
	}

</script>

</body>
</html>