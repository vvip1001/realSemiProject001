<%@page import="com.between.dto.TbBoardDto"%>
<%@page import="java.util.List"%>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% TbUserDto dto = (TbUserDto) session.getAttribute("dto");
	
%>

<h1><%=dto.getUserId() %>내글 목록보기</h1>

	<div align="right">
		<form action="TbUser.do" method="post">
			<input type="hidden" name="command" value="search">
			<input type="hidden" name="userId" value="<%=dto.getUserId()%>">
			<input type="text" name="boardTitle">
			<input type="submit" value="검색">
			<input type="button" value="모든 글 보기 " onclick="location.href='TbUser.do?command=mylist&userId=<%=dto.getUserId()%>'">
		</form>	
	</div>
	
	<div>
	<fieldset>
		<table>
			<col width="100px" >
			<col width="200px" >
			<col width="150px" >
			<col width="100px" >
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<th colspan="4">-------작성된 글이 없습니다.-------</th>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list }" var="list" >
						<tr>
							<td align="center" >${list.boardNum }</td>
							<td>
								<c:forEach begin="1" end="${list.boardTab }" >
								 &nbsp;
								</c:forEach>
								<a href="TbUser.do?command=userboarddetail&boardNum=${list.boardNum }" >${list.boardTitle }</a>
							</td>
							<td align="center">${list.boardGender }</td>
							<td align="center">${list.boardDate }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="4" align="right" >
					<input type="button" value="글수정" onclick="location.href='TbUser.do?command=userboardupdateform'"/>
					<input type="button" value="글삭제" onclick="">
					<input type="button" value="마이페이지로" onclick="location.href='TbUser.do?command=mypage&logindto1=<%=dto.getUserStatus()%>'">
				</td>
			</tr>
		</table>
	</fieldset>
	</div>



</body>
</html>