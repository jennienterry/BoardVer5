<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> login </title>
</head>
<body>
	<h1> LOGIN </h1>
	<div>
	<form action="/user/login" method="post">
	<div> 아이디 : <input type="text" name="uid" placeholder="id"></div>
	<div> 비밀번호 : <input type="password" name="upw" placeholder="pw"></div>
	<input type="submit" value="login">	
	</form>
	 </div>
	 <a href="join"><button>회원가입</button></a>
</body>
</html>