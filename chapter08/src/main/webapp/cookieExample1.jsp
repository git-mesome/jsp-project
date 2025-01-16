<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2025. 1. 16.
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String language = "korea";
    String cookie = request.getHeader("Cookie");

    if (cookie != null) {
        Cookie[] cookies = request.getCookies();

        for (final Cookie cookieValue : cookies) {
            if (cookieValue.getName().equals("language")) {
                language = cookieValue.getValue();
            }
        }
    }
%>
<html>
<head>
    <title>쿠키를 이용한 화면 설정 예제</title>
</head>
<body>
<%if (language.equals("korea")) {%>
<h3>안녕하세요. 이것은 쿠키 예제입니다.</h3>
<%} else {%>
<h3>Hello. This is Cookie example.</h3>
<%}%>

<form action="cookieExample2.jsp" method="post">
    <input type="radio" name="language" value="korea"
        <%if(language.equals("korea")){%>
           checked
        <%}%>>한국어 페이지 보기
    <input type="radio" name="language" value="english"
        <%if(language.equals("english")){%>
           checked
        <%}%>>영어 페이지 보기
    <input type="submit" value="설정">
</form>

</body>
</html>
