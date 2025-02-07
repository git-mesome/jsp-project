package io.wisoft.seminar.svc;

import io.wisoft.seminar.dao.BoardDAO;
import io.wisoft.seminar.vo.BoardBean;

import java.sql.Connection;
import java.util.ArrayList;

import static io.wisoft.seminar.db.jdbcUtil.close;
import static io.wisoft.seminar.db.jdbcUtil.getConnection;

public class BoardListService {
  public int getListCount() throws Exception {
    int listCount = 0;
    Connection conn = getConnection();
    BoardDAO boardDAO = BoardDAO.getInstance();
    boardDAO.setConnection(conn);

    listCount = boardDAO.selectListCount();
    close(conn);
    return listCount;
  }

  public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception {
    ArrayList<BoardBean> arrayList = null;
    Connection conn = getConnection();
    BoardDAO boardDAO = BoardDAO.getInstance();
    boardDAO.setConnection(conn);
    arrayList = boardDAO.selectArticleList(page, limit);
    close(conn);

    return arrayList;
  }

}