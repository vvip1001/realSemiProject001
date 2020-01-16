<%
	response.setHeader("Pragma","no-cache");
	response.setHeader("Cache-control","no-store");
	response.setHeader("Expires","0");
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8");%>
    <% response.setContentType("text/html; charset=UTF-8");%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>로그인뒤 보이는 첫 화면 </h1>
	<form action="TbUser.do" method="post">
	<input type="hidden" name="command" value="mypage">
	<input type="hidden" name="userID" value=${dto.userID }>
		<input type="button" value="로그아웃" onclick="location.herf='TbUser.do?command=logout'">
		<input type="submit" value="마이페이지">
		
	</form>
</body>
</html>