<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/res/css/userMypage.css">
<!-- 기본이미지일지 내가 지정한 이미지일지에 대한 조건문 -->
<c:choose> 
	<c:when test="${empty sessionScope.loginUser.profileImg}">
		<c:set var="img" value="/res/img/noprofile.jpg"/>
	</c:when>
	<c:otherwise>					<!-- 이미지 주소 / session에 담긴 loginUser키값으로 iuser에 접근  -->
		<c:set var="img" value="/res/img/user/${sessionScope.loginUser.iuser}/${sessionScope.loginUser.profileImg}" />
	</c:otherwise>
</c:choose>

<div>
	<form action="mypage" method="post" enctype="multipart/form-data" id="frm" onsubmit="return imgChk();"> <!-- 패킷단위, 바이트단위 -->
		이미지변경 : <input type="file" name="profileImg" accept="image/*"> <!-- accept : 파일업로드때 image만 보여줌, 단일파일 -->
		<input type="submit" value="이미지업로드">
	</form>
</div>

<div>
	<div>
		<img src="${img}">
	</div>
	<div>PK : ${sessionScope.loginUser.iuser}</div>
	<div>ID : ${sessionScope.loginUser.uid}</div>
	<div>Name : ${sessionScope.loginUser.unm}</div>
</div>

<script>
	var frmElem = document.querySelector('#frm');
	function imgChk(){
		if(frmElem.profileImg.files.length === 0){
			alert('이미지를 선택해주세요.');
			return false;
		}
	}
</script>