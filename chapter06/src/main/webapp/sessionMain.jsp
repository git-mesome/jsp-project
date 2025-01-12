<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
  <title>Attribute Test Form</title>
</head>
<body>
<h2>세션 실습</h2>
<form action="sessionTest.jsp" method="post">
<table border="1" >
  <tr>
    <td colspan="2">Session 영역에 저장할 내용들</td>
  </tr>
  <tr>
    <td>이름</td>
    <td><input type="text" name="name"></td>
  </tr>
  <tr>
    <td>아이디</td>
    <td><input type="text" name="id"></td>
  </tr>
  <tr>
    <td>이메일</td>
    <td><input type="text" name="email"></td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" value="전송"></td>
  </tr>
</table>
</form>
</body>
</html>