<%@page import="com.between.dto.TbCalDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-control", "no-store");
	response.setHeader("Expires", "0");
%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="./form/mainPage.jsp" %>

</head>
<body>
<%
	if (userInfo == null) {
		pageContext.forward("index2.jsp");
	}

	int groupNum = (int) request.getAttribute("groupNum");
	int calNum = (int) request.getAttribute("calNum");
	TbCalDto calDto = (TbCalDto) request.getAttribute("calDto");
	// yyyyMMddHHmm
	int year = Integer.parseInt(calDto.getCalTime().substring(0, 4));
	int month = Integer.parseInt(calDto.getCalTime().substring(4, 6));
	int date = Integer.parseInt(calDto.getCalTime().substring(6, 8));
	int hour = Integer.parseInt(calDto.getCalTime().substring(8, 10));
	int min = Integer.parseInt(calDto.getCalTime().substring(10, 12));
%>

	<h1>UPDATE</h1>
	
	<form action="TbCal.do" method="post">
		<input type="hidden" name="command" value="updateCal">
		<table>
			<tr>
				<th>그룹번호</th>
				<td><input type="text" name="groupNum" value="<%=groupNum %>" readonly="readonly"><input type="hidden" name="calNum" value="<%=calNum %>"></td>
			</tr>
			<tr>
				<th>날짜/시간</th>
				<td>
					<input type="text" name="year" value="<%=year %>" readonly="readonly">년
					<input type="text" name="month" value="<%=month %>" readonly="readonly">월
					<input type="text" name="date" value="<%=date %>" readonly="readonly">일
					<select name="hour">
						<%
							for (int i = 0; i < 24; i++) {
						%>
						<option value="<%=i%>" <%=(hour == i) ? "selected" : ""%>><%=i%></option>
						<%
							}
						%>
				</select>시 <select name="min">
						<%
							for (int i = 0; i < 60; i++) {
						%>
						<option value="<%=i%>" <%=(min == i) ? "selected" : ""%>><%=i%></option>
						<%
							}
						%>
				</select>분
				</td>
			</tr>
			<tr>
				<th>일정</th>
				<td><input type="text" name="title" value="<%=calDto.getCalTitle() %>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="content"><%=calDto.getCalContent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="button" value="취소" onclick="location.href='TbCal.do?command=callist&year=<%=year %>&month=<%=month %>&date=<%=date %>'">
				</td>
			</tr>
		</table>
		
	</form>
	
	

</body>
</html>