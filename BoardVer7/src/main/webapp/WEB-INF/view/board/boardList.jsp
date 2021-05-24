<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>리스트</h1>
<table>
<tr>
<th>번호</th>
<th>제목</th>
<th>글쓴이</th>
<th>작성일시</th>
</tr>
<c:forEach items="${requestScope.list}" var="i">
<tr>
<td>${i.iboard}</td>
<td>${i.title}</td>
<td>${i.writerNm}</td>
<td>${i.regdt}</td>
</tr>
</c:forEach>
</table>