package io.wisoft.seminar.action;

import io.wisoft.seminar.svc.BoardModifyProService;
import io.wisoft.seminar.vo.ActionForward;
import io.wisoft.seminar.vo.BoardBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class BoardModifyProAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionForward forward = null;
        boolean isModifySuccess = false;
        int board_num = Integer.parseInt(request.getParameter("board_num"));
        BoardBean article = new BoardBean();
        BoardModifyProService boardModifyProService = new BoardModifyProService();
        boolean isRightUser = boardModifyProService.isArticleWriter(board_num, request.getParameter("board_pass"));

        if (!isRightUser) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('수정할 권한이 없습니다.');");
            out.println("history.back();");
            out.println("</script>");
        } else {
            article.setBoard_num(board_num);
            article.setBoard_subject(request.getParameter("board_subject"));
            article.setBoard_content(request.getParameter("board_content"));
            isModifySuccess = boardModifyProService.modifyArticle(article);

            if (!isModifySuccess) {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>");
                out.println("alert('수정실패');");
                out.println("history.back()");
                out.println("</script>");
            } else {
                forward = new ActionForward();
                forward.setRedirect(true);
                forward.setPath("boardDetail.bo?board_num=" + article.getBoard_num());
            }

        }

        return forward;
    }
}

