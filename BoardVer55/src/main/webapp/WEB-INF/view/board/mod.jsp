<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mod</title>
</head>
<body>
 <h1>MOD</h1>
 	<form action="/board/mod" method="post">
 	<div><input type="hidden" value="${data.iboard}" name="iboard"></div>
	<div>title : <input type="text" name="title" value="${data.title}"></div>
	<div>content : <textarea name="ctnt" cols="10" rows="10">${data.ctnt}</textarea></div>
	<div>
	<input type="submit" value="submit">
	<input type="reset" value="reset">
	</div>
	</form>
 
</body>
</html>