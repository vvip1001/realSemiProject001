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
<title>Insert title here</title>

<link href="css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header>
		<div align="right">
			<a class="login" href="">로그인</a> <a class="login" href="">회원가입</a>
		</div>
		<a><img alt="" src="images/logo.gif" class="logo"></a>
	</header>
	<div class="nav" align="center">
		<div class="dropdown">

			<div class="option">
				<a class="menu">우리사이</a><a></a><a class="menu">커플사이</a><a
					class="menu">사이다</a>

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
						<a href="">전문상담사</a> <a href="">속닥속닥</a>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="content">
		<p>
			조장님 보시오! 메뉴 위치가 화면분할? 잘 안되있는거같은데 그건 좀 이따 고치고 일단 형태만 여깄습니다
		</p>
	</div>
</body>
</html>