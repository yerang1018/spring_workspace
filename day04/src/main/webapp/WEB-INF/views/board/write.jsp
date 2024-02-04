<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
		width: 800px;
		margin: 20px auto;
	}

</style>

</head>
<body>

<h3>게시글 작성</h3>
<form method="POST">
	<table>
		<tr>
			<td><input type="text" name="title" placeholder="제목"></td>
		</tr>
		<tr>
			<td><input type="text" name="writer" value="${login.userid }" readonly></td>
		</tr>
		<tr>
			<td><textarea name="content" placeholder="내용을 작성" style="resize: none; width: 600px; height: 200px;"></textarea></td>
		</tr>
		
		<c:if test="${login.userid == 'admin' }">
		<tr>
			<td>
				<label>
					<input type="checkbox" name="isNotice" value="1">공지로 등록하기
				</label>	
			</td>
		</tr>
		</c:if>
		
	</table>
	<div>
		<input type="submit" value="작성 완료">
	</div>

</form>

</body>
</html>