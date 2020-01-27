/*function getParameterValues(){
	var dateSince = "date="+document.getElementById("first").value;
	var dateArr = date.split("-");
	var year = dateArr[0];
	var month = dateArr[1];
	var date = dateArr[2];
	
	return date+"&"+year+"&"+month+"&"+date;
	
}

function load(){
	console.log(getParameterValues());
	var url = "TbCal.do?command=dday"+getParameterValues();
	
	httpRequest=new XMLHttpRequest();
	httpRequest.onreadystatechange=callback;
	httpRequest.open("GET",url,true);
	httpRequest.send();
}

function callback(){
	console.log("readyState : "+httpRequest.readyState);
	if(httpRequest.readyState==4){
		console.log("status : "+httpRequest.status);
		if(httpRequest.status==200){
			console.log(httpRequest.responseText);
			
			var obj = JSON.parse(httpRequest.responseText);				// 응답받은 문자열을 JSON 객체로 변환
			document.getElementById("result").innerHTML = 
				decodeURIComponent("");
			
			
		} else {
			alert("fail");
		}
	}
}*/