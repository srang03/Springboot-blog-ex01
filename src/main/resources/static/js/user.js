let index = {
	init: function(){
		$('#btn-save').on("click", ()=>{
			this.save();
		});
	},
	
	save: function(){
		// alert('user의 save 함수 호출');
		let data = {
			user: $('#name').val(),
			password: $('#password').val(),
			email: $('#email').val()
		}
		
		$.ajax({
			type: "POST",
			url: "/blog/api/user",
			data: JSON.stringify(data), // body 데이터
			contentType: "application/json;charset=utf-8", // body 데이터 타입
			dataType:"json" // req 타입
		}).done(function(res){
			location.href="/blog";
		}).fail(function(error){
			console.log(JSON.stringify(error));
		}); // ajax 통신을 사용하여 3개의 파라미터를 json으로 변경하여 INSERT 요청 수행
		
	}
}

index.init();