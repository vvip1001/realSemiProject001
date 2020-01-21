<%@page import="com.between.dto.TbCalDto"%>
<%@page import="java.util.List"%>
<%@page import="com.between.biz.TbCalBizImpl"%>
<%@page import="com.between.biz.TbCalBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>일정보기</h1>
	
<%
int year = (int)request.getAttribute("year");
int month = (int)request.getAttribute("month");
int date = (int)request.getAttribute("date");
%>

	<form action="TbCal.do" method="post">
		<input type="hidden" name="command" value="muldel">
		
		<jsp:useBean id="biz" class="com.between.biz.TbCalBizImpl"></jsp:useBean>
		
		<table>
			<col width="50px;">
			<col width="100px;">
			<col width="200px;">			
			<tr>
				<th><input type="checkbox" name="all" onclick=""></th>
				<th>날짜/시간</th>
				<th>일정</th>
			</tr>
			
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<th colspan="3">----------작성된 글이 없습니다----------</th>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list }" var="dto">
						<tr>
							<td><input type="checkbox" name="chk" value="${dto.calNum }"></td>
							<td>
								<jsp:setProperty property="todates" name="biz" value="${dto.calTime }"/>
								<jsp:getProperty property="todates" name="biz"/>
							</td>
							<td><a href="TbCal.do?command=">${dto.calTitle }</a></td>
						</tr>
						
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
			<tr>
				<td colspan="3">
					<input type="button" value="글쓰기" onclick="location.href='TbCal.do?command=insertEvent&year=<%=year %>&month=<%=month %>&date=<%=date %>'">
					<input type="submit" value="삭제" onclick="">
				</td>
			</tr>
			
		</table>
	</form>
	
	
</body>
</html>