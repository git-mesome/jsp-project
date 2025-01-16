<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2025. 1. 16.
  Time: 오후 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%session.setAttribute("id", request.getParameter("id"));%>
<html>
<head>
    <title>Session Login</title>
</head>
<body>
<h3>로그인 되었습니다.</h3>
<h3>로그인 아이디: <%=(String) session.getAttribute("id")%>
</h3>
<a href="sessionLogout.jsp">로그아웃</a>
</body>
</html>