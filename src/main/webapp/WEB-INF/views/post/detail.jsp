<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<div>
		<a href="/post/updateForm" class="btn btn-warning">수정</a>
		<button class="btn btn-danger">삭제</button>
		<br/>
		<br/>
		<div class="d-flex justify-content-between">
			<span>글번호:${post.id}</span> <span>작성자:${post.user.username}</span>
		</div>
		<hr/>
		<div>
			<h3>${post.title}</h3>
		</div>
		<hr/>
		<div>
			<div>${post.content}</div>
		</div>
	</div>

</div>
<%@ include file="../layout/footer.jsp"%>