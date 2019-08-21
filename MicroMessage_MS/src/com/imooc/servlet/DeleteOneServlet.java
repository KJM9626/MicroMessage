package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;
import com.imooc.service.MaintainService;

/**
 * @author ��
 *����ɾ�����Ʋ�
 */
public class DeleteOneServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����ҳ�����
		req.setCharacterEncoding("UTF-8");
		//����ҳ���ֵ
		String id=req.getParameter("id");//�˷���ֻ�ܻ�ȡString����
		MaintainService maintainService=new MaintainService();
		maintainService.deleteOne(id);
		//��ҳ����ת
		req.getRequestDispatcher("/List.action").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doGet(req, resp);
	}

}