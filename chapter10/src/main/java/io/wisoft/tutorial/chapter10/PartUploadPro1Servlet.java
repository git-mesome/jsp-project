package io.wisoft.tutorial.chapter10;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/partUploadPro1")
@MultipartConfig(fileSizeThreshold = 0, location = "/Users/minseo/workspace/wisoft/class/mvc/jsp-project/chapter10/file")
public class PartUploadPro1Servlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public PartUploadPro1Servlet() {
    super();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    String writer = request.getParameter("writer");
    Part part = request.getPart("partFile1");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    String contentDisposition = part.getHeader("content-disposition");
    String uploadFileName = getUploadFileName(contentDisposition);

    part.write(uploadFileName);
    out.println("작성자 " + writer + "님이 " + uploadFileName + " 파일을 업로드 하였다.");
  }

  private String getUploadFileName(final String contentDisposition) {
    String uploadFileName = null;
    String[] contentSplitStr = contentDisposition.split(";");
    int firstQutosIndex = contentSplitStr[2].indexOf("\"");
    int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
    System.out.println(firstQutosIndex);
    System.out.println(lastQutosIndex);

    uploadFileName = contentSplitStr[2].substring(firstQutosIndex + 1, lastQutosIndex);
    return uploadFileName;
  }
}
