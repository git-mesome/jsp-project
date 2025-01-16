<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2025. 1. 15.
  Time: 오후 6:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie cookie = new Cookie("name", "hongkildong");
    cookie.setMaxAge(600);
    response.addCookie(cookie);
%>
<html>
<head>
    <title>Cookie Test</title>
</head>
<body>
<h2><%=cookie.getName()%></h2>
<h2><%=cookie.getValue()%></h2>
<h2><%=cookie.getMaxAge()%></h2>
<a href="cookieTest2.jsp">쿠키 값 불러오기</a>
</body>
</html>
