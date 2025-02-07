<%@ page import="io.wisoft.seminar.vo.BoardBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
    BoardBean article = (BoardBean) request.getAttribute("article");
    String nowPage = (String) request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>MVC 게시판</title>
    <script language="javascript">
    </script>

    <link href="board/css/qna_board_reply.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 게시판 답변 -->


<section id="writeForm">
    <h2>게시판글등록</h2>
    <form action="boardReplyPro.bo" method="post" name="boardform">
        <input type="hidden" name="page" value="<%=nowPage %>"/> <input
            type="hidden" name="board_num" value="<%=article.getBoard_num() %>">
        <input type="hidden" name="board_re_ref"
               value="<%=article.getBoard_re_ref() %>"> <input
            type="hidden" name="board_re_lev"
            value="<%=article.getBoard_re_lev() %>"> <input
            type="hidden" name="board_re_seq"
            value="<%=article.getBoard_re_seq() %>">
        <table>
            <tr>
                <td class="td_left"><label for="board_name">글쓴이</label></td>
                <td class="td_right"><input type="text" name="board_name"
                                            id="board_name"/></td>
            </tr>
            <tr>
                <td class="td_left"><label for="board_pass">비밀번호</label></td>
                <td class="td_right"><input name="board_pass" type="password"
                                            id="board_pass"/></td>
            </tr>
            <tr>
                <td class="td_left"><label for="board_subject">제 목</label></td>
                <td class="td_right"><input name="board_subject" type="text"
                                            id="board_subject"/></td>
            </tr>
            <tr>
                <td class="td_left"><label for="board_content">내 용</label></td>
                <td><textarea id="board_content" name="board_content"
                              cols="40" rows="15"></textarea></td>
            </tr>
        </table>
        <section id="commandCell">
            <input type="submit" value="답변글등록"/>&nbsp;&nbsp; <input
                type="reset" value="다시작성"/>
        </section>
    </form>
</section>
</body>
</html>