package com.imooc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;
import com.imooc.service.QueryService;

/**
 * @author 明
 *自动回复功能控制层
 */
public class AutoReplyServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		QueryService queryService=new QueryService();
		out.write(queryService.queryByCommand(req.getParameter("content")));
		out.flush();
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doGet(req, resp);
	}

}
