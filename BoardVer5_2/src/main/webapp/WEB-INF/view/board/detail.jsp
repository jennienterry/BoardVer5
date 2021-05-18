<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${requestScope.param.title}</title>
<style>
.hidden{display: none;}
</style>
<script defer src="/res/js/boardDetail.js"></script>
</head>
<body>
	<h1>디테일</h1>
	<div>
		<a href="list">리스트로 돌아가기</a>
	</div>
	<div>글번호 : ${param.iboard}</div>
	<div>제목 : ${vo.title}</div>
	<div>작성자 : ${vo.unm}</div>
	<div>작성일시 : ${vo.regdt}</div>
	<div>${vo.ctnt}</div>
		<!-- 누구를 삭제하고 수정할지 생각하기 -->
		
	<c:if test="${loginUser.iuser == vo.iuser}">
		<a href="mod?iboard=${param.iboard}"><button>수정</button></a>
		<a href="delete?iboard=${param.iboard}"><button>삭제</button></a>
	</c:if>
	<h3>댓글</h3>
		<div>
			<form id="insFrm" action="cmt" method="post">	
			<input type="hidden" name="icmt" value="0">
				<input type="hidden" name="iboard" value="${param.iboard}">
				<!-- <input type="hidden" name="iuser" value="${vo.iuser}"> -->
				<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">
				</div>
			</form>
	
		</div>

	<div>
		<form id="updFrm" action="cmt" method="post" class="hidden">
			<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${param.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글수정"></textarea>
				<input type="submit" value="댓글수정">
				<input type="button" value="수정취소" onclick="showInsFrm()">
			</div>
		</form>
	</div>

	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
			<c:forEach var="i" items="${requestScope.cmtList}">
			<tr>
				<td>${i.cmt}</td>
				<td>${i.unm}</td>
				<td>${i.regdate}</td>
				<td>		<!-- sessionScope-->
				<c:if test="${loginUser.iuser == i.iuser}">
				<input type="button" value="수정" onclick="updCmt(${param.iboard}, ${i.icmt}, '${i.cmt.trim()}')">
				<button onclick="delCmt(${param.iboard}, ${i.icmt})">삭제</button>
				</c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>

</body>