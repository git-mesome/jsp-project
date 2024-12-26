package io.wisoft.tutorial.chapter03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public BoardListServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String page = request.getParameter("page");
    response.setContentType("text/html; charset=UTF-8");

    PrintWriter out = response.getWriter();
    out.println(page + " 페이지 게시판 목록 출력");
  }
}
