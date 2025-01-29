<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("test","Session Test");
%>
<html>
<head>
<title>EL 내장객체 사용 예제</title>
<link href="css/el_test1.css" rel="stylesheet" type=text/css>
</head>
<body>
<form action="el_test2.jsp" method="post">
<table>
	<tr>
		<td>이름 : </td>
		<td><input type="text" name="name" value="홍길동"></td>
	</tr>
	<tr>
		<td colspan=2 align=center><input type="submit" value="입력"></td>
	</tr>
</table>
</form>
</body>
</html>
