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

<h1>ex03 - DTO 를 활용한 업로드 + DB 저장</h1>

<form method="POST" enctype="multipart/form-data">
	<input type="file" name="upload">	<!-- 이때ㅡ upload 는 private MultipartFile의  Name과 같아야함  -->
	<p><input type="text" name="memo" placeholder="파일 간단 설명"></p>
	<input type="submit">
</form>

<!--  이 form 을 제출하면 POST 메서드에 의해서 Controller로 전달 -> Controller 는 POSTMapping 에 의하여 DTO 와 일치하는 애들을 불러와서 Service 로 전달 ->
	 Service는 UUID 를 사용하여 새로운 이름의 파일로 DB에 저장할 문자열들로 구성하여 Controller 로 전달 -> Controller 에서 GETMapping 에 의하여 리스트를 보여준다 -->

<div style="display: flex; flex-flow: wrap; width: 900px; margin: auto;">
	<c:forEach var="dto" items="${list }">
		<div class="item" style="margin: 10px; text-align: center; width: 200px; background-color: #eee;">
			<p><img src="${cpath }/upload/${dto.storedFileName}" height="150"></p>
			<p>${dto.idx } | ${dto.memo }</p>
			<p>${dto.uploadDate }</p>
			<p>
			
				<!-- target="_blank" 는 새창을 띄워주는건데 , 지금은 download 를 걸어놨기 때문에 적용되지 않음 -->
				<a href="${cpath }/upload/${dto.storedFileName}"
					target="_blank"
					download="${dto.originalFileName }"><button>다운로드</button></a>
					
				
				<!--  삭제시 유의점 : DB에 있는 데이터 뿐만 아니라, upload 에 있는 이미지 파일도 같이 삭제되어야한다 -->
				<a href="${cpath }/ex03/delete/${dto.idx}"><button>삭제</button></a>
			</p>
		</div>
	
	</c:forEach>

</div>



<!--  ex03.jsp 에서 rttr.addFlashAttribute("msg", row != 0 ? "삭제 성공" : "삭제 실패") 에 의해서 msg가 생기면 스크립트로 msg 띄우기   -->
<c:if test="${not empty msg }">
	<script>
		alert('${msg}')
	
	</script>

</c:if>
	 
	 
	 
	 
</body>
</html>