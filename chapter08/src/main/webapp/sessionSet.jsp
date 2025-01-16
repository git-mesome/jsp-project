<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2025. 1. 15.
  Time: 오후 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.setAttribute("name", "Session Name Test!");
    session.setAttribute("email", "Session Email Test!");
%>
<script>
    location.href = "sessionTest.jsp";
</script>