package io.wisoft.seminar.action;

import io.wisoft.seminar.svc.BoardReplyProService;
import io.wisoft.seminar.vo.ActionForward;
import io.wisoft.seminar.vo.BoardBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class BoardReplyProAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionForward forward = null;
        String nowPage = request.getParameter("page");
        BoardBean article = new BoardBean();
        article.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
        article.setBoard_name(request.getParameter("board_name"));
        article.setBoard_pass(request.getParameter("board_pass"));
        article.setBoard_subject(request.getParameter("board_subject"));
        article.setBoard_content(request.getParameter("board_content"));
        article.setBoard_re_ref(Integer.parseInt(request.getParameter("board_re_ref")));
        article.setBoard_re_lev(Integer.parseInt(request.getParameter("board_re_lev")));
        article.setBoard_re_seq(Integer.parseInt(request.getParameter("board_re_seq")));
        BoardReplyProService boardReplyProService = new BoardReplyProService();
        boolean isReplySuccess = boardReplyProService.replyArticle(article);

        if (isReplySuccess) {
            forward = new ActionForward();
            forward.setRedirect(true);
            forward.setPath("boardList.bo?page=" + nowPage);
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('답장실패')");
            out.println("history.back()");
            out.println("</script>");
        }

        return forward;

    }

}