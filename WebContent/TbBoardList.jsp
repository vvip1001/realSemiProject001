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
</head>
<body>
	<div id="head"></div>

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
					<c:forEach items="${list }" var="dto" >
						<tr>
							<td align="center" >${dto.boardNum }</td>
							<td>
								<c:forEach begin="1" end="${dto.boardTab }" >
								 &nbsp;
								</c:forEach>
								<a href="TbBoard.do?command=boarddetail&boardnum=${dto.boardNum }" >${dto.boardTitle }</a>
							</td>
							<td align="center">${dto.boardGender }</td>
							<td align="center">${dto.boardDate }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="4" align="right" ><input type="button" value="글쓰기" onclick="location.href='TbBoard.do?command=boardwriteform'"/></td>
			</tr>
		</table>
	</fieldset>
	</div>
</body>
</html>