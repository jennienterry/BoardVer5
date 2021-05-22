<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<h1>LIST</h1>
	<a href="/board/write"><button>글쓰기</button></a>
	<a href="/user/login"><button>뒤로가기</button></a>
	<table>
		<tr>
			<th>no</th>
			<th>title</th>
			<th>id</th>
			<th>regdt</th>
		</tr>

		<c:forEach var="i" items="${list}">
			<tr onclick="moveToDetail(${i.iboard})">
				<td>${i.iboard}</td>
				<td>${i.title}</td>
				<td>${i.unm}</td>
				<td>${i.regdt}</td>
			</tr>
		</c:forEach>
	</table>
		
		<script>
		function moveToDetail(iboard){
			location.href="/board/detail?iboard=" + iboard
		}
		</script>
</body>
</html>