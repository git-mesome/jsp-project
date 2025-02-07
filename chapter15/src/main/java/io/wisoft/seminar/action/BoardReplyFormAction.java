package io.wisoft.seminar.action;

import io.wisoft.seminar.svc.BoardDetailService;
import io.wisoft.seminar.vo.ActionForward;
import io.wisoft.seminar.vo.BoardBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardReplyFormAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionForward forward = new ActionForward();
        String nowPage = request.getParameter("page");
        int board_num = Integer.parseInt(request.getParameter("board_num"));
        BoardDetailService boardDetailService = new BoardDetailService();
        BoardBean article = boardDetailService.getArticle(board_num);
        request.setAttribute("article", article);
        request.setAttribute("page", nowPage);
        forward.setPath("/board/qna_board_reply.jsp");
        return forward;

    }

}