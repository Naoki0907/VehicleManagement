package com.example.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreference {
	private SharedPreferences sp;
	private SharedPreferences.Editor editor;
	public static final String USER_SHAREPREFERENCE = "userSharePreference";// 用户SharePreference
	private Context context;

	public UserPreference(Context context) {
		this.context = context;
		sp = context.getSharedPreferences(USER_SHAREPREFERENCE, Context.MODE_PRIVATE);
		editor = sp.edit();
	}

	// 打印用户信息
	public void printUserInfo() {
		// LogTool.i("是否登录: " + getUserLogin());
		// LogTool.i("手机验证�? " + getU_VERIFY_CODE());
		// LogTool.i("登录手机�? " + getU_tel());
		// LogTool.i("创建时间: " + DateTimeTools.DateToString(getU_CreatTime()));
		// LogTool.i("access_token: " + getAccess_token());
	}

	/**
	 * 清空数据
	 * 
	 * @Title: clearAll
	 * @Description: TODO
	 * @return: void
	 */
	public void clearAll() {
		editor.clear();
		editor.commit();
	}

	/**
	 * 不保存电话号�?
	 */
	public void clearthird() {
		editor.clear();
		editor.commit();
	}

	// 记录用户是否登录
	public boolean getUserLogin() {
		return sp.getBoolean("login", false);
	}

	public void setUserLogin(boolean login) {
		editor.putBoolean("login", login);
		editor.commit();
	}

	// 记录登录的用户名
	public String getUserLoginName() {
		return sp.getString("loginName","");
	}

	public void setUserLoginName(String loginName) {
		editor.putString("loginName", loginName);
		editor.commit();
	}

}
