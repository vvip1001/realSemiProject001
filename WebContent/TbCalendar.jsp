<%@page import="com.between.dao.TbCalDaoImpl"%>
<%@page import="com.between.dao.TbCalDao"%>
<%@page import="com.between.dto.TbCalDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
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

<script type="text/javascript"></script>

<style type="text/css">
#calendar {
	border-collapse: collapse;;
	border: 1px solid gray;
}

#calendar th {
	width: 80px;
	border: 1px solid gray;
}

#calendar td {
	width: 80px;
	height: 80px;
	border: 1px solid gray;
	text-align: left;
	vertical-align: top;
	position: relative;
}

a {
	text-decoration: none;
}

#wrap {
	width: 100%;
	margin: 0 auto;
}

.D-Day {
	float: left;
	width: 25%;
	height: 500px;
	margin: 0 auto;
}

.preList>p {
	font-size: 10px;
	margin: 1px;
	background-color: pink;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js">

	$(function(){
		$(".D-Day").submit(function(){
			$(this).css("display","none");
		})
	});

</script>

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
		
		TbCalDao dao = new TbCalDaoImpl();
		String yyyyMM = year + biz.isTwo(String.valueOf(month));
		List<TbCalDto> clist = dao.selectCalListView(yyyyMM, groupNum);
		
	%>

	<h1><%=groupDto.getUserId()%>&
		<%=groupDto.getPartnerId()%>의 캘린더
	</h1>

	<div id="wrap">
		<div class="D-Day">
			<form action="TbCal.do" method="post">
				<input type="hidden" name="command" value="dday">
				<input type="text" placeholder="예)2010-04-20">
				<input type="submit" value="등록"> 
			</form>
		</div>
		<div class="cal">
			<table id="calendar">
				<caption class="arrows">
					<a
						href="TbCal.do?command=minusYear&year=<%=year - 1%>&month=<%=month%>">◀︎◀︎</a>
					<a
						href="TbCal.do?command=minusMonth&year=<%=year%>&month=<%=month - 1%>">◁</a>
					<span class="y"><%=year%></span>년 <span class="m"><%=month%></span>월
					<a
						href="TbCal.do?command=addMonth&year=<%=year%>&month=<%=month + 1%>">▷</a>
					<a
						href="TbCal.do?command=addYear&year=<%=year + 1%>&month=<%=month%>">▶▶</a>
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

							out.print("<td>&nbsp</td>");

						}

						int cnt = dayOfWeek;
						for (int i = 1; i <= lastDay; i++) {
					%>
					<td><a class="countview"
						href="TbCal.do?command=callist&year=<%=year%>&month=<%=month%>&date=<%=i%>"
						style="color: <%=biz.fontColor(i, dayOfWeek)%>"><%=i%> </a>
						<div class="preList"><%=biz.getCalView(i, clist) %></div>
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
		</div>
	</div>



</body>
</html>