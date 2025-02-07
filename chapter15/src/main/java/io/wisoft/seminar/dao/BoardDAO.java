package io.wisoft.seminar.dao;

import io.wisoft.seminar.vo.BoardBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static io.wisoft.seminar.db.jdbcUtil.close;
import static io.wisoft.seminar.db.jdbcUtil.commit;

public class BoardDAO {
  DataSource ds;
  Connection conn;

  private static BoardDAO boardDAO;

  private BoardDAO() {
  }

  public static BoardDAO getInstance() {
    if (boardDAO == null) {
      boardDAO = new BoardDAO();
    }
    return boardDAO;
  }

  public void setConnection(Connection conn) {
    this.conn = conn;
  }

  public int selectListCount() {
    int listCount = 0;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      pstmt = conn.prepareStatement("select count(*) from board");
      rs = pstmt.executeQuery();

      if (rs.next()) {
        listCount = rs.getInt(1);
      }
    }
    catch (Exception e) {
      System.out.println("getListCount 에러 : " + e);
    }
    finally {
      close(rs);
      close(pstmt);
    }

    return listCount;
  }

  // 글 목록 보기
  // TODO offset check
  public ArrayList<BoardBean> selectArticleList(int page, int limit) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String board_list_sql = "select * from board order by board_re_ref desc, board_re_seq asc offset ? limit 10";
    ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
    BoardBean boardBean = null;
    int startRow = (page - 1) * 10; // 읽기 시작할 row 번호

    try {
      pstmt = conn.prepareStatement(board_list_sql);
      pstmt.setInt(1, startRow);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        boardBean = new BoardBean();
        boardBean.setBoard_num(rs.getInt("board_num"));
        boardBean.setBoard_subject(rs.getString("board_name"));
        boardBean.setBoard_content(rs.getString("board_content"));
        boardBean.setBoard_file(rs.getString("board_file"));
        boardBean.setBoard_re_ref(rs.getInt("board_re_ref"));
        boardBean.setBoard_re_lev(rs.getInt("board_re_lev"));
        boardBean.setBoard_re_seq(rs.getInt("board_re_seq"));
        boardBean.setBoard_readcount(rs.getInt("board_readcount"));
        boardBean.setBoard_date(rs.getDate("board_date"));
        articleList.add(boardBean);
      }
    }
    catch (Exception e) {
      System.out.println("getBoardList 에러 : " + e);
    }
    finally {
      close(rs);
      close(pstmt);
    }

    return articleList;
  }

  // 글 내용 보기
  public BoardBean selectArticle(int board_num) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    BoardBean boardBean = null;

    try {
      pstmt = conn.prepareStatement(
          "select * from board where board_num = ?"
      );
      pstmt.setInt(1, board_num);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        boardBean = new BoardBean();
        boardBean.setBoard_num(rs.getInt("board_num"));
        boardBean.setBoard_subject(rs.getString("board_name"));
        boardBean.setBoard_content(rs.getString("board_content"));
        boardBean.setBoard_file(rs.getString("board_file"));
        boardBean.setBoard_re_ref(rs.getInt("board_re_ref"));
        boardBean.setBoard_re_lev(rs.getInt("board_re_lev"));
        boardBean.setBoard_re_seq(rs.getInt("board_re_seq"));
        boardBean.setBoard_readcount(rs.getInt("board_readcount"));
        boardBean.setBoard_date(rs.getDate("board_date"));
      }

    }
    catch (Exception e) {
      System.out.println("selectArticle 에러 : " + e);
    }
    finally {
      close(rs);
      close(pstmt);
    }

    return boardBean;
  }

  // 글 등록
  public int insertArticle(BoardBean article) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    int num = 0;
    String sql = "";
    int insertCount = 0;

    try {
      pstmt = conn.prepareStatement("select max(board_num) from board");
      rs = pstmt.executeQuery();

      if (rs.next()) {
        num = rs.getInt(1) + 1;
      } else {
        num = 1;
      }

      sql = "insert into board (board_num, board_name, board_pass, board_subject, board_content, " +
          "board_file, board_re_ref, board_re_lev, board_re_seq, board_readcount, board_date)" +
          "values (?,?,?,?,?,?,?,?,?,?,now())";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, num);
      pstmt.setString(2, article.getBoard_name());
      pstmt.setString(3, article.getBoard_pass());
      pstmt.setString(4, article.getBoard_subject());
      pstmt.setString(5, article.getBoard_content());
      pstmt.setString(6, article.getBoard_file());
      pstmt.setInt(7, num);
      pstmt.setInt(8, 0);
      pstmt.setInt(9, 0);
      pstmt.setInt(10, 0);

      insertCount = pstmt.executeUpdate();
    }
    catch (Exception e) {
      System.out.println("boardInsert 에러 : " + e);
    }
    finally {
      close(rs);
      close(pstmt);
    }

    return insertCount;
  }

  // 글 답변
  public int insertReplayArticle(BoardBean article) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String board_max_sql = "select max(board_num) from board";
    String sql = "";
    int num = 0;
    int insertCount = 0;
    int re_ref = article.getBoard_re_ref();
    int re_lev = article.getBoard_re_lev();
    int re_seq = article.getBoard_re_seq();

    try {
      pstmt = conn.prepareStatement(board_max_sql);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        num = rs.getInt(1) + 1;
      } else {
        num = 1;
      }

      sql = "update board set board_re_seq = board_re_seq + 1 where board_re_ref = ? and board_re_seq > ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, re_ref);
      pstmt.setInt(2, re_seq);
      int updateCount = pstmt.executeUpdate();

      if (updateCount > 0) {
        commit(conn);
      }

      re_seq = re_seq + 1;
      re_lev = re_lev + 1;

      sql = "insert into board (board_num, board_name, board_pass, board_subject, board_content, " +
          "board_file, board_re_ref, board_re_lev, board_re_seq, board_readcount, board_date)" +
          "values (?,?,?,?,?,?,?,?,?,?,now())";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, num);
      pstmt.setString(2, article.getBoard_name());
      pstmt.setString(3, article.getBoard_pass());
      pstmt.setString(4, article.getBoard_subject());
      pstmt.setString(5, article.getBoard_content());
      pstmt.setString(6, ""); // 답장에는 파일을 업로드 하지 X
      pstmt.setInt(7, re_ref);
      pstmt.setInt(8, re_lev);
      pstmt.setInt(9, re_seq);
      pstmt.setInt(10, 0);
      insertCount = pstmt.executeUpdate();

    }
    catch (SQLException e) {
      System.out.println("boardReply 에러 : " + e);
    }
    finally {
      close(rs);
      close(pstmt);
    }

    return insertCount;
  }

  // 글 수정
  public int updateArticle(BoardBean article) {
    int updateCount = 0;
    PreparedStatement pstmt = null;
    String sql = "update board set board_subject = ?, board_content = ? where board_num = ?";

    try {

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, article.getBoard_subject());
      pstmt.setString(2, article.getBoard_content());
      pstmt.setInt(3, article.getBoard_num());
      updateCount = pstmt.executeUpdate();
    }
    catch (Exception e) {
      System.out.println("boardModify Error : " + e);
    }
    finally {
      close(pstmt);
    }

    return updateCount;
  }

  // 글 삭제
  public int deleteArticle(int board_num) {
    PreparedStatement pstmt = null;
    String board_delete_sql = "delete from board where board_num = ?";
    int deleteCount = 0;

    try {
      pstmt = conn.prepareStatement(board_delete_sql);
      pstmt.setInt(1, board_num);
      deleteCount = pstmt.executeUpdate();
    }
    catch (Exception e) {
      System.out.println("boardDelete 에러 : " + e);
    }
    finally {
      close(pstmt);
    }

    return deleteCount;
  }

  // 조회수 업데이트
  public int updateReadCount(int board_num) {
    PreparedStatement pstmt = null;
    int updateCount = 0;
    String sql = "update board set board_readcount = board_readcount + 1 where board_num = " + board_num;

    try {
      pstmt = conn.prepareStatement(sql);
      updateCount = pstmt.executeUpdate();
    }
    catch (SQLException e) {
      System.out.println("setReadCountUpdate 에러 : " + e);
    }
    finally {
      close(pstmt);
    }

    return updateCount;
  }

  // 글쓴이인지 확인
  public boolean isArticleBoardWriter(int board_num, String pass) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String board_sql = "select * from board where board_num = ?";
    boolean isWriter = false;

    try {
      pstmt = conn.prepareStatement(board_sql);
      pstmt.setInt(1, board_num);
      rs = pstmt.executeQuery();
      rs.next();

      if (pass.equals(rs.getString("board_pass"))) {
        isWriter = true;
      }
    }
    catch (SQLException e) {
      System.out.println("isArticleBoardWriter 에러 : " + e);
    }
    finally {
      close(pstmt);
    }

    return isWriter;
  }


}
