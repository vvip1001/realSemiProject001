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
<% 
	TbUserDto dto = (TbUserDto)session.getAttribute("dto");
	TbGroupDto groupdto = (TbGroupDto)request.getAttribute("groupdto");
%>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function(){ $("#alert-success").hide(); 
	$("#alert-danger").hide();
	$("input").keyup(function(){ var pwd1=$("#pwd1").val(); 
	var pwd2=$("#pwd2").val(); if(pwd1 != "" || pwd2 != ""){ 
		if(pwd1 == pwd2){ 
			$("#alert-success").show(); 
			$("#alert-danger").hide(); 
			$("#submit").removeAttr("disabled");
			}else{ 
				$("#alert-success").hide(); 
				$("#alert-danger").show(); 
				$("#submit").attr("disabled", "disabled"); 
				} 
			} 
		}); 
	});
	
		
</script>
<body>
<h1>유저 정보 수정 테이블 </h1>

	<form action="TbUser.do" method="post">
	<input type="hidden" name="command" value="userupdateformres">
		<table border=1>	
			<tr>
				<th>우리자기</th>
<%
	if(groupdto.getPartnerId().equals("N") || groupdto.getPartnerId() == null){

%>
			<td><input type="text" name="partnerId" value="상대방 아이디를 입력해 주세요" ></td>
<% 
	}else{
%>
			<td><input type="text" name="partnerId" value="<%=groupdto.getPartnerId() %>" ></td>
<%
	}
%>	
			
				
			</tr>
			<tr>	
				<th>새로운 비밀번호</th>
				<td> <input type="password" name="userPwd" id="pwd1" class="form-control" required /> </td>
			</tr>
			<tr>	
				<th>새로운 비밀번호 확인</th>
				<td><input type="password" name="reuserPwd" id="pwd2" class="form-control" required /></td>

			</tr>
			<tr>	
				<th>이메일</th>
				<td><input type="email" name="userEmail" value="<%=dto.getUserEmail() %>"></td>
				
			</tr>
			<tr>	
				<th>나의애칭바꾸기</th>
				<td><input type="text" name="userNick" value="<%=dto.getUserNick()%>"></td>
				
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정완료"/>
					<input type="button" value="취소" onclick="location.href='TbUser.do?command=mypage&logindto1=<%=dto.getUserStatus() %>'"/>
				</td>
			</tr>
		</table>
	</form>

<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div> 
<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>

</body>
</html>