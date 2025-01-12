<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2025. 1. 10.
  Time: 오후 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr><td colspan="2">Session 영역에 저장된 내용들</td></tr>
    <tr>
        <td>이름</td>
        <td><%=session.getAttribute("name")%></td>
    </tr>
    <tr>
        <td>이메일</td>
        <td><%=session.getAttribute("id")%></td>
    </tr>

</table>
</body>
</html>
