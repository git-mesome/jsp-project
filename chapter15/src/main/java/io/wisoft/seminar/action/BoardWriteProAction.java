package io.wisoft.seminar.action;

import io.wisoft.seminar.svc.BoardWriteProService;
import io.wisoft.seminar.vo.ActionForward;
import io.wisoft.seminar.vo.BoardBean;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class BoardWriteProAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward forward = null;
        BoardBean boardBean = null;

        Part filePart = request.getPart("board_file");
        String fileName = getSubmittedFileName(filePart);

        boardBean = new BoardBean();
        boardBean.setBoard_name(request.getParameter("board_name"));
        boardBean.setBoard_pass(request.getParameter("board_pass"));
        boardBean.setBoard_subject(request.getParameter("board_subject"));
        boardBean.setBoard_content(request.getParameter("board_content"));

        if (fileName != null && !fileName.isEmpty()) {
            String saveDirectory = "/boardUpload";
            ServletContext context = request.getServletContext();
            String realFolder = context.getRealPath(saveDirectory);
            String filePath = realFolder + File.separator + fileName;

            try (InputStream fileContent = filePart.getInputStream();
                 OutputStream outputStream = new FileOutputStream(filePath)) {
                int read;
                byte[] bytes = new byte[1024];
                while ((read = fileContent.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            } catch (IOException e) {
                e.printStackTrace();
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>");
                out.println("alert('파일 업로드 실패')");
                out.println("history.back();");
                out.println("</script>");
                return forward;
            }

            boardBean.setBoard_file(fileName);
        }

        BoardWriteProService boardWriteProService = new BoardWriteProService();
        boolean isWriteSuccess = boardWriteProService.registArticle(boardBean);

        if (!isWriteSuccess) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('등록실패')");
            out.println("history.back();");
            out.println("</script>");
        } else {
            forward = new ActionForward();
            forward.setRedirect(true);
            forward.setPath("boardList.bo");
        }

        return forward;
    }

    private String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName;
            }
        }

        return null;
    }
}

