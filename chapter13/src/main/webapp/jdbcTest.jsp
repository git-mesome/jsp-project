<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2025. 1. 23.
  Time: 오전 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%
    Connection conn = null;

    final String url = "jdbc:postgresql://localhost:15432/mvc";
    final String user = "java";
    final String password = "java";
    boolean connect = false;

    try {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, user, password);

        connect = true;

        conn.close();

    } catch (Exception e) {
        connect = false;
        e.printStackTrace();
    }
%>
<html>
<head>
    <title>JDBC 연동 테슽 예제</title>
</head>
<body>
<h3>
    <% if (connect) {%>
    연결되었습니다.
    <%} else {%>
    연결에 실패하였습니다.
    <%}%>
</h3>
</body>
</html>
