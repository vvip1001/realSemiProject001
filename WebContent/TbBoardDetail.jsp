<%@page import="com.between.dto.TbBoardDto"%>
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
	TbBoardDto board = (TbBoardDto)request.getAttribute("board");

	if(userInfo==null){
		pageContext.forward("index.jsp");
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
				<td><%=board.getBoardGender() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=board.getBoardTitle() %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="15" cols="30" readonly="readonly" ><%=board.getBoardContent() %></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" value="답글작성" onclick="location.href='TbBoard.do?command=boardanswer&boardNum=<%=board.getBoardNum()%>'"/>
				</td>
				<td colspan="2" align="right" id=<%=(board.getUserId().equals(userInfo.getUserId())) ? "":"hideButton" %> >
					<input type="submit" value="수정"/>
					<input type="button" value="삭제" onclick="location.href='TbBoard.do?command=boarddelete&boardNum=<%=board.getBoardNum()%>'"/>
				</td>
			</tr>
		</table>
	</fieldset>
	</form>
	</div>
</body>
</html>