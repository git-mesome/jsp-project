<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%@page import="javax.naming.*" %>
<%@ page import="javax.sql.DataSource" %>

<%
    String sql = "select * from student";

    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgres");

        // type scroll sensitive : scroll이 포함된 타입으로 지정해야 커서 이동 가능
        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);) {

            try (ResultSet rs = pstmt.executeQuery()) {
                rs.last();
                out.println(rs.getInt(1) + ", " + rs.getString(2) + "<br>");
                rs.first();
                out.println(rs.getInt(1) + ", " + rs.getString(2) + "<br>");
                rs.absolute(3);
                out.println(rs.getInt(1) + ", " + rs.getString(2) + "<br>");

            }

        } catch (Exception e) {
            out.println("<h3>레코드 등록에 실패하였습니다.</h3>");
            e.printStackTrace();
        }
    } catch (NamingException e) {
        throw new RuntimeException(e);
    }
%>