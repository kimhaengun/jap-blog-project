<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container {
	display: flex;
	align-items: center;
	justify-content: center;
	margin-top: 100px
}

.login_input {
	width: 100%;
	height: 30px;
	margin-top: 20px;
	font-size: 20px
}

a {
	text-decoration: none
}

.btn_login_container {
	display: flex;
	align-items: center;
	justify-content: center
}

.btn_login {
	margin-top: 20px;
	background-color: rgb(83, 131, 232);
	color: white;
	border: 0px;
	width: 100px;
	height: 50px;
	font-size: 20px;
	border-radius: 20px
}
</style>
</head>
<body>
	<div class="container">
		<div>
			<div>
				<h1>회원가입</h1>
				<hr />
			</div>
			<div style="margin-bottom: 20px;">
				<form action="/join" method="POST">
					<input class="login_input" type="text" placeholder="Username" name="username" /> <br /> 
					<input class="login_input"
						type="password" placeholder="Password" name="password" /><br />
					<input class="login_input"
						type="email" placeholder="Email" name="email" />
					<div class="btn_login_container">
						<button class="btn_login">회원가입</button>
					</div>
				</form>
			</div>
			아직 회원가입이 안되셨나요? <a style="color: gray" href="/loginForm">로그인</a>
			
</body>
</html>