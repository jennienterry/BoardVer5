<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
</head>
<body>
	<h1> JOIN </h1>
	<a href="/user/login"><button>뒤로가기</button></a>
	<form action="/user/join" method="post">
		<div><input type="text" name="uid" placeholder="id"></div>
		<div><input type="password" name="upw" placeholder="pw"></div>
		<div><input type="text" name="unm" placeholder="nm"></div>
		<div>
		성별 : 
		<label>	여성 <input type="radio" name="gender" value="0" checked></label>
		<label>	남성 <input type="radio" name="gender" value="1"></label>
		</div>
		<input type="submit" value="join">
		</form>
</body>
</html>