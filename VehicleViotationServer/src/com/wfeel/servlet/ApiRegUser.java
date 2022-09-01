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
import com.wfeel.butils.NormalUtil;
import com.wfeel.constants.DecorateConstants;
import com.wfeel.entity.DecorateUser;
import com.wfeel.entity.User;
import com.wfeel.iservice.IDecorateUserService;
import com.wfeel.service.DecorateUserService;

/**
 * Servlet implementation class ApiRegUser
 */
@WebServlet("/api/regVeUser")
public class ApiRegUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiRegUser() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("/api/regVeUser");
		//封装值
		Map<String, String> map = new HashMap<>();
		
		String loginName = request.getParameter("loginName");  //注册时填的用户名
		String loginPwd = request.getParameter("loginPwd");  //注册时填的密码
		String loginPwdAgain = request.getParameter("loginPwdAgain");  
		if ("".equals(loginName) || "".equals(loginPwd) || "".equals(loginPwdAgain) || loginName==null || loginPwd==null || loginPwdAgain==null) {  
			response.sendRedirect("/DecorateServer/pages/register.jsp?flag=empty");  //用户输入有空的
			return;
		} else if (!loginPwd.equals(loginPwdAgain)) {
			response.sendRedirect("/DecorateServer/pages/register.jsp?flag=error");  //两次输入的密码不一致
			return;
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
	}

}
