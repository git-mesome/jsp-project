package io.wisoft.seminar.svc;

import io.wisoft.seminar.dao.BoardDAO;
import io.wisoft.seminar.vo.BoardBean;

import java.sql.Connection;

import static io.wisoft.seminar.db.jdbcUtil.close;
import static io.wisoft.seminar.db.jdbcUtil.commit;
import static io.wisoft.seminar.db.jdbcUtil.getConnection;
import static io.wisoft.seminar.db.jdbcUtil.rollback;

public class BoardDetailService {
    public BoardBean getArticle(int board_num) throws Exception {
        BoardBean article = null;
        Connection conn = getConnection();
        BoardDAO boardDAO = BoardDAO.getInstance();
        boardDAO.setConnection(conn);

        int updateCount = boardDAO.updateReadCount(board_num);

        if (updateCount > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }

        article = boardDAO.selectArticle(board_num);
        close(conn);

        return article;
    }

}