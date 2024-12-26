package io.wisoft.tutorial.chapter03;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {

  public DispatcherServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 객체에 데이터 저장
    request.setAttribute("request", "requestValue");
    // forward로 JSP에 요청 전달
    RequestDispatcher dispatcher = request.getRequestDispatcher("dispatcher.jsp");
    dispatcher.forward(request, response);
  }

}
