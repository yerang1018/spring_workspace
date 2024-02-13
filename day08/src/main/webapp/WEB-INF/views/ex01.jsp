<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ex01 - 두 정수의 사칙 연산</h1>
<hr>

<!--  input 에 required 를 적용 시켜놓으면   NullpointerException 은 피해갈 수 있음 !! -->


<!--  보여지는것은 기호들인데, 실제로 전달되는 값은 PLUS , MINUS .. 가 전달되는 것이다  -->
<!--  option value="" 로 한다면, value 값이 없기 때문에 아무것도 선택되지 않음을 뜻함 -->
<form method="POST">
	<p>
		<input type="number" name="n1" min="0" max="100" required autofocus>
		<select name="operator" required>
		
			<option value="">== 연산자 선택 ==</option>
			<option value="PLUS">+</option>
			<option value="MINUS">-</option>
			<option value="MULTI">*</option>
			<option value="DIVIDE">/</option>
		</select>
		<input type="number" name="n2" min="0" max="100" required>
		<input type="submit" value="=">
	</p>
</form>

</body>
</html>