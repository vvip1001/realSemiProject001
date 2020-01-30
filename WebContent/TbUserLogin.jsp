<%@page import="net.sf.json.JSON"%>
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
<!-- 카카오 sdk -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<!-- 구글 -->
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id" content="1086121226988-79i2g3qsvsr85hmu6kh2i5jkelnofqrm.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>

<!-- 일반 로그인 팝업창  -->
<style>	

	.background{
	display:none; 
	position:fixed; 
	_position:absolute; 
	top:0; 
	left:0; 
	width:100%;  
	height:100%; 
	z-index:100;
	}
.background .dimBackground {
	position:absolute; 
	top:0; 
	left:0; 
	width:100%; 
	height:100%;
	 background:#000; 
	 opacity: .5; 
	 filter:alpha(opacity=70);
	 }
.background .popuplayer{
	display:block;
	}
.popuplayer {
	background-color:#f1f1f1;
	width:300px;
	height:500px;
	display:none;
	position:absolute;
	top:50%;
	left:50%;
	z-index:10;
	color:#000;
	}
	
	
</style>
<!-- 일반 로그인 스크립트  -->
<script type="text/javascript">
function layer_popup(el){
	var $el = $(el); 
	var isDim = $el.prev().hasClass('dimBackground');
	isDim ? $('.background').show() : $el.show();
	var $elWidth = ~~($el.outerWidth()),
		$elHeight = ~~($el.outerHeight()),
		docWidth = $(document).width(),
		docHeight = $(document).height();
	

	if ($elHeight < docHeight || $elWidth < docWidth) {
		$el.css({
			marginTop: -$elHeight /2,
			marginLeft: -$elWidth/2
		});
	}
	else{
		$el.css({top: 0, left: 0});

	}
}
function closelayer(){
	var isDim = $(".popuplayer").prev().hasClass('dimBackground'); 
	isDim ? $('.background').hide() : $el.hide(); 
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
	            	
	            console.log("1"+res);
	            
	            var userId = res.id; 
	            var userEmail = res.kakao_account.email; 
	            var userNickName = res.properties.nickname; 
	            var gender = res.kakao_account.gender; 
	          //  document.getElementById("userId").value = userId;
	          //  document.getElementById("userEmail").value = userEmail;
	              alert(JSON.stringify(res));
	              persistAccessToken:true;
	              
	              
	              $.ajax({
	            	  method:"POST",
	            	  url: "",
	            	  data: JSON.stringify(res),
	            	  success:function(){
	            		  
	            	  },
	            	  error:function(){
	            		  
	            	  }
	              });
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


	//1086121226988-79i2g3qsvsr85hmu6kh2i5jkelnofqrm.apps.googleusercontent.com
    // Useful data for your client-side scripts:
    
	   function onSignIn(googleUser) {
           // Useful data for your client-side scripts:
           var profile = googleUser.getBasicProfile();
           console.log("ID: " + profile.getId()); // Don't send this directly to your server!
           console.log('Full Name: ' + profile.getName());
           console.log('Given Name: ' + profile.getGivenName());
           console.log('Family Name: ' + profile.getFamilyName());
           console.log("Image URL: " + profile.getImageUrl());
           console.log("Email: " + profile.getEmail());
           alert("test!");
				//alert("성별:"+profile.getGender());
           // The ID token you need to pass to your backend:
           var id_token = googleUser.getAuthResponse().id_token;
           console.log("ID Token: " + id_token);
           
           location.href="TbUser.do?command=googlelogin&userId="+profile.getId()+"&pw="+profile.getEmail();
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
<!-- 큰 div로 묶었음 -->
<div>
<!-- 로그인 팝업창 띄우는  버튼   -->
	 <input type="button" Class="btn" onclick="layer_popup('#popuplayer');" value="로그인 팝업창">
	 
	<div class="background">
	<div class="dimBackground"></div>
	<div id="popuplayer" class="popuplayer">
	
	<!-- 로그인 팝업창 -->    
	<div  align="center">	
		<h1>로그인 하세요 </h1>
	
	<!-- 구글 로그인 -->
	<div class="g-signin2" data-width="220" data-height="45" data-onsuccess="onSignIn" data-longtitle="true"></div>
	<a href ="#" id="google" onclick="signOut();">구글로그아웃</a>
	
	<!-- 카카오톡 로그인 -->
	<div>
	<a href="#" onclick="kakaologin();return false;"><img src="images/kakao_account_login_btn_medium_narrow.png" alt="카카오로그인"></a>
	<input type="button" onclick="kout()" value="카카오로그아웃">
	</div>

	<!-- 일반 로그인 -->
	<div>
	<form action="TbUser.do" method="post">
		<input type="hidden" name="command" value="loginres"/>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userId" id="userId"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="userPw" id="userPw"></td>
			</tr>
			<tr><!-- location.href='TbUser.do?command=main -->
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location.href='TbUser.do?command=registerform'" >
					<input type="button" value="취소" onClick='closelayer();' >
				</td>
			</tr>		
		</table> 
	</form>
	</div>
	
		</div>
	
	</div>
	</div>
	

	</div>

</body>
</html>