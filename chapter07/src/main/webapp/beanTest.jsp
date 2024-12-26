<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2024. 12. 23.
  Time: 오후 5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="beantest" class="io.wisoft.tutorial.chapter07.test.BeanTest" scope="page"/>
<%--<jsp:setProperty name="beantest" property="name" value="BeanTest!"/>--%>
<%--<jsp:setProperty name="beantest" property="name" param="name"/>--%>

<html>
<head>
    <title>JavaBean Test</title>
</head>
<body>
<b>자바빈 사용 예제</b>
<h3>
    <%=beantest.getName()%>
</h3>
<h3>
    <jsp:getProperty name="beantest" property="name"/>
</h3>
</body>
</html>
