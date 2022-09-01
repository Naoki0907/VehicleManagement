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
import com.wfeel.entity.DecorateViotation;
import com.wfeel.idao.IDecorateUserDao;

public class ViotationPunishDao  {

	// 查询违章
	public List<DecorateViotation> getDecorateViotation(String car_no ) {
		List<DecorateViotation> datas = new ArrayList<>();
		ResultSet rs = null;
		Connection connection = null;
		connection = JdbcUtils_DBCP.getConnection();
		String sql = "SELECT * FROM viotation,punish  WHERE viotation.punish_id=punish.punish_id AND car_no=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, car_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DecorateViotation v = new DecorateViotation();
				v.setViotation_id(rs.getInt("viotation_id"));
				v.setViotation_detail(rs.getString("viotation_detail"));
				v.setFine(rs.getInt("fine"));
				v.setDeduct(rs.getInt("deduct"));
				v.setPunish_id(rs.getString("punish_id"));
				v.setViotation_date(rs.getString("viotation_date"));
				v.setCar_no(rs.getString("car_no"));
				v.setViotation_place(rs.getString("viotation_place"));
				v.setPunish_flag(rs.getString("punish_flag"));
				datas.add(v);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtils_DBCP.release(connection, pstmt, null);
		}
		return datas;
	}


	public boolean changeDecorateViotation(String punish_id) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "update punish set punish_flag = '已办理' where punish_id = ?";
		Connection connection = JdbcUtils_DBCP.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, punish_id);
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
