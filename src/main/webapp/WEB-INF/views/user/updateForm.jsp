<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container">
	<div class="d-flex justify-content-center" style="height: 300px;">
		<div>
			<h3>회원 수정</h3>
			<form>
				<input  type="hidden" id="id" value="${id}" /> 
				<input style="margin-bottom: 20px; margin-top: 20px" type="text" value="${principal.user.username}" placeholder="Username"
					id="username" readonly="readonly" /><br />
				<input style="margin-bottom: 20px;" type="password" value="" placeholder="Password" id="password" /><br />
				<input style="margin-bottom: 20px;" type="email" value="${principal.user.email}" placeholder="Email" id="email" /><br />
				<button id="btn_update">회원수정</button>
			</form>
		</div>
	</div>
</div>
<script>
	$("#btn_update").on("click", (e)=>{
		e.preventDefault();
		let data = {
				username:$("#username").val(),
				password:$("#password").val(),
				email:$("#email").val(),
				};

		let id =$("#id").val();
		
		$.ajax({
			type:"PUT",
			url:"/user/"+id,
			data:JSON.stringify(data),
			contentType:"application/json;charset=utf-8",
			dataType:"json"
			}).done((res)=>{
				console.log(res);
				if(res.statusCode === 1){
					alert("수정에 성공하였습니다.");
					location.href="/";
					}else{
						alert("수정에 실패하였습니다.");
						}
			});
		
		});
</script>
<%@ include file="../layout/footer.jsp"%>