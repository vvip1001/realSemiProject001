<%@page import="com.between.dto.TbGroupDto"%>
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

<% 
	TbUserDto dto = (TbUserDto)session.getAttribute("dto"); 
	String partnerId = String.valueOf(request.getAttribute("partnerId"));
	
	//System.out.println(partnerId);
%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	alert('유저님의 마이페이지입니다. 환영합니다.');
	
	function alertinsert() {
		alert('두번째 상대등록은  수정버튼을 눌러 회원정보 수정에서 해주세요');
		location.href = '';
	}
	
</script>
<div>
	<h1>유저 마이페이지</h1>
	<h1>나의 애칭<%=dto.getUserNick() %></h1>
	<table border=1>
		<tr>
			<td>우리자기</td>
			
			<td>
			<form action="TbUser.do" method="post">
				<input type="hidden" name="command" value="partnerinsert">
				<input type="hidden" name="userId" value="<%=dto.getUserId() %>">	
					

<%
				if(partnerId.equals("N")){
%>
				<input type="text" name="partnerId" placeholder="상대의 아이디  입력" >
				<input type="submit" value="상대등록하기" />
<%
				}else{
%>
				<input type="text" name="partnerId" value="<%=partnerId %>" readonly="readonly" >
<%					
				}
%>
			</form>
			</td>

		</tr>
		<tr>
			<td>email</td>
			<td><%=dto.getUserEmail() %></td>
		</tr>

		
		<tr>
			<td>회원정보 수정하기 </td>
			<td><input type="button" onclick="location.href='TbUser.do?command=userupdateform&partnerId=<%=partnerId %>'" value="수정" ></td>
		</tr>
		
	</table>
		
		<form action="TbUser.do" method="post">
		<input type="hidden" name="command" value="userboardlist">
		<input type="hidden" name="userId" value="<%=dto.getUserId()%>">
			<h1>내글보기</h1>
			<input type="password" name = "equserPw">
			<input type="submit" value="비밀번호">
		</form>
	<input type="button" value="로그아웃" onclick="location.href='TbUser.do?command=logout'">
	<input type="button" value="로그인뒤 보이는 첫페이지로" onclick="location.href='TbUser.do?command=loginres&userId=<%=dto.getUserId() %>&userPw=<%=dto.getUserPw() %>'">
	
</div>
</body>
</html>