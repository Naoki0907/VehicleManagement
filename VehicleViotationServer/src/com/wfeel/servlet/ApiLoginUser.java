package com.wfeel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wfeel.butils.FastJsonTool;
import com.wfeel.constants.DecorateConstants;
import com.wfeel.entity.DecorateUser;
import com.wfeel.iservice.IDecorateUserService;
import com.wfeel.service.DecorateUserService;

/**
 * Servlet implementation class ApiLoginUser
 */
@WebServlet("/api/loginUser")
public class ApiLoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApiLoginUser() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("/api/loginUser");

		Map<String, String> map = new HashMap<>();

		String flag = request.getParameter("flag"); // 注册、登录

		if ("reg".equals(flag)) {
			String loginName = request.getParameter("loginName");  //注册时填的用户名
			String loginPwd = request.getParameter("loginPwd");  //注册时填的密码
			String loginPwdAgain = request.getParameter("loginPwdAgain");  
			if ("".equals(loginName) || "".equals(loginPwd) || "".equals(loginPwdAgain) || loginName==null || loginPwd==null || loginPwdAgain==null) {  
				map.put(DecorateConstants.MESSAGE, "输入信息为空！"); //用户名已存在
			} else if (!loginPwd.equals(loginPwdAgain)) {
				map.put(DecorateConstants.MESSAGE, "两次输入的密码不一致！");  //两次输入的密码不一致
			}
			IDecorateUserService userService = new DecorateUserService();
			DecorateUser user = new DecorateUser();
			user.setLoginName(loginName);
			user.setLoginPwd(loginPwd);
			DecorateUser userRes = userService.checkUser(user);
			if (userRes != null) {
				map.put(DecorateConstants.STATUS, DecorateConstants.FAIL);
				map.put(DecorateConstants.MESSAGE, "用户名已存在！"); //用户名已存在
				return;
			}
			boolean result = userService.addUser(user);
			if (result == true) {
				map.put(DecorateConstants.STATUS, DecorateConstants.SUCCESS);
				map.put(DecorateConstants.MESSAGE, "注册成功！"); //注册成功
			} else {
				map.put(DecorateConstants.STATUS, DecorateConstants.FAIL);
				map.put(DecorateConstants.MESSAGE, "用户名已存在！"); //用户名已存在
			}
			
			System.out.println(FastJsonTool.createJsonString(map));
			out.print(FastJsonTool.createJsonString(map));
			out.close();
		}else{
			String loginName = request.getParameter("loginName"); // 获取登录名
			String loginPwd = request.getParameter("loginPwd"); // 获取登陆密码

			IDecorateUserService userService = new DecorateUserService(); // 创建用户业务层类
			DecorateUser user = userService.checkUser(new DecorateUser(loginName, loginPwd)); // 检查用户是否合法
			if (user != null) {
				map.put(DecorateConstants.STATUS, DecorateConstants.SUCCESS);
				map.put("loginName", loginName);
				map.put(DecorateConstants.MESSAGE, "登录成功！");
			} else {
				map.put(DecorateConstants.STATUS, DecorateConstants.FAIL);
				map.put(DecorateConstants.MESSAGE, "登录失败！");
			}

			System.out.println(FastJsonTool.createJsonString(map));
			out.print(FastJsonTool.createJsonString(map));
			out.close();
		}
	}
}
