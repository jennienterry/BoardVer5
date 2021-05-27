<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1>mod</h1>
<form action="/board/mod" method="post">
<input type="hidden" name="iboard" value="${param.iboard}">
<div>글번호 : ${param.iboard}</div>
<div>작성자 : ${requestScope.vo.writerNm} | 작성일 : ${requestScope.vo.regdt}</div>
<div>제목 : <input type="text" name="title" value="${requestScope.vo.title}"></div>
<div>내용 : <textarea name="ctnt">${requestScope.vo.ctnt}</textarea></div>


<input type="submit" value="submit">
<input type="reset" value="reset">
</form>