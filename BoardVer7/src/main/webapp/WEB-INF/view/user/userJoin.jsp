<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>join</h1>							<!-- on=event -->
<form id="frm" action="join" method="post" onsubmit="return frmChk();">
	<div>
	<input type="text" name="uid" placeholder="id">
	<input type="button" id="btnChkId" value="doubleIDchk">
	</div>
	<div id="chkUidResult"></div>
	<div><input type="password" name="upw" placeholder="pw"></div>
	<div><input type="password" id="chkUpw" placeholder="pwchk"></div>
	<div>
	성별 : 
	<label>여성<input type="radio" name="gender" value="0" checked></label>
	<label>남성<input type="radio" name="gender" value="1"></label>
	</div>
	
	<div><input type="text" name="unm" placeholder="nm"></div>
	<div>
		<input type="submit" value="join">
		<input type="reset" value="rest">
	</div>
</form>

<script src="/res/js/userJoin.js"></script>
<!-- 제일 위에 적으려면 defer src="" -->