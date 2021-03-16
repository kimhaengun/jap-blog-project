<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
<form>
	
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Enter Title" id="title" value="${post.title}"/>
	</div>
	
	<div class="form-group">
		<textarea rows="" cols="5" class="form-control" id="content">${post.content}</textarea>
	</div>

	<button type="submit" class="btn btn-primary">수정완료</button>
</form>
</div>
    <script>
      $('#content').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 300
      });
    </script>
<%@ include file="../layout/footer.jsp"%>