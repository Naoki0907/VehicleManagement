package com.wfeel.idao;

import java.util.List;
import java.util.Map;

import com.wfeel.entity.DecorateUser;
import com.wfeel.entity.User;

public interface IDecorateUserDao {

	public DecorateUser getUserByUserInfo(DecorateUser user);

	public List<DecorateUser> getAllUsers();

	public boolean addUser(DecorateUser user);

	// 获取条数
	public int getUserCount(Map queryParams);
	
	public boolean changeUserRole(String id);

	// 获取列表
	public List<DecorateUser> findForPage(int start, int end, String sort, String order, Map queryParams);
}
