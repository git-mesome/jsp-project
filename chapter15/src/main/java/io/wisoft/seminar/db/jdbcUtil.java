package io.wisoft.seminar.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtil {

  public static Connection getConnection() {
    Connection conn = null;

    try {
      Context initCtx = new InitialContext();
      Context envCtx = (Context) initCtx.lookup("java:/comp/env");
      DataSource ds = (DataSource) envCtx.lookup("jdbc/postgres");
      conn = ds.getConnection();
      conn.setAutoCommit(false);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return conn;
  }

  public static void close(Connection conn) {
    try {
      conn.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void close(Statement stmt) {
    try {
      stmt.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void close(ResultSet rs) {
    try {
      rs.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void commit(Connection conn) {
    try {
      conn.commit();
      System.out.println("Commit successful");
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void rollback(Connection conn) {
    try {
      conn.rollback();
      System.out.println("Rollback successful");
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}