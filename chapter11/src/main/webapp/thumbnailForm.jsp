<%--
  Created by IntelliJ IDEA.
  User: minseo
  Date: 2025. 1. 21.
  Time: 오후 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>썸네일 이미지 폼</title>
</head>
<body>
<h3>썸네일 이미지 폼 예제</h3>
<form action="ThumbnailServlet" method="post" enctype="multipart/form-data">
    이미지 파일 : <input type="file" name="filename">
    <p>
        <input type="submit" value="전송">
</form>
</body>
</html>
