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

<% TbUserDto dto = (TbUserDto)session.getAttribute("dto"); 

// onclick="location.href='TbUser.do?command=userboardlist&userId=<%=dto.getUserId() 
%>

	<h1>유저 마이페이지</h1>
	<table>
		<tr>
			<td>우리자기</td>
			<td><input type="text" ></td>
		</tr>
		<tr>
			<td>email</td>
			<td><input type="text" value=<%=dto.getUserEmail() %>></td>
		</tr>

		
		<tr>
			<td>회원정보 수정하기 </td>
			<td><input type="button" onclick="location.href='TbUser.do?command=userupdateform'" value="수정" ></td>
		</tr>
		
	</table>
		
		<form action="TbUser.do" method="post">
		<input type="hidden" name="command" value="userboardlist">
		<input type="hidden" name="userId" value="<%=dto.getUserId()%>">
			<h1>내글보기</h1>
			<input type="text" name = "equserPw">
			<input type="submit" value="비밀번호">
		</form>


</body>
</html>