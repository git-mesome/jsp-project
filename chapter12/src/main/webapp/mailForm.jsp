<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2025. 1. 21.
  Time: 오후 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>자바 메일 보내기 폼</title>
    <link rel="stylesheet" href="css/mailForm.css" type="text/css">
</head>
<body>
<form action="mailSend" method="post">
    <h1>자바 메일 보내기</h1>
    <table>
        <tr>
            <td>보내는 사람 메일 :</td>
            <td><input type="text" name="sender"></td>
        </tr>
        <tr>
            <td>받는 사람 메일 :</td>
            <td><input type="text" name="receiver"></td>
        </tr>
        <tr>
            <td>제목 :</td>
            <td><input type="text" name="subject"></td>
        </tr>
        <tr>
            <td>내용 :</td>
            <td><textarea name="content" cols="40" rows="20"></textarea></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="보내기">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
