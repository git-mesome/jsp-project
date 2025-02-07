<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MVC 게시판</title>
    <link href="board/css/qna_board_write.css" rel="stylesheet" type="text/css">
</head>
<body>
<section id="writeForm">
    <h2>게시판글등록</h2>
    <form action="boardWritePro.bo" method="post"
          enctype="multipart/form-data" name="boardform">
        <table>
            <tr>
                <td class="td_left"><label for="board_name">글쓴이</label></td>
                <td class="td_right"><input type="text" name="board_name"
                                            id="board_name" required="required"/></td>
            </tr>
            <tr>
                <td class="td_left"><label for="board_pass">비밀번호</label></td>
                <td class="td_right"><input name="board_pass" type="password"
                                            id="board_pass" required="required"/></td>
            </tr>
            <tr>
                <td class="td_left"><label for="board_subject">제 목</label></td>
                <td class="td_right"><input name="board_subject" type="text"
                                            id="board_subject" required="required"/></td>
            </tr>
            <tr>
                <td class="td_left"><label for="board_content">내 용</label></td>
                <td><textarea id="board_content" name="board_content"
                              cols="40" rows="15" required="required"></textarea></td>
            </tr>
            <tr>
                <td class="td_left"><label for="board_file"> 파일 첨부 </label></td>
                <td class="td_right"><input name="board_file" type="file"
                                            id="board_file" required="required"/></td>
            </tr>
        </table>
        <section id="commandCell">
            <input type="submit" value="등록">&nbsp;&nbsp; <input
                type="reset" value="다시쓰기"/>
        </section>
    </form>
</section>
</body>
</html>