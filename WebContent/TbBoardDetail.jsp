<%@page import="com.between.dto.PageMaker"%>
<%@page import="java.util.List"%>
<%@page import="com.between.dto.TbReBoardDto"%>
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
<%@ include file="./form/mainPage.jsp" %>
<%
//	TbUserDto userInfo = (TbUserDto)session.getAttribute("dto");
	TbBoardDto board = (TbBoardDto)request.getAttribute("board");
	
	PageMaker pageMaker = (PageMaker)request.getAttribute("pageMaker");
	List<TbReBoardDto> list = (List<TbReBoardDto>)request.getAttribute("list");
	
	if(userInfo==null){
		pageContext.forward("index2.jsp");
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
		<fieldset>
		<form action="TbBoard.do" method="post" >
			<input type="hidden" name="command" value="boardreple" />
			<input type="hidden" name="boardNum" value="<%=board.getBoardNum()%>"/>
			<input type="hidden" name="userId" value="<%=userInfo.getUserId()%>"/>
			<input type="hidden" name="reGender" value="<%=userInfo.getUserGender()%>"/>
			<table>
<%
				for(int i = 0; i < list.size(); i++){
%>
				<tr>
					<td><%=list.get(i).getReGender()%> </td>
					<td><%=list.get(i).getReContent()%> </td>
				
<%				
					if(userInfo.getUserId().equals(list.get(i).getUserId())){
%>
					<td align="right" >
						<input type="button" value="삭제"/>
						<input type="button" value="수정"/>
					</td>
				
<%						
					}
%>
				</tr>
<%
				}
%>
				<tr>
					<td colspan="4" align="center">
							<c:if test="${pageMaker.prev }">
								<a href="TbBoard.do?command=boarddetail&boardnum=<%=board.getBoardNum() %>&page=1">처음으로</a>
								<a href="TbBoard.do?command=boarddetail&boardnum=<%=board.getBoardNum() %>&page=${pageMaker.startPage-1 }">이전</a>
							</c:if>
							<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
								 <a class="pageNum" href="TbBoard.do?command=boarddetail&boardnum=<%=board.getBoardNum()%>&page=${pageNum }">${pageNum } </a> 
							</c:forEach>
							<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
								<a href="TbBoard.do?command=boarddetail&boardnum=<%=board.getBoardNum() %>&page=${pageMaker.endPage+1 }">다음</a> 
								<a href="TbBoard.do?command=boarddetail&boardnum=<%=board.getBoardNum() %>&page=${pageMaker.tempEndPage }" >마지막</a>
							</c:if>
					</td>
				</tr>
				<tr>
					<td>
						<textarea  name="reContent" rows="5" cols="35" ></textarea>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="댓글작성"/>
					</td>
				</tr>
			</table>
			
		</form>
		</fieldset>
	</div>
</body>
</html>