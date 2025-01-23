package io.wisoft.tutorial.chapter11;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@WebServlet(name = "ThumbnailServlet", value = "/ThumbnailServlet")
@MultipartConfig(location = "/Users/minseo/workspace/wisoft/class/mvc/jsp-project/chapter11/src/main/webapp/image",
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 100,
    maxRequestSize = 1024 * 1024 * 100 * 5)
public class ThumbnailServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    String imagePath = request.getServletContext().getRealPath("/image");

    Part part = request.getPart("filename");
    String fileName = getFileName(part);

    String filePath = imagePath + File.separator + fileName;


    try (InputStream input = part.getInputStream();
         OutputStream output = new FileOutputStream(filePath)) {
      byte[] buffer = new byte[1024];
      int bytesRead;

      while ((bytesRead = input.read(buffer)) != -1) {
        output.write(buffer, 0, bytesRead);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    craeteThumbnail(imagePath, fileName);


    response.setContentType("text/html; charset=UTF-8");
    response.getWriter().println("<html>");
    response.getWriter().println("<head><title>이미지 썸네일 예제</title></head>");
    response.getWriter().println("<body>");
    response.getWriter().println("- 원본 이미지 -<br>");
    response.getWriter().println("<img src=\" image/ " + fileName + " \"><p>");
    response.getWriter().println("-썸네일 이미지 -<br>");
    response.getWriter().println("<img src=\" image/sm_ " + fileName + " \"><p>");
    response.getWriter().println("</body></html>");
  }

  private void craeteThumbnail(final String uploadDirectory, final String uploadFileName) {
    try {
      String imagePath = uploadDirectory + File.separator + uploadFileName;

      // 원본 이미지 ImageIO로 읽기
      BufferedImage originalImage = ImageIO.read(new File(imagePath));

      //썸네일 생성 (100x100 크기 BufferedImage 객체 생성)
      BufferedImage thumbnail = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
      Graphics2D graphics = thumbnail.createGraphics();

      // 원본 이미지 썸네일 크기로 변경
      graphics.drawImage(originalImage, 0, 0, 100, 100, null);
      graphics.dispose(); // 그래픽 리소스 해제

      // 썸네일 파일 저장 경로
      File thumbnailFile = new File(uploadDirectory + File.separator + "sm" + uploadFileName);


      // 썸네일 JPG 저장
      ImageIO.write(thumbnail, "jpg", thumbnailFile);


    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private String getFileName(final Part part) {
    for (String content : part.getHeader("content-disposition").split(";")) {
      if (content.trim().startsWith("filename")) {
        String filename = content.substring(content.indexOf("=") + 1)
            .trim()
            .replace("\"", "");
        return filename.substring(filename.lastIndexOf(File.separator) + 1);
      }
    }
    return null;
  }
}