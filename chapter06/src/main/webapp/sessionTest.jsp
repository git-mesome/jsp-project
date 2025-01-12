<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2025. 1. 10.
  Time: 오후 3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.setMaxInactiveInterval(10);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String id = request.getParameter("id");
    String email = request.getParameter("email");

    session.setAttribute("name", name);
    session.setAttribute("id", id);
    session.setAttribute("email", email);
%>
<%=name%>의 정보가 모두 저장되었습니다.
<jsp:include page="sessionTest2.jsp"/>
</body>
</html>
