package com.wfeel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wfeel.butils.JdbcUtils_DBCP;
import com.wfeel.butils.MD5Util;
import com.wfeel.entity.DecorateUser;
import com.wfeel.idao.IDecorateUserDao;

public class DecorateUserDao implements IDecorateUserDao {

	// 查询是否有用户
	@Override
	public DecorateUser getUserByUserInfo(DecorateUser user) {
		ResultSet rs = null;
		Connection connection = null;
		connection = JdbcUtils_DBCP.getConnection();
		DecorateUser userRes = new DecorateUser();
		String sql = "select * from user where LoginName=? and LoginPwd=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getLoginName());
			pstmt.setString(2, MD5Util.string2MD5(user.getLoginPwd()));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userRes.setId(rs.getInt("Id"));
				userRes.setLoginName(rs.getString("LoginName"));
				userRes.setRole(rs.getString("Role"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtils_DBCP.release(connection, pstmt, null);
		}
		return userRes;
	}

	// 获得用户列表
	@Override
	public List<DecorateUser> getAllUsers() {
		List<DecorateUser> users = new ArrayList<DecorateUser>();
		ResultSet rs = null;
		Connection connection = null;
		connection = JdbcUtils_DBCP.getConnection();
		DecorateUser userRes = new DecorateUser();
		String sql = "select * from user";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				DecorateUser user = new DecorateUser();
				user.setLoginName(rs.getString("LoginName"));
				users.add(user);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtils_DBCP.release(connection, pstmt, null);
		}
		return users;
	}

	// 添加用户(注册)
	@Override
	public boolean addUser(DecorateUser user) {
		int result = 0;
		String sql = "insert into user(LoginName, LoginPwd, Role) values (?,?,?)";
		Connection connection = JdbcUtils_DBCP.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getLoginName());
			pstmt.setString(2, MD5Util.string2MD5(user.getLoginPwd()));
			pstmt.setString(3, String.valueOf(0));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(connection, pstmt, null);
		}
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getUserCount(Map queryParams) {
		int count = 0;
		String sql = "select count(*) from user" + " where 1 = 1";
		for (Object object : queryParams.keySet()) {
			String key = object.toString();
			String value = queryParams.get(key).toString();
			if (key.equals("Role"))
				if (value.equals("1"))
					sql += String.format(" and  %s ='%s' ", key, value);
				else
					sql += String.format(" and  %s <>1 ", key);
			else
				sql += String.format(" and  %s like '%%%s%%' ", key, value);
		}
		System.out.println(sql);
		Connection connection = JdbcUtils_DBCP.getConnection();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			pstmt = connection.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(connection, pstmt, resultSet);
		}
		return count;
	}

	@Override
	public List<DecorateUser> findForPage(int start, int end, String sort, String order, Map queryParams) {
		// TODO Auto-generated method stub
		String sql = " select tmp.* from ( "
				+ " select * from user where 1=1";
		for (Object object : queryParams.keySet()) {
			String key = object.toString();
			String value = queryParams.get(key).toString();
			if (key.equals("Role"))
				if (value.equals("1"))
					sql += String.format(" and  %s ='%s' ", key, value);
				else
					sql += String.format(" and  %s <>1 ", key);
			else
				sql += String.format(" and  %s like '%%%s%%' ", key, value);
		}
		sql += " order by " + sort + " " + order + " ) tmp limit " + start
				+ " ," + end;

		Connection connection = JdbcUtils_DBCP.getConnection();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		List<DecorateUser> resultList = new ArrayList<DecorateUser>();
		try {
			pstmt = connection.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String loginName = resultSet.getString("LoginName");
				String loginPwd = resultSet.getString("LoginPwd");
				String createTime= resultSet.getString("createTime");
				String role = resultSet.getString("Role");
				DecorateUser user = new DecorateUser(id, loginName, loginPwd ,createTime,role);
				resultList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(connection, pstmt, resultSet);
		}
		return resultList;
	}

	@Override
	public boolean changeUserRole(String id) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "update user set Role = 1 where id = ?";
		Connection connection = JdbcUtils_DBCP.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(connection, pstmt, null);
		}
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

}
