<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8");%>
    <% response.setContentType("text/html; charset=UTF-8");%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>login</h1>
	<form action="TbUser.do" method="post">
		<input type="hidden" name="command" value="loginres"/>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="myid"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mypw"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" name="register"  value="회원가입" onclick="" >
					<input type="button" value="취소" onclick="TbUser.do?command=login" >
				</td>
			</tr>
			
		</table> 
	</form>
</body>
</html>