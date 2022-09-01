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
import javax.servlet.http.HttpSession;

import com.wfeel.entity.DecorateUser;
import com.wfeel.iservice.IDecorateUserService;
import com.wfeel.service.DecorateUserService;

/**
 * Servlet implementation class DecorateUser
 */
@WebServlet("/DecorateUserServer")
public class DecorateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DecorateUserServlet() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset=UTF-8");
		HttpSession session = request.getSession();  //获取session，session域保存已登录用户信息
		PrintWriter out = response.getWriter();
		Map<String, Object> map = new HashMap<>();
		String res = "";
		String loginName = request.getParameter("loginName");  //获取登录名
		String loginPwd = request.getParameter("loginPwd");  //获取登陆密码

		IDecorateUserService userService = new DecorateUserService();  //创建用户业务层类
		DecorateUser user = userService.checkUser(new DecorateUser(loginName,loginPwd));  //检查用户是否合法
		if (user!=null) {
			//如果用户合法，将用户信息保存到session域
			session.setAttribute("isLogin", "true"); 
			session.setAttribute("user", user); 
			if ("1".equals(user.getRole())) {
				response.sendRedirect("/DecorateServer/pages/admin/");
				return;
			} else {
				response.sendRedirect("/DecorateServer/index.jsp");
				return;
			}
		} else {
			response.sendRedirect("/DecorateServer/pages/not_find.jsp");
		}
		
		System.out.println(res);
		out.close();
	}

}
