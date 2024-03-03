	//	HTML 문서를 불러오지 않아도 설정할 수 있는 전역변수 및 함수 정의
	
	
	function itemListClickHandler(event) {		//	이벤트 핸들러
		document.querySelectorAll('.menu > .item').forEach(item => {
			item.classList.remove('selected')
		})
		event.target.classList.add('selected')
	}
	
	
	function getDateStringFromLong(num) {		//	매개변수 : 자바스크립트에서는 자료형 없이 
		
		const days = ['일', '월', '화', '수', '목', '금', '토' ]
		const date = new Date(num)	
		
		let yyyy = date.getFullYear()
		let mm = date.getMonth() + 1
		let dd = date.getDate()
		let day = date.getDay()


	//	return yyyy + '년 ' + mm + '월 ' + dd + '일 '
		return `${yyyy}년 ${mm}월 ${dd}일 ${days[day]}요일`	 // 백틱이용해서 출력도 가능 
	}

	
	function getHTMLfromJson(json) {	//	json 은 배열, 배열 내부에는 idx / sDate / memo 속성이 있다
		let tag = ''
		tag += '<table>'
		tag += '	<thead>'
		tag += '		<tr>'
		tag += '			<th>번호</th>'
		tag += '			<th>날짜</th>'
		tag += '			<th>내용</th>'
		tag += '			<th>삭제</th>'
		tag += '		</tr>'
		tag += '	</thead>'
		tag += '	<tbody>'
		
		json.forEach(dto => {
			tag += `<tr>`
			tag += `	<td>${dto.idx}</td>`
			tag += `	<td>${getDateStringFromLong(dto.sDate)}</td>`
			tag += `	<td>${dto.memo}</td>`
			tag += `	<td><button class="delete" idx=${dto.idx}>삭제</button></td>`
			tag += `</tr>`
		})
		
		tag += `	</tbody>`
		tag += `</table>`
		
		return tag
	}
	
	async function menuClickHandler(event) {		//	async : 비동기함수		
		//	0) 반복문의 인덱스 대신, 이벤트 대상이 menu item의 몇번째인지 찾아낸다
		const arr = Array.from(document.querySelectorAll('.menu > .item'))
		const index = arr.indexOf(event.target)
					
		//	1) 어떤 주소로 요청을 보낼 것인가 결정
		const url = urls[index]
				
		//	2) 주소로 요청하여 json 데이터를 받아온다
		const json = await fetch(url).then(resp => resp.json())		//	await : await 가 걸린 async 함수는 
																				//	promise 타입이 아니라, 원본 그대로 반환된다 !!
		//	3) 받아온 json 을 HTML 태그 문자열로 변환			
		const tag = getHTMLfromJson(json)

		//	4) 태그를 삽입할 HTMLElement 를 찾아서 태그를 넣는다 
		const content = document.querySelector('#root > .content')
		content.innerHTML = tag
	}
	
	const submitHandler = event => {
			const ob = {
					sDate : event.target.querySelector('input[name="sDate"]').value ,
					memo : event.target.querySelector('input[name="memo"]').value,
			}
			const url =  cpath + '/schedules'
			
			const opt = {
					method: 'POST',
					body: JSON.stringify(ob),
					headers: {
						'Content-Type' : 'application/json; charset=utf-8'
					}
				}
				fetch(url, opt)
					.then(resp => resp.text())
					.then(text => {
						if(text == 1) {
							//	이벤트 강제 발생시키기
							const event = new Event('click')
							document.querySelector('.menu > .item').dispatchEvent(event)	//	querySelector 는 원래 첫번째 요소의 값을 가져옴
																							//	등록한 값을 바로 띄우기 
							close.dispatchEvent(event)
						}
						else {
							alert('정상적으로 등록이 되지 않았습니다')
						//	document.querySelector('input').focus()		focus 와 select 둘 다 가능 
							document.querySelector('input').select()	
						}
					})
		}
		
	
	
	
	