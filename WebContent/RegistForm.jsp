<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html;charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<script type="text/javascript">
	function popupWindow() {

		window.open("EmailConfirmForm.jsp", "", "width=500px, height=300px");

	}

	function idChk() {
		var doc = document.getElementsByName("userid")[0];
		if (doc.value.trim() == "" || doc.value == null
				|| doc.value == "indefined") {
			alert("아이디를 입력해 주세요!");

		} else {
			open("TbUser.jsp?command=idChk&userid=" + doc.value, "",
					"width=200,height=200");
		}

	}

	function idChkConfirm() {
		var chk = document.getElementsByName("userid")[0].title;

		if (chk == "n") {
			alert("아이디 중복체크를 먼저 해주세요");
			document.getElementsByName("userid")[0].focus();
		}
	}
</script>
</head>
<body>

	<form action="TbRegist.do" method="post">
		<input type="hidden" name="command" value="insert">

		<table border="1">


			<tr>
				<th>아이디</th>
				<td><input type="text" name="userid" required="required">
					<input type="button" value="조회" onclick="idChk();"></td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="userpw"
					onclick="idChkConfirm();" required="required"></td>
			</tr>
			<tr>
				<th>비빌번호확인</th>
				<td><input type="password" required="required"></td>
			</tr>

			<tr>
				<th>Email</th>
				<td><input type="email" name="useremail"
					placeholder="abc@naver.com"> <input type="button"
					value="인증하기" onclick="location.href='TbRegist.do?command=email'"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="radio" name="usergender" checked="checked"
					value="남자" /> 남 <input type="radio" name="usergender" value="여자" />
					여</td>
			</tr>



			<tr>

				<td colspan="3" align="right"><input type="submit" value="회원가입" />
					<input type="button" value="취소" onclick="location.href=index.html"></td>
			</tr>
		</table>
	</form>




</body>
</html>