package io.wisoft.tutorial.chapter03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirectServlet")
public class RedirectServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public RedirectServlet() {
    super();
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("request", "requestValue");
    response.sendRedirect("redirect.jsp");
  }
}
