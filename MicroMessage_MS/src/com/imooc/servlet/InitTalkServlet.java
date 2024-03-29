package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;

/**
 * @author 明
 *对话页面的初始化控制
 */
public class InitTalkServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置页面编码
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("UTF-8");
		//向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsps/front/talk.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
