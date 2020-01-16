<%@page import="com.between.dto.TbGroupDto"%>
<%@page import="com.between.dto.TbUserDto"%>
<%@page import="com.between.biz.TbCalBiz"%>
<%@page import="com.between.biz.TbCalBizImpl"%>
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
<body>
	
	
<%
	
	TbCalBiz biz = new TbCalBizImpl();

	TbUserDto userInfo = (TbUserDto)session.getAttribute("dto");
	int groupNum = userInfo.getGroupNum();
	
	TbGroupDto groupDto = (TbGroupDto)request.getAttribute("groupDto");
	
	
	Calendar cal = Calendar.getInstance();
	
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	
	String paramYear = request.getParameter("year");
	String paramMonth = request.getParameter("month");
	
	if(paramYear != null){
		year = Integer.parseInt(paramYear);
	}
	
	if(paramMonth != null){
		month = Integer.parseInt(paramMonth);
	}
	
	if(month > 12){
		month = 1;
		year++;
	}
	
	if(month < 1){
		month = 12;
		year--;
	}
	
	cal.set(year, month-1, 1);
	
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	
	int lastDay = cal.getActualMaximum(Calendar.DATE);
	
	//달력 일정 (dao)biz
	
%>
	<h1><%=groupDto.getUserId() %>와<%=groupDto.getPartnerId() %> Calendar</h1>

	<table id="calendar" border="1">
		<caption>
			<a href="Calendar.jsp?year=<%=year-1%>&month=<%=month%>">◀︎◀︎</a> 
			<a href="Calendar.jsp?year=<%=year%>&month=<%=month-1%>">◁</a> 
			<span class="y"><%=year %></span>년 <span class="m"><%=month %></span>월 
			<a href="Calendar.jsp?year=<%=year%>&month=<%=month+1%>">▷</a> 
			<a href="Calendar.jsp?year=<%=year+1%>&month=<%=month%>">▶▶</a>
		</caption>
		<tr>
			<th>일</th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th>토</th>
		</tr>
		<tr>
<%
			for(int i = 1; i < dayOfWeek; i++){
				out.print("<td>&nbsp;</td>");
			}
			
			int cnt = dayOfWeek;
			for(int i = 1; i <= lastDay; i++) {
%>
			<td><a class="countview"
				href="TbCal.do?command=callist&year=<%=year%>&month=<%=month%>&date=<%=i%>"
				style="color: <%=biz.fontColor(i, dayOfWeek)%>"><%=i%> </a> <a
				href="insertCal.jsp?year=<%=year%>&month=<%=month%>&date=<%=i%>&lastday=<%=lastDay%>">
					<img alt="일정추가" src="img/pen.png"
					style="width: 10px; height: 10px;" />
			</a>

			</td>
			<%
				if (cnt % 7 == 0) {
			%>
		</tr>
		<tr>
			<%
			}
			cnt++;
		}
		//마지막날의 요일 : (dayofWeek-1+lastDay)%7
		//7-((dayofWeek-1+lastDay)%7)%7
		int a = 7-((dayOfWeek-1+lastDay)%7)%7;
	
		if(a%7==0){
			out.print("</tr>");
		} else {
			for(int i = 1; i < a+1; i++){
				out.print("<td style='color: lightgray;'>"+i+"</td>");			
			}
		}
%>
		</tr>
		
	</table>


</body>
</html>