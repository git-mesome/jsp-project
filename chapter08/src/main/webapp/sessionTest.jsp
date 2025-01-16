<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2025. 1. 15.
  Time: 오후 5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = "";
    String email = "";
    if (session.getAttribute("name") != null && session.getAttribute("email") != null) {
        name = (String) session.getAttribute("name");
        email = (String) session.getAttribute("email");
    } else if (session.getAttribute("name") != null) {
        name = (String) session.getAttribute("name");
    } else if (session.getAttribute("email") != null) {
        email = (String) session.getAttribute("email");
    } else {
        name = "세션 값 없음";
    }
%>
<html>
<head>
    <title>Session Test</title>
</head>
<body>
<h2>세션 테스트</h2>
<input type="button" onclick="location.href='sessionSet.jsp'" value="세션 값 저장">
<input type="button" onclick="location.href='sessionDel.jsp'" value="세션 값 삭제">
<input type="button" onclick="location.href='sessionInvalidate.jsp'" value="세션 값 초기화">
<h3><%=name%>
    <%=email%>
</h3>
</body>
</html>
