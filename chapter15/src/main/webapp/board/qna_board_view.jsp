<%@ page import="io.wisoft.seminar.vo.BoardBean" %>
<%@page language="java" contentType="text/html; charset=UTF-8" %>

<%
    BoardBean article = (BoardBean) request.getAttribute("article");
    String nowPage = (String) request.getAttribute("page");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MVC 게시판</title>
    <link href="board/css/qna_board_view.css" rel="stylesheet" type="text/css">
</head>

<body>
<!-- 게시판 수정 -->
<section id="articleForm">
    <h2>글 내용 상세보기</h2>
    <section id="basicInfoArea">
        제 목 :
        <%=article.getBoard_subject()%>
        첨부파일 :
        <%if (!(article.getBoard_file() == null)) { %>
        <a href="file_down?downFile=<%=article.getBoard_file()%>"><%=article.getBoard_file() %>
        </a>
        <%} %>
    </section>
    <section id="articleContentArea">
        <%=article.getBoard_content() %>
    </section>
</section>
<section id="commandList">
    <a
            href="boardReplyForm.bo?board_num=<%=article.getBoard_num() %>&page=<%=nowPage%>">
        [답변] </a> <a
        href="boardModifyForm.bo?board_num=<%=article.getBoard_num() %>">
    [수정] </a> <a
        href="boardDeleteForm.bo?board_num=<%=article.getBoard_num() %>&page=<%=nowPage%>">
    [삭제] </a> <a href="boardList.bo?page=<%=nowPage%>">[목록]</a>&nbsp;&nbsp;
</section>
</body>
</html>