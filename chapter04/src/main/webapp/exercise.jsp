<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2025. 1. 3.
  Time: 오후 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.time.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ZonedDateTime kstTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
    ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));

    System.out.println(kstTime);
    System.out.println(utcTime);

%>
<%=kstTime%>
<br>
<%=utcTime%>
</body>
</html>
