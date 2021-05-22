<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> write </title>
</head>
<body>
	<h1> WRITE </h1>
	<form action="/board/write" method="post">
	<div>title : <input type="text" name="title"></div>
	<div>content : <textarea name="ctnt" cols="10" rows="10"></textarea></div>
	<div>
	<input type="submit" value="submit">	
	<input type="reset" value="reset">
	</div>
	</form>
</body>
</html>