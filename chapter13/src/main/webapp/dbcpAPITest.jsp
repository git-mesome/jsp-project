<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2025. 1. 23.
  Time: 오전 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%@page import="javax.naming.*" %>
<%@ page import="javax.sql.DataSource" %>

<%
    Connection conn = null;

    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgres");
        conn = ds.getConnection();

        out.println("<h3>연결 되었습니다..</h3>");

    } catch (Exception e) {
        out.println("<h3>연결에 실패하였습니다.</h3>");
        e.printStackTrace();
    }
%>