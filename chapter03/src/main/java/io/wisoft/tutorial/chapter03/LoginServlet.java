package io.wisoft.tutorial.chapter03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public LoginServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 요청 id, passwd 파라미터값
    String id = request.getParameter("id");
    String passwd = request.getParameter("passwd");

    // 응답 타입
    response.setContentType("text/html;charset=utf-8");

    // 출력 스트림
    PrintWriter out = response.getWriter();
    out.println("아이디="+id + "<br>");
    out.println("비밀번호="+passwd + "<br>");
  }
}
