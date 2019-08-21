package com.imooc.servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.entity.Page;
import com.imooc.service.QueryService;

//ʹ��mybatis
/**
 * �б�ҳ���ʼ���Ͳ�ѯ����
 */
public class ListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����ҳ�����
		req.setCharacterEncoding("UTF-8");
		//����ҳ���ֵ
		String command=req.getParameter("command");
		String description=req.getParameter("description");
		String currentPage=req.getParameter("currentPage");
		//������ҳ����
		Page page=new Page();
		Pattern pattern=Pattern.compile("[0-9]{1,9}");
		if(currentPage==null||!pattern.matcher(currentPage).matches()) {//�������Ϊ�ջ������ʽ���ԣ�����Ϊ1
			page.setCurrentPage(1);
		}else {
			page.setCurrentPage(Integer.parseInt(currentPage));
		}
		QueryService listService=new QueryService();
		//��ѯ��Ϣ�б�����ҳ��
		req.setAttribute("messageList", listService.queryMessageListByPage(command,description,page));
		//��ҳ�洫ֵ
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		req.setAttribute("page", page);
//		req.setAttribute("currentPage", currentPage);
		//��ҳ����ת
		req.getRequestDispatcher("/WEB-INF/jsps/back/list.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doGet(req, resp);
	}

}
