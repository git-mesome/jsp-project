<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%@page import="javax.naming.*" %>
<%@ page import="javax.sql.DataSource" %>

<%
    String sql = "INSERT INTO student (num, name) VALUES (?,'홍길동')";

    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgres");

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            for (int i = 8; i < 12; i++) {
                pstmt.setInt(1, i);
                if (pstmt.executeUpdate() != 0) {
                    out.println("<h3>" + i + "번 레코드를 등록하였습니다.</h3>");
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