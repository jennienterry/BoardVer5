var insFrmElem = document.querySelector('#insFrm');
var updFrmElem = document.querySelector('#updFrm');

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
	updFrm.icmt.value = icmt;
	updFrm.cmt.value = cmt;
	
	insFrm.className = 'hidden';
	updFrm.className = '';
	
}

function showInsFrm(){
		insFrm.className = '';
		updFrm.className = 'hidden';
		
	}