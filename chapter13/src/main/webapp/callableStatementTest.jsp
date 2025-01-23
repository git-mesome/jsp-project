<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%@page import="javax.naming.*" %>
<%@ page import="javax.sql.DataSource" %>

<%
    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgres");
        String sql = "CALL get_annual_income(?,?)";

        try (Connection conn = ds.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql);) {
            cstmt.setString(1, "aaa");
            cstmt.registerOutParameter(2, Types.INTEGER);
            cstmt.execute();

            out.println("<h3>" + cstmt.getInt(2) + "</h3>");

        } catch (Exception e) {
            out.println("<h3>레코드 등록에 실패하였습니다.</h3>");
            e.printStackTrace();
        }
    } catch (NamingException e) {
        throw new RuntimeException(e);
    }
%>