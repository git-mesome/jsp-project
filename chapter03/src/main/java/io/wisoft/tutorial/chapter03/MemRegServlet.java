package io.wisoft.tutorial.chapter03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/memReg")
public class MemRegServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public MemRegServlet() {
    super();
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");

    PrintWriter out = response.getWriter();

    String name = request.getParameter("name");
    String addr = request.getParameter("addr");
    String tel = request.getParameter("tel");
    String hobby = request.getParameter("hobby");

    out.println("이름  = " + name + "<br>");
    out.println("주소  = " + addr + "<br>");
    out.println("전화번호  = " + tel + "<br>");
    out.println("취미 = " + hobby + "<br>");
  }

}