<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/res/css/common.css">
<!-- 결국html로 작업, 문자열을 보내면 주소로 요청보내서 다운로드를 한번 더 함 -->
<title>${requestScope.title}</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<c:if test="${empty sessionScope.loginUser}">
				<li><a href="/user/login">로그인</a></li>
				</c:if>
				
				<c:if test="${not empty sessionScope.loginUser}">
				<li><a href="/user/logout">로그아웃</a></li>
				<li><a href="/board/write">글쓰기</a></li>
				<li><a href="/board/favoriteList">좋아요</a></li>
				</c:if>
				<li><a href="/board/list">리스트</a></li>
				
			</ul>	
		</nav>
	</header>
	<section>
		<jsp:include page="/WEB-INF/view/${requestScope.page}.jsp"></jsp:include>
		<!-- <h1>join</h1> 얘네가 여기 들어오는 것 -->
	</section>
</body>
</html>