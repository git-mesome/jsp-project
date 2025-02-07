package io.wisoft.seminar.svc;

import io.wisoft.seminar.dao.BoardDAO;
import io.wisoft.seminar.vo.BoardBean;

import java.sql.Connection;

import static io.wisoft.seminar.db.jdbcUtil.close;
import static io.wisoft.seminar.db.jdbcUtil.commit;
import static io.wisoft.seminar.db.jdbcUtil.getConnection;
import static io.wisoft.seminar.db.jdbcUtil.rollback;

public class BoardWriteProService {
  public boolean registArticle(BoardBean boardBean) throws Exception {
    boolean isWriteSuccess = false;
    Connection conn = getConnection();
    BoardDAO boardDAO = BoardDAO.getInstance();
    boardDAO.setConnection(conn);

    int insertCount = boardDAO.insertArticle(boardBean);

    if (insertCount > 0) {
      commit(conn);
      isWriteSuccess = true;
    } else {
      rollback(conn);
    }

    close(conn);
    return isWriteSuccess;
  }
}
