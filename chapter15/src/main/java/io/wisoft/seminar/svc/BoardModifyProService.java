package io.wisoft.seminar.svc;

import io.wisoft.seminar.dao.BoardDAO;
import io.wisoft.seminar.vo.BoardBean;

import java.sql.Connection;

import static io.wisoft.seminar.db.jdbcUtil.close;
import static io.wisoft.seminar.db.jdbcUtil.commit;
import static io.wisoft.seminar.db.jdbcUtil.getConnection;
import static io.wisoft.seminar.db.jdbcUtil.rollback;

public class BoardModifyProService {
    public boolean isArticleWriter(int board_num, String pass) throws Exception {
        boolean isArticleWriter = false;
        Connection conn = getConnection();
        BoardDAO boardDAO = BoardDAO.getInstance();
        boardDAO.setConnection(conn);
        isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass);
        close(conn);
        return isArticleWriter;
    }

    public boolean modifyArticle(BoardBean article) throws Exception {
        boolean isModifySuccess = false;
        Connection conn = getConnection();
        BoardDAO boardDAO = BoardDAO.getInstance();
        boardDAO.setConnection(conn);
        int updateCount = boardDAO.updateArticle(article);

        if (updateCount > 0) {
            commit(conn);
            isModifySuccess = true;
        } else {
            rollback(conn);
        }

        close(conn);
        return isModifySuccess;
    }
}