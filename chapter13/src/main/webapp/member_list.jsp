<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
    String id=null;

    if ((session.getAttribute("id")==null) ||
            (!((String)session.getAttribute("id")).equals("admin"))) {
        out.println("<script>");
        out.println("location.href='loginForm.jsp'");
        out.println("</script>");
    }

    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgres");
        conn = ds.getConnection();

        pstmt=conn.prepareStatement("SELECT * FROM member");
        rs=pstmt.executeQuery();
    }catch(Exception e){
        e.printStackTrace();
    }

%>
<html>
<head>
    <title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
    <link href="css/member_list.css" rel="stylesheet" type="text/css">
</head>
<body>
<table>
    <tr><td colspan=2 class="td_title">회원 목록</td></tr>
    <%while(rs.next()){%>
    <tr>
        <td>
            <a href="member_info.jsp?id=<%=rs.getString("id") %>">
                <%=rs.getString("id") %>
            </a>
        </td>
        <td>
            <a href="member_delete.jsp?id=<%=rs.getString("id") %>">삭제</a>
        </td>
    </tr>
    <%} %>
</table>
</body>
</html>
