<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2025. 1. 16.
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie cookie = new Cookie("language", request.getParameter("language"));
    cookie.setMaxAge(60 * 60 * 24);
    response.addCookie(cookie);
%>
<script>
    location.href="cookieExample1.jsp"
</script>