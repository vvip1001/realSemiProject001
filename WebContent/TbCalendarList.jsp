<%@page import="com.between.dto.TbCalDto"%>
<%@page import="java.util.List"%>
<%@page import="com.between.biz.TbCalBizImpl"%>
<%@page import="com.between.biz.TbCalBiz"%>
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
	TbCalBiz biz =  new TbCalBizImpl();
	List<TbCalDto> list = (List<TbCalDto>)request.getAttribute("list");
			
%>

	<h1>LIST</h1>

	<form action="TbCal.do" method="post">
		<input type="hidden" name="command" value="muldel">
		<table border="1">
			<col width="50px;">
			<col width="50px;">
			<col width="300px;">
			<col width="200px;">
			<col width="100px;">
			
			<tr>
				<th><input type="checkbox" name="all" onclick=""></th>
				<th>번호</th>
				<th>제목</th>
				<th>일정</th>
				<th>작성일</th>
			</tr>
			<tr>
<%
				if(list.size()==0){
%>				
				<td colspan="5">-----작성된 글이 없습니다-----</td>
<%
				}
%>				
			</tr>
		</table>
	</form>
	
	
</body>
</html>