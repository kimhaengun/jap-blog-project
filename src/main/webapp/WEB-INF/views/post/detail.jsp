<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<div>
		<c:if test="${post.user.id==principal.user.id}">
			<a href="/post/updateForm/${post.id}" class="btn btn-warning">수정</a>
			<button id="btn-delete" class="btn btn-danger" value="${post.id}">삭제</button>
		</c:if>
		<br /> <br />
		<div class="d-flex justify-content-between">
			<span>글번호:${post.id}</span> <span>작성자:${post.user.username}</span>
		</div>
		<hr />
		<div>
			<h3>${post.title}</h3>
		</div>
		<hr />
		<div>
			<div>${post.content}</div>
		</div>
	</div>

</div>

<script>
	$("#btn-delete").on("click",(e)=>{
		let id = e.currentTarget.value;

		$.ajax({
			type:"DELETE",
			url:"/post/"+id,
			dataType:"json"
			}).done(res=>{
				if(res.statusCode===1){
					alert("삭제에 성공하였습니다.")
					history.back();
					}else{
					alert("삭제에 실패했습니다.")
						}
				});
		});
</script>
<%@ include file="../layout/footer.jsp"%>