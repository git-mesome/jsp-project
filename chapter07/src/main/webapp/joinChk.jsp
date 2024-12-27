<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="join" class="io.wisoft.tutorial.chapter07.join.JoinBean"/>
<jsp:setProperty name="join" property="*"/>

<html>
<head>
    <title>회원가입 입력 정보 확인 페이지</title>
    <link href="css/joinChk.css" rel="stylesheet" type="text/css">
</head>
<body>
<table>
    <tr>
        <td><b>아이디 : </b></td>
        <td><jsp:getProperty name="join" property="id"/></td>
    </tr>
    <tr>
        <td><b>비밀번호 : </b> </td>
        <td><jsp:getProperty name="join" property="pass"/></td>
    </tr>
    <tr>
        <td><b>이름 : </b></td>
        <td><jsp:getProperty name="join" property="name"/></td>
    </tr>
    <tr>
        <td><b>성별 : </b></td>
        <td><jsp:getProperty name="join" property="sex"/></td>
    </tr>
    <tr>
        <td><b>나이 : </b></td>
        <td><jsp:getProperty name="join" property="age"/></td>
    </tr>
    <tr>
        <td><b>이메일주소 : </b></td>
        <td><jsp:getProperty name="join" property="email"/></td>
    </tr>
</table>
</body>
</html>
