<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>day09</h1>
<hr>


<h3>JSON : JavaScript Object Notation</h3>
<h3>자바스크립트에서 객체를 표현할때 사용하는 문법</h3>


<fieldset>
	<legend>XML</legend>
	<pre>
		&lt;person>
			&lt;name>이지은&lt;/name>
			&lt;age>31&lt;/age>
		&lt;/person>
	</pre>
</fieldset>

<br>

<fieldset>
	<legend>JSON</legend>
	<pre>
		{
			"person" : {
				"name" : "이지은",
				"age"  : 31,
			}
		}
	</pre>
</fieldset>

<h3>다른 시스템과 연동을 위해서는 이런 문법도 사용할 줄 알아야함(표준 포맷 : JSON, XML)</h3>


<ul>
	<li><a href="ex01">ex01 - 부산 축제 정보 서비스</a>
	<li><a href="ex02">ex02 - 부산 축제 정보 서비스 (AJAX)</a>

</ul>






<script>
	//	변수 선언 키워드 	(var, let, const : 자료형이 아님)
	
	t0 = 'Hello'		//	변수선언 키워드가 없으면 모호함 (변수인지 아닌지모름)

	var t1 = 'A'		//	var 는 함수 밖에서 선언해도 함수 내부에서 재선언 및 재할당이 가능
						//	변수 이름을 중복해서 사용하지 않는다면 이론적으로는 큰 문제가 안됨 
	
	
	let t2 = 15			//	let 은 재할당 가능
	
	
	const t3 = 3.2		//	const 는 재할당 불가능 (상수화된 변수)  == 메모리 효율 좋음 !!
	
	
	console.log(t1)		//	브라우저 - 개발자도구 - 콘솔창에 출력됨!
	console.log(t2)
	console.log(t3)
	
	
	if(t2 > 10) {
		var t1 = 'Apple'
	}
	console.log(t1)		//	기존의 t1을 덮어씀 (이런 문제 때문에 변수이름은 중복시키지말자. = 매개변수 이름도 중복될 수 있다)
						//	가급적이면 var도 쓰지말자
						
	
						
	//	자료형 확인하기 					
	console.log(typeof(t1))		//	string
	console.log(typeof(t2))		//	number
	console.log(typeof(t3))		//  number
	console.log(typeof([]))		//	object (array)
	console.log(typeof({}))		//	object	
	console.log(typeof(function(){}))		//	★ 	function, JS 에서는 함수도 자료형이며 변수에 대입할 수 있다 
											//	★ 	즉, 함수 그 자체를 매개변수로 사용할 수 있다 
	
	
	const t4 = {				//	가장 유사한 collection == Map 
		"name" : "이지은",		//	Map<String, Object>
		"age"  : 31
	}
	
	//	t4 자체가 객체 형태로 출력됨 
	console.log(t4)
	
	console.log(t4.name)
	console.log(t4.age)
	
	
	//	자바스크립트에서는
	//	필드명에 따옴표 없어도 됨  | 문자열에 작은 따옴표 사용 가능 
	const t5 = {
		name : '홍진호',			//	단, JSON 문법으로 나타내기 위해서는 key 를 "" 로 묶어야한다
		age  : 41,
		show : function() {	console.log(this.name + '님은 ' + this.age + '살 입니다') }
	}
	
	console.log(t5)
	console.log(t5.name)		//	객체.필드명 
	console.log(t5.age)
	t5.show()
	
	//	자바 스크립트 객체를 JSON 문법의 문자열로 변환하는 함수 및 되돌리는 함수가 내장되어있음
	const t6 = JSON.stringify(t4)		//	객체를  ->  JSON 문자열로 변환하는 함수 
	const t7 = JSON.parse(t6)			//	JSON 문자열  ->  객체로 변환 
	
	
	console.log(t6, typeof(t6))			
	console.log(t7, typeof(t7))
	
	
</script>







</body>
</html>