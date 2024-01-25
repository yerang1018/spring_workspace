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
	.flex {
		display: flex;
		padding-top: 10px;
	}
	div.box {
		border: 1px solid #eee;
		padding: 10px 0px;
	}
	div.buttons {
		padding: 20px 5px;
	}
	div.sp {
		padding: 10px 0px;
	}
	.sb {
		display: flex;
		justify-content: space-between;
	}
</style>


</head>
<body>


	<div class="box flex">
		<div>
			<div>${dto.idx }</div>
			<div><img src="${cpath }/resources/image/${dto.imgName }" height="100"></div>
		</div>
		<div style="width: 800px">
			<div class="sb">
				<div>${dto.category }</div>
			</div>
			<div>${dto.name }</div>
			<div>${dto.price }</div>
			<div>${dto.memo }</div>
			<div class="sp"><a href="modify/${dto.idx }"><button>수정</button></a></div>
		</div>
	</div>




</body>
</html>