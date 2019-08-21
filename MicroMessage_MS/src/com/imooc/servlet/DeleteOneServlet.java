package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;
import com.imooc.service.MaintainService;

/**
 * @author 明
 *单条删除控制层
 */
public class DeleteOneServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置页面编码
		req.setCharacterEncoding("UTF-8");
		//接收页面的值
		String id=req.getParameter("id");//此方法只能获取String类型
		MaintainService maintainService=new MaintainService();
		maintainService.deleteOne(id);
		//向页面跳转
		req.getRequestDispatcher("/List.action").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doGet(req, resp);
	}

}
