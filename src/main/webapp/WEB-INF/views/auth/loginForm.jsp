<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그</title>
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

.a_font {
	margin-bottom: 10px;
	font-size: 30px;
}
</style>
</head>
<body>
	<div class="container">
		<div>
			<div>
				<h1>로그인</h1>
				<hr />
			</div>
			<div style="margin-bottom: 20px;">
				<form action="/login" method="POST">
					<input class="login_input" type="text" placeholder="Username" name="username" /> <br /> <input class="login_input"
						type="password" placeholder="Password" name="password" />
					<div class="btn_login_container">
						<button class="btn_login">로그인</button>
					</div>
				</form>
			</div>
			아직 회원가입이 안되셨나요? <a style="color: gray" href="/joinForm">회원가입</a>

			<div style="margin-top: 20px; display: flex; align-items: center; justify-content: center;">
				<div>
					<div class="a_font">
						<a style="color: black" href="/oauth2/authorization/google">구글 로그인</a> <br />
					</div>
					<div class="a_font">
						<a style="color: rgb(83, 131, 232)" href="/oauth2/authorization/facebook">페이스북 로그인</a> <br />
					</div>
					<div class="a_font">
						<a style="color: green" href="/oauth2/authorization/naver">네이버 로그인</a> <br />
					</div>
					<div class="a_font">
						<a style="color: rgb(252, 206, 0)" href="/oauth2/authorization/kakao">카카오 로그인</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>