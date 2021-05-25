<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>write</h1>
<form action="/board/boardWrite" method="post">
<div>제목 : <input type="text" name="title"></div>
<div>내용 : <textarea name="ctnt"></textarea></div>

<input type="submit" value="submit">
<input type="reset" value="reset">
</form>