package io.wisoft.seminar.action;

import io.wisoft.seminar.svc.BoardDeleteProService;
import io.wisoft.seminar.vo.ActionForward;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class BoardDeleteProAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionForward forward = null;
        int board_num = Integer.parseInt(request.getParameter("board_num"));
        String nowPage = request.getParameter("page");
        BoardDeleteProService boardDeleteProService = new BoardDeleteProService();
        boolean isArticleWriter = boardDeleteProService.isArticleWriter(board_num, request.getParameter("board_pass"));

        if (!isArticleWriter) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('삭제할 권한이 없습니다');");
            out.println("history.back()");
            out.println("</script>");
            out.close();
        } else {
            boolean isDeleteSuccess = boardDeleteProService.removeArticle(board_num);

            if (!isDeleteSuccess) {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>");
                out.println("alert('삭제실패');");
                out.println("history.back();");
                out.println("</script>");
                out.close();
            } else {
                forward = new ActionForward();
                forward.setRedirect(true);
                forward.setPath("boardList.bo?page=" + nowPage);
            }

        }
        return forward;
    }

}

