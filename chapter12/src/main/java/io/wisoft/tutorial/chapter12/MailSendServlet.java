package io.wisoft.tutorial.chapter12;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "mailSend", value = "/mailSend")
public class MailSendServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    String sender = request.getParameter("sender");
    String receiver = request.getParameter("receiver");
    String subject = request.getParameter("subject");
    String content = request.getParameter("content");

    response.setContentType("text/html;charset=utf-8");

    PrintWriter out = response.getWriter();
    try {
      final Properties properties = System.getProperties();

      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.port", "587"); //gmail 포트
      properties.put("mail.smtp.auth", "true");

      // TLS 오류 해결 위한 코드
      properties.put("mail.ssl.protocols", "TLSv1.2");

      Authenticator auth = new GoogleAuthentication();
      Session session = Session.getDefaultInstance(properties, auth);

      final MimeMessage message = new MimeMessage(session);
      final Address senderAddress = new InternetAddress(sender);
      final Address receiverAddress = new InternetAddress(receiver);

      message.setHeader("content-type", "text/html;charset=utf-8");
      message.setFrom(senderAddress);
      message.addRecipient(Message.RecipientType.TO, receiverAddress);
      message.setSubject(subject);
      message.setContent(content, "text/html;charset=utf-8");
      message.setSentDate(new java.util.Date());
      Transport.send(message);

      out.println("<h3>메일이 정상적으로 전송되었습니다.</h3>");

    } catch (Exception e) {
      out.println("SMTP 서버가 잘못 설정되었거나, 서비스에 문제가 있습니다.");
      e.printStackTrace();
    }
  }
}