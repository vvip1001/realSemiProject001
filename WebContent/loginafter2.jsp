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

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 신청들어올경우  팝업창  -->
<style>	
	
.background{
	display:none; 
	position:fixed; 
	_position:absolute; 
	top:0; 
	left:0; 
	width:100%;  
	height:100%; 
	z-index:100;
	}
.background .dimBackground {
	position:absolute; 
	top:0; 
	left:0; 
	width:100%; 
	height:100%;
	 background:#000; 
	 opacity: .5; 
	 filter:alpha(opacity=70);
	 }
.background .popuplayer{
	display:block;
	}
.popuplayer {
	background-color:white;
	width:300px;
	height:200px;
	display:none;
	position:absolute;
	top:50%;
	left:50%;
	z-index:10;
	color:#000;
	}
	
	#closepop{
	position: absolute;
	right: 115px;
	bottom: 10px;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function layer_popup(el){
	var $el = $(el); 
	var isDim = $el.prev().hasClass('dimBackground');
	isDim ? $('.background').show() : $el.show();
	var $elWidth = ~~($el.outerWidth()),
		$elHeight = ~~($el.outerHeight()),
		docWidth = $(document).width(),
		docHeight = $(document).height();
	
	if ($elHeight < docHeight || $elWidth < docWidth) {
		$el.css({
			marginTop: -$elHeight /2,
			marginLeft: -$elWidth/2
		});
	}
	else{
		$el.css({top: 0, left: 0});
	}
}
function closelayer(){
	var isDim = $(".popuplayer").prev().hasClass('dimBackground'); 
	isDim ? $('.background').hide() : $el.hide(); 
}
	
</script>
 <%
	TbUserDto dto = (TbUserDto)session.getAttribute("dto");
    /*if(dto==null){
 	  pageContext.forward("index.html");	
     }*/
	//String userId = String.valueOf((TbGroupDto)request.getAttribute("userId"));
    TbGroupDto groupdto = (TbGroupDto)request.getAttribute("groupdto");
%>  
</head>
<body>
<h1>뭐라도 좋으니 좀 떠봐라 이녀석아 </h1>	

<input type="button" Class="btn" value="커플 알림 내용 열기" onCLick="layer_popup('#popuplayer');">

<div class="background">
<div class="dimBackground"></div>
<div id="popuplayer" class="popuplayer" align="center">

	<!-- 커플 신청이 들어왔을때 보여지는 화면 -->
	<table>
<% 
	if(groupdto.getPartnerId().equals(dto.getUserId()) && groupdto.getGroupCheck().equals("N")){
%>
	<tr>
		<th><%=groupdto.getUserId() %>로 부터 커플 신청이 들어 왔습니다 <br>
			수락하시겠습니까?<br>
		</th>
		<td>
			<input type="button" value="수락하기" class="btn" onclick="location.href='TbUser.do?command=after2&check=yes&groupNum=<%=groupdto.getGroupNum() %>&userId=<%=dto.getUserId() %>'">
			<input type="button" value="거절하기" class="btn"onclick="location.href='TbUser.do?command=after2&check=no&groupNum=<%=groupdto.getGroupNum() %>&userId=<%=dto.getUserId() %>'">
			
		</td>
	</tr>

<%
  }else{
%>
    <tr>
    	<td>
	  ---------신청 내용이 없습니다 --------
		</td>
	</tr>

	
<%
  }

%>
	</table>
	<div id="closepop" align="center">
	<input type="button" Class="btn" value="팝업 닫기"  onClick='closelayer();'>
	</div>
	
</div>
</div>

	<input type="button" value="로그아웃" onclick="location.href='TbUser.do?command=logout'">
	<input type="button" value="로그인뒤 보이는 첫페이지로" onclick="location.href='TbUser.do?command=loginres&userId=<%=dto.getUserId() %>&userPw=<%=dto.getUserPw() %>'">


	
</body>
</html>