<%@page import="com.between.dto.TbUserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- 카카오 sdk -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<!-- 구글 -->
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id" content="1086121226988-79i2g3qsvsr85hmu6kh2i5jkelnofqrm.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>

<!-- 일반 로그인 팝업창  -->
<style>	
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
	.btn{
		border:0;
		outline:0;
		background-color: white;
	}
	.loginbtn{
		border:0;
		outline:0;
		color: skyblue;
		background-color: white;
	}
	.loginbtn:hover{
		cursor: pointer;
		color: darkviolet;
	}
	
</style>
<!-- 일반 로그인 스크립트  -->
<script type="text/javascript">
function loginpopup(){
	var lo = document.getElementById("login");
	lo.style.display = "block";
	document.body.style.background= "gray";
	
	
	//버튼 눌렀을때 다른 버튼들 비활성화 시키는 것 
	var btns = document.getElementsByName("btn");
	for(var i in btns){
		btns[i].disabled = true;
		btns[i].style.background="gray";

	}
	
	
}

function closewin(){
	var lo = document.getElementById("login");
	lo.style.display = "none";
	document.body.style.backgroundColor= "white";
	
	
	//비활성화 되었던 버튼 재활성화 시키기 
	var btns = document.getElementsByName("btn");
	$("")
	for(var i in btns){
		btns[i].disabled = false ;
		btns[i].style.backgroundColor="white";
	}
	
}
</script>

<!-- 카카오톡 로그인 스크립트 -->
<script type='text/javascript'>
function kakaologin() {
	 Kakao.init('3ffc02510f976b23accd140b3077863a');
	  Kakao.Auth.loginForm({
	    	
	        success: function(authObj) {
	          // 로그인 성공시, API를 호출합니다.
	          Kakao.API.request({
	            url: '/v2/user/me',
	            success: function(res) {
	            	
	            console.log(res);
	            
	            var userId = res.id; 
	            var userEmail = res.kakao_account.email; 
	            var userNickName = res.properties.nickname; 
	            var gender = res.kakao_account.gender; 
	            document.getElementById("userId").value = userId;
	            document.getElementById("userEmail").value = userEmail;
	              alert(JSON.stringify(res));
	              persistAccessToken:true;
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
};

 
    
    function kout(){
    	 Kakao.init('3ffc02510f976b23accd140b3077863a');
    	alert("script");
    	Kakao.Auth.logout(function(data){
                alert(data)
                
            });
    }

</script>
<!-- 구글 로그인 스크립트  -->
<script>
        function onSignIn(googleUser) {
            // Useful data for your client-side scripts:
            var profile = googleUser.getBasicProfile();
            console.log("ID: " + profile.getId()); // Don't send this directly to your server!
            console.log('Full Name: ' + profile.getName());
            console.log('Given Name: ' + profile.getGivenName());
            console.log('Family Name: ' + profile.getFamilyName());
            console.log("Image URL: " + profile.getImageUrl());
            console.log("Email: " + profile.getEmail());

            // The ID token you need to pass to your backend:
            var id_token = googleUser.getAuthResponse().id_token;
            console.log("ID Token: " + id_token);
        };
        
        function signOut(){
        	var auth2 = gapi.auth2.getAuthInstance();
        	auth2.signOut().then(function(){
        		console.log('user signed out');
        	});
        	auth2.disconnect();
        }

    </script>

</head>
<body>
<%
	TbUserDto userInfo = (TbUserDto)session.getAttribute("dto");
//	System.out.println(userInfo);
%>
	<header>
	
		<div align="right">
<%
			if(userInfo==null){
%>
			<input type="button" onclick="loginpopup()" name="btn" class="login btn" value="로그인"/> 
			<input type="button" name="btn" class="login btn" value="회원가입"/>
<%
			} else {
%>

			<input type="button" onclick="location.href='TbUser.do?command=logout'" name="btn" class="login btn" value="로그아웃"/> 
			<input type="button" onclick="location.href='TbUser.do?command=mypage&userStatus=<%=userInfo.getUserStatus()%>'"name="btn" class="login btn" value="마이페이지"/>
<%
			}
%>
			
		</div>
		<a><img alt="" src="images/logo.gif" class="logo"></a>
	</header>
	<div class="nav" align="center">
		<div class="dropdown">

			<div class="option">
				<a class="menu">우리사이</a>
				<a class="menu">커플사이</a>
				<a class="menu">사이다</a>
			</div>
			<div class="dropdown-content">
				<div class="row">
					<div class="column">
						<a href="">커플테스트</a> <a href="">니캉내캉</a> <a href="">사진분석</a>
					</div>
					<div class="column">
						<a href="">앨범</a> <a href="">다이어리</a> <a href="">사이톡</a> <a
							href="">영상통화</a>
					</div>
					<div class="column">
						<a href="">전문상담사</a> <a href="TbBoard.do?command=boardlist">속닥속닥</a>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="content">
	</div>
	
	<!-- 큰 div로 묶었음 -->
	<div>

		<!-- 로그인 팝업창 -->
		<div id=login align="center">
			<h1>로그인 하세요</h1>

			<!-- 구글 로그인 -->
			<div class="g-signin2" data-width="220" data-height="45"
				data-onsuccess="onSignIn" data-longtitle="true"></div>
			<a href="#" onclick="signOut();">구글로그아웃</a>

			<!-- 카카오톡 로그인 -->
			<div>
				<a href="#" onclick="kakaologin();return false;"><img
					src="images/kakao_account_login_btn_medium_narrow.png" alt="카카오로그인"></a>
				<input type="button" onclick="kout()" value="카카오로그아웃">
			</div>

			<!-- 일반 로그인 -->
			<div>
				<form action="TbUser.do" method="post">
					<input type="hidden" name="command" value="loginres" />
					<table >
						<tr>
							<th>아이디</th>
							<td><input type="text" name="userId" id="userId"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="userPw" id="userPw"></td>
						</tr>
						<tr>
							<!-- location.href='TbUser.do?command=main -->
							<td colspan="2" align="center"><input type="submit" class="loginbtn" value="로그인"> <input
								class="loginbtn" type="button" value="회원가입"
								onclick="location.href='TbUser.do?command=registerform'">
								<input class="loginbtn" type="button" value="취소" onclick="closewin()"></td>
						</tr>
					</table>
				</form>
			</div>

		</div>
	</div>
</body>
</html>