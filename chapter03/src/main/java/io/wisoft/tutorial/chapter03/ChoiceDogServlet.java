package io.wisoft.tutorial.chapter03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/choiceDog")
public class ChoiceDogServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ChoiceDogServlet() {
    super();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");

    PrintWriter out = response.getWriter();
    String[] dog = request.getParameterValues("dog");

    out.println("<html>");
    out.println("<head>");
    out.println("</head>");
    out.println("<body bgcolor='black'>");
    out.println("<table align='center' bgcolor='yellow'>");
    out.println("<tr>");

    for (int i = 0; i < dog.length; i++) {
      out.println("<td>");
      out.println("<img src='" + dog[i] + "'/>");
      out.println("</td>");
    }

    out.println("</tr>");
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
  }

}
