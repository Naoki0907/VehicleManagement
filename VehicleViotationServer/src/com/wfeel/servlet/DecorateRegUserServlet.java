package com.wfeel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wfeel.entity.DecorateUser;
import com.wfeel.iservice.IDecorateUserService;
import com.wfeel.service.DecorateUserService;

/**
 * Servlet implementation class DecorateUser
 */
@WebServlet("/regDecorateUser")
public class DecorateRegUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DecorateRegUserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String loginName = request.getParameter("loginName");  //注册时填的用户名
		String loginPwd = request.getParameter("loginPwd");  //注册时填的密码
		String loginPwdAgain = request.getParameter("loginPwdAgain");  
		System.out.println("第一次："+loginPwd+"--->第二次："+loginPwdAgain+"--->是否相等"+loginPwd.equals(loginPwdAgain));
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
			response.sendRedirect("/DecorateServer/pages/register.jsp?flag=hasUser");  //用户名已存在
			return;
		}
		boolean result = userService.addUser(user);
		if (result == true) {
			response.sendRedirect("/DecorateServer/pages/login.jsp?flag=success");  //注册成功
		} else {
			response.sendRedirect("/DecorateServer/pages/register.jsp");  //用户名已存在
		}
		out.flush();
		out.close();
	}

}
