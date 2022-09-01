package com.wfeel.service;

import java.util.List;
import java.util.Map;

import com.wfeel.dao.DecorateUserDao;
import com.wfeel.entity.DecorateUser;
import com.wfeel.idao.IDecorateUserDao;
import com.wfeel.iservice.IDecorateUserService;

public class DecorateUserService implements IDecorateUserService {

	private IDecorateUserDao userDAO = new DecorateUserDao();

	// 验证登录用户是否合法，合法返回用户信息
	@Override
	public DecorateUser checkUser(DecorateUser user) {
		return userDAO.getUserByUserInfo(user);
	}

	// 注册成功，添加用户
	@Override
	public boolean addUser(DecorateUser user) {
		return userDAO.addUser(user);
	}

	@Override
	public int getUserCount(Map queryParams) {
		return userDAO.getUserCount(queryParams);
	}

	@Override
	public List<DecorateUser> findForPage(int start, int end, String sort, String order, Map queryParams) {
		// TODO Auto-generated method stub
		return userDAO.findForPage(start, end, sort, order, queryParams);
	}

	@Override
	public boolean changeUserRole(String id) {
		// TODO Auto-generated method stub
		return userDAO.changeUserRole(id);
	}

	
}
