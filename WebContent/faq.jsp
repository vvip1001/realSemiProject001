<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function popupWindow(){
	
 
	window.open("EmailConfirmForm.jsp","","width=650px, height=300px");
	
	
}


</script>
	
</head>
<body>
<%
int RandomNumber=(int)(Math.floor(Math.random() * (9999-1000+1)) + 1000);
%>


	<form name="a" action="mailSend.jsp" method="post">
	<input type="hidden" name="to" value="hoyhi123@naver.com"> 
	<input type="hidden" name="from" value="hoyhi123@naver.com">
	<input type="hidden" name="number" value="<%=RandomNumber%>">
	<input type="submit" value="인증코드전송" onclick="popupWindow();">
	</form>
<script> 
</script>

</body>
</html>