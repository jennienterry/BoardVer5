<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h1>detail</h1>
	<div><a href="#" onclick="goBack();">돌아가기</a></div>
	<div>제목 : ${requestScope.vo.title}</div>
	<div>글번호 : ${param.iboard}</div>
	<div>작성자 : ${requestScope.vo.writerNm} | 작성일 : ${requestScope.vo.regdt}</div>
	<div><c:out value="${requestScope.vo.ctnt}"/></div>
	<!-- 원칙적으로 c:out으로 다 해주는게 맞음 -->
	<!--  javascript:history.go(-1); 또는 .back(); -->
	<c:if test="${not empty sessionScope.loginUser}">	
	<div>			   <!-- onsubmit : submit눌렀을 때 return 안되도록 -->
		<form id="cmtFrm" onsubmit="return false;">
			<input type="text" id="cmt">
			<input type="button" value="댓글달기" onclick="regCmt();">
		</form>
	</div>
	</c:if>  	<!-- data를 set할 때는 대문자 x -->
	<div id="cmtList" data-login_user_pk="${sessionScope.loginUser.iuser}" data-iboard="${param.iboard}"></div>
	<script src="/res/js/boardDetail.js"></script>