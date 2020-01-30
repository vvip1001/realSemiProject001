<%@page import="com.between.dto.TbUserDto"%>
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
<%
	TbUserDto dto = (TbUserDto)request.getAttribute("dto");

%>
<div>
	<form action="TbUser.do" method="post">
		<input type="hidden" name="command" value="snsresgisterres">

		<table border="1">


			<tr>
				<th>아이디</th>
				<td><input type="text" name="userId" id="userId"></td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="userPw" id="userPw"></td>
			</tr>


			<tr>
				<th>Email</th>
				<td><input type="email" name="userEmail" id="userEmail"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
				<input type="text" id="gender"/>
					<input type="radio" name="usergender" id="man" checked="checked" value="남자" /> 남
				 	<input type="radio" name="usergender" id="woman" value="여자" /> 여
				 </td>
			</tr>



			<tr>

				<td colspan="3" align="right"><input type="submit" value="회원가입" />
					<input type="button" value="취소" onclick="location.href=index.html"></td>
			</tr>
		</table>
	</form>

</div>


</body>
</html>