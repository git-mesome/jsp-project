package io.wisoft.tutorial.chapter03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/directURL")
public class DirectURLServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public DirectURLServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String age = request.getParameter("age");

    response.setContentType("text/html; charset=UTF-8");

    PrintWriter out = response.getWriter();
    out.println("이름: " + name + "<br>");
    out.println("나이: " + age + "<br>");

  }
}
