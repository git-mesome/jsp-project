package io.wisoft.tutorial.chapter03;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sessionLogin")
public class SessionLoginServlet extends HttpServlet {

  public SessionLoginServlet() {
    super();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

    PrintWriter out = response.getWriter();

    String id = request.getParameter("id");
    String passwd = request.getParameter("passwd");

    if (id.equals("java") && passwd.equals("1111")) {
      HttpSession session = request.getSession();
      session.setAttribute("id", id);

      RequestDispatcher dispatcher =
          request.getRequestDispatcher("menu.jsp");

      dispatcher.forward(request, response);

    } else {
      out.println("<script>");
      out.println("alert('아이디나 비밀번호가 일치하지 않습니다.')");
      out.println("history.back()");
      out.println("</script>");
    }
  }
}
