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

            try (ResultSet rs = pstmt.executeQuery();) {
                ResultSetMetaData rsmd = rs.getMetaData();

                out.println("컬럼 수" + rsmd.getColumnCount() + "<br>");

                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    out.println(i + "번째 컬럼 이름 : " + rsmd.getColumnName(i) + " >");
                    out.println(i + "번째 컬럼 타입 이름 : " + rsmd.getColumnTypeName(i) + "<br>");
                }

                while (rs.next()) {
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    } catch (NamingException e) {
        throw new RuntimeException(e);
    }
%>