package io.wisoft.seminar.svc;

import io.wisoft.seminar.dao.BoardDAO;
import io.wisoft.seminar.vo.BoardBean;

import java.sql.Connection;

import static io.wisoft.seminar.db.jdbcUtil.close;
import static io.wisoft.seminar.db.jdbcUtil.commit;
import static io.wisoft.seminar.db.jdbcUtil.getConnection;
import static io.wisoft.seminar.db.jdbcUtil.rollback;

public class BoardReplyProService {
    public boolean replyArticle(BoardBean article) throws Exception {
        boolean isReplySuccess = false;
        int insertCount = 0;
        Connection conn = getConnection();
        BoardDAO boardDAO = BoardDAO.getInstance();
        boardDAO.setConnection(conn);
        insertCount = boardDAO.insertReplayArticle(article);

        if (insertCount > 0) {
            commit(conn);
            isReplySuccess = true;
        } else {
            rollback(conn);
        }

        close(conn);
        return isReplySuccess;
    }
}