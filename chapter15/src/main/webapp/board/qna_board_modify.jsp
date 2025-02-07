<%@ page import="io.wisoft.seminar.vo.BoardBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
    BoardBean article = (BoardBean) request.getAttribute("article");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MVC 게시판</title>
    <script type="text/javascript">
        function modifyboard() {
            modifyform.submit();
        }
    </script>
    <link href="board/css/qna_board_modify.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 게시판 등록 -->

<section id="writeForm">
    <h2>게시판글수정</h2>
    <form action="boardModifyPro.bo" method="post" name="modifyform"
    >
        <input type="hidden" name="board_num" value="<%=article.getBoard_num()%>"/>
        <table>
            <tr>
                <td class="td_left">
                    <label for="board_name">글쓴이</label>
                </td>
                <td class="td_right">
                    <input type="text" name="board_name" id="board_name" value="<%=article.getBoard_name()%>"/>
                </td>
            </tr>
            <tr>
                <td class="td_left">
                    <label for="board_pass">비밀번호</label>
                </td>
                <td class="td_right">
                    <input name="board_pass" type="password" id="board_pass"/>
                </td>
            </tr>
            <tr>
                <td class="td_left">
                    <label for="board_subject">제 목</label>
                </td>
                <td class="td_right">
                    <input name="board_subject" type="text" id="board_subject" value="<%=article.getBoard_subject()%>"/>
                </td>
            </tr>
            <tr>
                <td class="td_left">
                    <label for="board_content">내 용</label>
                </td>
                <td>
                    <textarea id="board_content" name="board_content" cols="40"
                              rows="15"><%=article.getBoard_content()%></textarea>
                </td>
            </tr>
        </table>
        <section id="commandCell">
            <a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
            <a href="javascript:history.go(-1)">[뒤로]</a>
        </section>
    </form>
</section>
</body>
</html>