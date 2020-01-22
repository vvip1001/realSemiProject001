<%@page import="com.between.dto.TbUserDto"%>
<%@page import="com.between.dto.TbCalDto"%>
<%@page import="java.util.Calendar"%>
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
<%
	
	
	Calendar cal = Calendar.getInstance();
	int hour = cal.get(Calendar.HOUR_OF_DAY);
	int min = cal.get(Calendar.MINUTE);
	
	TbUserDto userInfo = (TbUserDto)session.getAttribute("dto");
	
	int year = (int)request.getAttribute("year");
	int month = (int)request.getAttribute("month");
	int date = (int)request.getAttribute("date");
	
%>
<body>

	<h1>일정 추가</h1>

	<form action="TbCal.do" method="post">
		<input type="hidden" name="command" value="insertCal">
		<table border="1">
			<tr>
				<th>그룹번호</th>
				<td><input type="text" name="groupNum" value="<%=userInfo.getGroupNum() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>날짜/시간</th>
				<td><input type="text" name="year" value="<%=year %>" readonly="readonly">년 <input type="text" name="month" value="<%=month %>" readonly="readonly">월 <input type="text" name="date" value="<%=date %>" readonly="readonly">일 <select name="hour">
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
				</select>분</td>
			</tr>
			<tr>
				<th>일정</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="일정작성">
					<input type="button" value="취소" onclick="location.href='TbCal.do?command=callist&year=<%=year %>&month=<%=month %>&date=<%=date %>'">
				</td>
			</tr>
		</table>
		
	</form>
	
</body>
</html>