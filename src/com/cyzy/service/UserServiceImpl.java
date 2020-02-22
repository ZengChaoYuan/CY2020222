package com.cyzy.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.cyzy.bean.User;
import com.cyzy.dao.UserDao;
import com.cyzy.util.DBUtil;
import com.cyzy.util.DaoFactory;






public class UserServiceImpl implements UserService {

	//登录
	@Override
	public User login(String userName, String password) {
		UserDao userDao=(UserDao)DaoFactory.getDaoImpl(UserDao.class.getName());
		return userDao.login(userName, password);
	}
	
	@Override
	public int loginUser(User user) {
		UserDao userdao=(UserDao)DaoFactory.getDaoImpl(UserDao.class.getName());
		Connection conn=DBUtil.getConnection();
		userdao.loginUser(user);
		try {
			conn.setAutoCommit(true);//先把自动提交设置成false
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.closeConn(conn, null, null);
		}
	 return 0;
	}

	@Override
	public List<User> queryUsers(User user) {
		
		return null;
	}

	@Override
	public int addUser(User user) {
		
		return 0;
	}

	@Override
	public int deleteUser(int userId) {
		
		return 0;
	}

	@Override
	public User getUserById(int userId) {
		
		return null;
	}

	@Override
	public int updateUser(User user) {
		
		return 0;
	}

	

}
