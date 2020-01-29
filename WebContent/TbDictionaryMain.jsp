<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% request.setCharacterEncoding("UTF-8");%>
    <% response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>니캉 내캉</title>
</head>
<body>
	
	<%@ include file="./form/mainPage.jsp" %>
	
	<div>니 캉 내 캉<br/>
	
	<input type="text" name="search"/>검색
	
	</div>
	
	<div>
	<table>
		
		<col width="150px">
		<col width="150px">
		
	<tr>
		<td>남자어</td>
	</tr>
	
	</table>
	
	<table>
		<col width="150px">
		<col width="150px">
	<tr>
		<td>여자어</td>
	</tr>
	</table>
	</div>

</body>
</html>