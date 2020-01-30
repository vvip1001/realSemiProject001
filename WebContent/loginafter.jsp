<%@page import="com.between.dto.TbGroupDto"%>
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
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	TbUserDto dto = (TbUserDto)session.getAttribute("dto");
    if(dto==null){
 	  pageContext.forward("index.jsp");	
     }
	
    TbGroupDto groupdto = (TbGroupDto)session.getAttribute("groupdto");
%>


<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
</script>
<body>

<div>
	
	<h1>로그인뒤 보이는 첫 화면 </h1>
	<form action="TbUser.do" method="post">
	<input type="hidden" name="command" value="mypage">
	<input type="hidden" name="userStatus" value=<%=dto.getUserStatus() %>>
		<input type="button" value="로그아웃" onclick="location.href='TbUser.do?command=logout'">
		<input type="submit" value="마이페이지">
		
	</form>
<%
 if(groupdto.getGroupCheck().equals("N")){
	 
%> 
	<input type="button" value="로그인 2번째 페이지로...이창내에서 팝업 어케할지 모르겠음 " onclick="location.href='TbUser.do?command=loginafter2'">
<%
 }
%>	
	
	
</div>	
</body>
</html>