<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% request.setCharacterEncoding("UTF-8");%>
    <% response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>속닥속닥 작성</title>
</head>
<body>
	
	
	<div>
	<fieldset>
		<table>
			<tr>
				<th>작성자</th>
				<td>${dto.boardGender }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.boardTitle }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="15" cols="30">
					 ${dto.boardContent }
				</textarea>
				</td>
			</tr>
		</table>
	</fieldset>
	</div>
	


</body>
</html>