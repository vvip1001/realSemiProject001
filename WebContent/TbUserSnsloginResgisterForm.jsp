<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8");%>
    <% response.setContentType("text/html; charset=UTF-8");%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">


window.onload=function(){
	appendYear();
	appendMonth();
	appendDay();
}



function appendYear(){

	var date = new Date();

	var year = date.getFullYear();

	var selectValue = document.getElementById("year");

	var optionIndex = 0;



	for(var i=year-100;i<=year;i++){

			selectValue.add(new Option(i+"년",i),optionIndex++);                        

	}

}





function appendMonth(){

	var selectValue = document.getElementById("month"); 

	var optionIndex = 0;



	for(var i=1;i<=12;i++){

			selectValue.add(new Option(i+"월",i),optionIndex++);

	}

}





function appendDay(){

	var selectValue = document.getElementById("date");

	var optionIndex = 0;



	for(var i=1;i<=31;i++){

			selectValue.add(new Option(i+"일",i),optionIndex++);

	}

}

</script>

</head>
<body>
	<form action="TbUser.do" method="post">
		<input type="hidden" name="command" value="snsloginregisterformres">

		<table border="1">


			<tr>
				<th>아이디</th>
				<td><input type="text" name="userId" value=""></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="userName" value=""></td>
			</tr>
	
			<tr>
				<th>이메일</th>
				<td><input type="email" name="userEmail" ></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="userGender" checked="checked" value="MALE" /> 남
					<input type="radio" name="userGender" value="FEMALE" />여
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
                <td>
                		
                		<select name="year" id="year">
                        <option value="">---선택하세요---</option>
                    	</select> 년
                    	
                		
                		<select name="month" id="month">
                        <option value= "" >---선택하세요---</option>
	                    </select> 월                 

                		
                		<select name="date" id="date">
                        <option value="">---선택하세요---</option>
	                    </select> 일              
  
                </td>
            </tr>

			<tr>

				<td colspan="3" align="right">
					<input type="submit" value="회원가입" />
					<input type="button" value="취소" onclick="location.href='index2.jsp'">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>