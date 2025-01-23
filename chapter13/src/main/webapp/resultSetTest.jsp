<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%@page import="javax.naming.*" %>
<%@ page import="javax.sql.DataSource" %>

<%
    String sql = "select * from student";

    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgres");

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    out.println("<h3>" + rs.getInt(1) + ", " + rs.getString(2) + "</h3>");
                }
            }

        } catch (Exception e) {
            out.println("<h3>레코드 등록에 실패하였습니다.</h3>");
            e.printStackTrace();
        }
    } catch (NamingException e) {
        throw new RuntimeException(e);
    }
%>