<%@page import="com.between.biz.TbCalBizImpl"%>
<%@page import="com.between.biz.TbCalBiz"%>
<%@page import="com.between.dto.TbGroupDto"%>
<%@page import="com.between.dto.TbUserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		TbCalBiz biz = new TbCalBizImpl();

		TbUserDto userInfo = (TbUserDto) session.getAttribute("dto");
		int groupNum = userInfo.getGroupNum();

		TbGroupDto groupDto = (TbGroupDto) request.getAttribute("groupDto");

		int year = (int) request.getAttribute("year");
		int month = (int) request.getAttribute("month");
		int dayOfWeek = (int) request.getAttribute("dayOfWeek");
		int lastDay = (int) request.getAttribute("lastDay");
	%>

	<h1><%=groupDto.getUserId()%>와
		<%=groupDto.getPartnerId()%>의 뉴캘린더
	</h1>


	<table>
		<caption class="arrows">
			<a href="TbCal.do?command=minusYear&year=<%=year-1%>&month=<%=month%>">◀︎◀︎</a> <a
				href="TbCal.do?command=minusMonth&year=<%=year %>&month=<%=month-1 %>">◁</a> <span class="y"><%=year%></span>년
			<span class="m"><%=month%></span>월 <a
				href="TbCal.do?command=addMonth&year=<%=year %>&month=<%=month+1 %>">▷</a> <a
				href="TbCal.do?command=addYear&year=<%=year+1 %>&month=<%=month%>">▶▶</a>
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
				for (int i = 1; i < dayOfWeek; i++) {
					out.print("<td>&nbsp;</td>");
				}

				int cnt = dayOfWeek;
				for (int i = 1; i <= lastDay; i++) {
			%>
			<td><a class="countview"
				href="TbCal.do?command=callist&year=<%=year%>&month=<%=month%>&date=<%=i%>"
				style="color: <%=biz.fontColor(i, dayOfWeek)%>"><%=i%> </a> <a
				href="TbCalendarInsert.jsp?year=<%=year%>&month=<%=month%>&date=<%=i%>&lastday=<%=lastDay%>">
					<img alt="일정추가" src="images/heart.png"
					style="width: 10px; height: 10px;" />
			</a></td>
			<%
				if (cnt % 7 == 0) {
			%>
		</tr>
		<tr>
			<%
				}
					cnt++;
				}

				int a = 7 - ((dayOfWeek - 1 + lastDay) % 7) % 7;

				if (a % 7 == 0) {
					out.print("</tr>");
				} else {
					for (int i = 1; i < a + 1; i++) {
						out.print("<td style='color: lightgray;'>" + i + "</td>");
					}
				}
			%>
		</tr>
	</table>

	제목
	<textarea rows="20" cols="40" placeholder="내용을 입력해주세요"></textarea>



</body>
</html>