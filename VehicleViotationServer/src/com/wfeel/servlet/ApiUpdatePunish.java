package com.wfeel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wfeel.butils.FastJsonTool;
import com.wfeel.constants.DecorateConstants;
import com.wfeel.dao.ViotationPunishDao;
import com.wfeel.entity.DecorateUser;
import com.wfeel.entity.DecorateViotation;
import com.wfeel.iservice.IDecorateUserService;
import com.wfeel.service.DecorateUserService;
import com.wfeel.service.ViotationPunishService;

/**
 * Servlet implementation class ApiLoginUser
 */
@WebServlet("/api/updatePunish")
public class ApiUpdatePunish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApiUpdatePunish() {
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
		System.out.println("/api/updatePunish");

		Map<String, String> map = new HashMap<>();

		String punish_id = request.getParameter("punish_id");

		ViotationPunishService service = new ViotationPunishService();
		if(service.changePunish(punish_id)) {
			map.put(DecorateConstants.STATUS, DecorateConstants.SUCCESS);
			map.put(DecorateConstants.MESSAGE, "办理成功");
		}else {
			map.put(DecorateConstants.STATUS, DecorateConstants.FAIL);
			map.put(DecorateConstants.MESSAGE, "办理失败");
		}

		System.out.println(FastJsonTool.createJsonString(map));
		out.print(FastJsonTool.createJsonString(map));
		out.close();
	}
}
