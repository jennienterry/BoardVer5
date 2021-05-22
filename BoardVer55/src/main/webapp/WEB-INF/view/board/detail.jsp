<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> detail </title>
</head>
<body>
	<h1> DETAIL </h1>
	<a href="/board/list"><button>back to list</button></a>
	<div>${data.title}</div>
	<div>${data.ctnt}</div>
	<div>${data.unm}</div>
	<div>${data.regdt}</div>
	<div>
	<a href="/board/mod?iboard=${data.iboard}"><button>mod</button></a>
	<a href="/board/del?iboard=${data.iboard}"><button>del</button></a>
	</div>
	
</body>
</html>