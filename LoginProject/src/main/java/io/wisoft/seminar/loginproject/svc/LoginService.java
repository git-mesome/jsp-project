package io.wisoft.seminar.loginproject.svc;


import io.wisoft.seminar.loginproject.dao.LoginDAO;
import io.wisoft.seminar.loginproject.vo.Member;

import java.sql.Connection;

import static io.wisoft.seminar.loginproject.db.JdbcUtil.close;
import static io.wisoft.seminar.loginproject.db.JdbcUtil.getConnection;

public class LoginService {

	public Member getLoginMember(String id, String passwd) {
		// TODO Auto-generated method stub
		LoginDAO loginDAO = LoginDAO.getInstance();
		Connection con = getConnection();
		loginDAO.setConnection(con);
		Member loginMember = loginDAO.selectLoginMember(id, passwd);
		close(con);
		return loginMember;
	}
	
}








