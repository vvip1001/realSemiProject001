<%@page import="com.between.dto.TbGroupDto"%>
<%@page import="com.between.dto.TbUserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	TbUserDto userInfo = (TbUserDto)session.getAttribute("dto");
	int groupNum = userInfo.getGroupNum();
	
	TbGroupDto groupDto = (TbGroupDto)request.getAttribute("groupDto");
	
	
	
	
	
%>

	<h1><%=groupDto.getUserId() %>와 <%=groupDto.getPartnerId() %>의 뉴캘린더</h1>

</body>
</html>