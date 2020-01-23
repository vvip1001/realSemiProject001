<%
	response.setHeader("Pragma","no-cache");
	response.setHeader("Cache-control","no-store");
	response.setHeader("Expires","0");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8");%>
    <% response.setContentType("text/html; charset=UTF-8");%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript" src="loginApi.js"></script>
<style >


	#login {
		width : 300px;
		height : 500px;
		border: 1px solid black;
		background: white;
		position: absolute;
		top: 100px;
		left: 500px;
		display: none;
	}
	
</style>
<script type="text/javascript">


function loginpopup(){
	var lo = document.getElementById("login");
	lo.style.display = "block";
	document.body.style.background= "gray";
	
	
	//버튼 눌렀을때 다른 버튼들 비활성화 시키는 것 
	var btns = document.getElementsByName("btn");
	for(var i in btns){
		btns[i].disabled = true;
	}
	
	
}

function closewin(){
	var lo = document.getElementById("login");
	lo.style.display = "none";
	document.body.style.background= "white";
	
	
	//비활성화 되었던 버튼 재활성화 시키기 
	var btns = document.getElementsByName("btn");
	for(var i in btns){
		btns[i].disabled = false ;
	}
	
}




</script>
</head>
<body>
	<div > 
    <input type="button" name="btn" onclick="loginpopup()" value="로그인 팝업창"> 
	</div>
	<h1>dmlfkajdlkfsjl</h1>
	
<div id=login align="center">

<a id="kakao-login-btn" onclick="loginbtn()"></a>
<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('3ffc02510f976b23accd140b3077863a');
    //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
   
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
        // 로그인 성공시, API를 호출합니다.
        Kakao.API.request({
          url: '/v2/user/me',
          success: function(res) {
            alert(JSON.stringify(res));
          },
          fail: function(error) {
            alert(JSON.stringify(error));
          }
        });
      },
      fail: function(err) {
        alert(JSON.stringify(err));
      }
    });
  //]]>
</script>

<div>
<h1>login</h1>

	<form action="TbUser.do" method="post">
		<input type="hidden" name="command" value="loginres"/>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="userPw"></td>
			</tr>
			<tr><!-- location.href='TbUser.do?command=main -->
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location.href='TbUser.do?command=registerform'" >
					<input type="button" value="취소" onclick="closewin()" >
				</td>
			</tr>
			
		</table> 
	</form>
	</div>
	
	</div>
</body>
</html>