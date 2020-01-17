<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html;charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.a{
		text-align: right;
	}
</style>
</head>
<body>

	<div>
		<h1>이메일 인증</h1>
	</div>
	<div>
		<pre>
	- 사이 사이트에서는 이메일이 아이디로 사용되기 때문에 반드시 인증이 필요합니다.
	- 회원 가입시 등록된 이메일로만 인증번호를 받으실 수 있습니다.
	- 메일이 도착하지 않은 경우 광고로 분류 되었는지 확인해 주세요.
	</pre>
	</div>
	<div class="a">
		<input type="text" placeholder="인증번호를 입력해주세요 ">
	
		<input type="button" value="확인"> 
		<input type="button" value="취소">
	</div>



</body>
</html>