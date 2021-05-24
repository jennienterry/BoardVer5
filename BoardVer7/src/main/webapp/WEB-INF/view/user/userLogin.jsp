<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>login</h1>
<div>${requestScope.errMsg}</div>
<div>
<form action="/user/login" method="post">
			<div>
				아이디 : <input type="text" name="uid" placeholder="아이디">
			</div>
			<div>
				비밀번호 : <input type="password" name="upw" placeholder="비밀번호">
			</div>
			<input type="submit" value="로그인">
		</form>
	</div>
	<a href="join"><button>회원가입</button></a>