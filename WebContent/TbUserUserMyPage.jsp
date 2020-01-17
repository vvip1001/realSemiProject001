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

<% TbUserDto dto = (TbUserDto)session.getAttribute("dto"); %>

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
			<td>내글보기</td>
			<td><input type="button" onclick="" value="비밀번호"></td>
		</tr>
		<tr>
			<td>회원정보 수정하기 </td>
			<td><input type="button" onclick="" value="수정" ></td>
		</tr>
		
	</table>



</body>
</html>