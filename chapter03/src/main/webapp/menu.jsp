<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2024. 12. 13.
  Time: 오전 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%-- JSP에서는 세션 객체 자동 생성 가능 --%>
<%
    String id = (String) session.getAttribute("id");
%>
<body>
<%
    if (id == null) {
%>
<a href="login.jsp">로그인</a>
<%
} else {
%>
<%=id %> 님 환영합니다.
<%
    }
%>
</body>
</html>