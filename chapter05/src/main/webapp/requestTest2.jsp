<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<html>
<head>
    <title>Request Test2</title>
    <link href="css/requestTest2.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>헤더정보 예제</h1>
<table>
    <tr>
        <td>헤더이름</td>
        <td>헤더값</td>
    </tr>
    <%
        Enumeration e=request.getHeaderNames();
        while(e.hasMoreElements()){
            String headerName=(String)e.nextElement();
    %>
    <tr>
        <td><%=headerName %></td>
        <td><%=request.getHeader(headerName) %></td>
            <%}%>

</table>
</body>
</html>
