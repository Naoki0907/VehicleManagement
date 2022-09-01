package com.wfeel.iservice;

import java.util.List;
import java.util.Map;

import com.wfeel.entity.DecorateUser;
import com.wfeel.entity.User;

public interface IDecorateUserService {

	// 用户登录
	public DecorateUser checkUser(DecorateUser user);

	// 注册成功，添加用户
	public boolean addUser(DecorateUser user);

	public int getUserCount(Map queryParams);
	
	//通过id修改该用户的角色
	public boolean changeUserRole(String id);
	
	public List<DecorateUser> findForPage(int start, int end, String sort,String order, Map queryParams);

}
