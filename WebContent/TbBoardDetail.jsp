<%@page import="com.between.dto.TbUserDto"%>
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
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>속닥속닥</title>
<style type="text/css">
	#hideButton{
		display:none;
	}
</style>
</head>
<body>
<%
	TbUserDto userInfo = (TbUserDto)session.getAttribute("dto");

	if(userInfo==null){
		response.sendRedirect("index.html");
	}
%>


	<div>
	<form action="TbBoard.do" method="post" >
	<input type="hidden" name="command" value="boardupdate"/>
	<input type="hidden" name="boardNum" value="${board.boardNum }" />
	<fieldset>
		<table>
			<tr>
				<th>작성자</th>
				<td>${board.boardGender }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${board.boardTitle }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="15" cols="30" readonly="readonly" >${board.boardContent }</textarea>
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" value="답글작성" onclick="location.href='TbBoard.do?command=boardanswer'"/>
				</td>
				<td colspan="2" align="right" id=${board.userId==dto.userId ? "":"hideButton" } >
					<input type="submit" value="수정"/>
					<input type="button" value="삭제" onclick="location.href='TbBoard.do?command=boarddelete'"/>
				</td>
			</tr>
		</table>
	</fieldset>
	</form>
	</div>
</body>
</html>