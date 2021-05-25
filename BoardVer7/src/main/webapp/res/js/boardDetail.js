function regCmt(){
	var cmtFrmElem = document.querySelector('#cmtFrm');
	var cmtVal = cmtFrmElem.cmt.value;	//속성명으로 접근(id나 name)

	var param = {
		iboard: cmtFrmElem.dataset.iboard,
		cmt: cmtVal
	};
	regAjax(param);
}

//서버에게 등록해줘~!
function regAjax(param){
	const init = {
		method: 'POST',
		body: new URlSearchParams(param)
	};
	
	fetch('cmtInsSel', init)
	.then(function(res){
		return res.json();
	})
	.then(function(myJson){
		console.log(myJson);
		
		switch(myJson.result){
			case 0:
			alert('등록 실패');
			break;
			case 1:
			alert('등록 완료');
			break;
		}
	});
}