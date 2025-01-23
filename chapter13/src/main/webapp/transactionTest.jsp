<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%@page import="javax.naming.*" %>
<%@ page import="javax.sql.DataSource" %>

<%
    String sql1 = "insert into student values (13,'홍길동');";
    String sql2 = "select * from student where num=12;";

    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgres");

        try (Connection conn = ds.getConnection();) {

            //트랜잭션 시작 구간
            conn.setAutoCommit(false);

            try (PreparedStatement pstmt = conn.prepareStatement(sql1);) {
                pstmt.executeUpdate();
            }

            try (PreparedStatement pstmt = conn.prepareStatement(sql2);) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (!rs.next()) {
                        conn.rollback();
                        out.println("<h3>데이터 삽입에 문제가 발생하여 롤백합니다.</h3>");
                    } else {
                        conn.commit();
                        out.println("<h3>데이터 삽입이 모두 완료되었습니다.</h3>");

                    }
                }
            }

            conn.setAutoCommit(true)

        } catch (Exception e) {
            out.println("<h3>데이터 삽입이 실패하였습니다.</h3>");
            e.printStackTrace();
        }
    } catch (NamingException e) {
        throw new RuntimeException(e);
    }
%>