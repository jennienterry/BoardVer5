var insFrmElem = document.querySelector('#insFrm');
var updFrmElem = document.querySelector('#updFrm');
//updCmt와 showInsFrm 두 경우에 다 사용할거라서 전역변수로 지정해준다.

// 댓글삭제
function delCmt(iboard, icmt) {
	console.log(`iboard: ${iboard}, icmt: ${icmt}`)
	//``EL식 아님, javascript문법임
	if (confirm('삭제하시겠습니까?')) {
		location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;
	}
}

//댓글 수정
function updCmt(iboard, icmt, cmt){
	console.log('iboard : %d', iboard);
	console.log('icmt : %d', icmt);
	console.log('cmt : %s', cmt);
	updFrmElem.icmt.value = icmt;
	updFrmElem.cmt.value = cmt;
	// (chrome기준 : id값 적어도 실행된다)
	insFrmElem.className = 'hidden';  
	updFrmElem.className = '';
	
}

function showInsFrm(){
		insFrmElem.className = '';
		updFrmElem.className = 'hidden';
		
	}