package io.wisoft.seminar.controller;

import io.wisoft.seminar.action.*;
import io.wisoft.seminar.vo.ActionForward;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("*.bo")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024)
public class BoardFrontController extends jakarta.servlet.http.HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String RequestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = RequestURI.substring(contextPath.length());
        ActionForward forward = null;
        Action action = null;

        if (command.equals("/boardWriteForm.bo")) {
            forward = new ActionForward();
            forward.setPath("/board/qna_board_write.jsp");
        } else if (command.equals("/boardWritePro.bo")) {
            action = new BoardWriteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command.equals("/boardList.bo")) {
            action = new BoardListAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command.equals("/boardDetail.bo")) {
            action = new BoardDetailAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command.equals("/boardReplyForm.bo")) {
            action = new BoardReplyFormAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command.equals("/boardReplyPro.bo")) {
            action = new BoardReplyProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command.equals("/boardModifyForm.bo")) {
            action = new BoardModifyFormAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command.equals("/boardModifyPro.bo")) {
            action = new BoardModifyProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command.equals("/boardDeleteForm.bo")) {
            String nowPage = request.getParameter("page");
            request.setAttribute("page", nowPage);
            int board_num = Integer.parseInt(request.getParameter("board_num"));
            request.setAttribute("board_num", board_num);
            forward = new ActionForward();
            forward.setPath("/board/qna_board_delete.jsp");
        } else if (command.equals("/boardDeletePro.bo")) {
            action = new BoardDeleteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (forward != null) {

            if (forward.isRedirect()) {
                response.sendRedirect(forward.getPath());
            } else {
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(forward.getPath());
                dispatcher.forward(request, response);
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

}