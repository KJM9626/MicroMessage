package com.imooc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.CommandContent;
import com.imooc.db.DBAccess;

public class CommandContentDao {
	
	/**
	 * JDBC��ʽ��������
	 */
	public void insertBatchByJdbc(List<CommandContent> contentList) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_message?useSSL=false&serverTimezone=UTC");
			String insertSql="insert into command_content(content,command_id) values (?,?)";
			PreparedStatement statement=conn.prepareStatement(insertSql);
			for(CommandContent commandContent:contentList) {
				statement.setString(1, commandContent.getContent());
				statement.setString(2, commandContent.getCommandId());
				statement.addBatch();//��ÿһ����������Ϣ�ӵ�list�Ȼ��һ����ִ����������������ÿ�����ظ����˷�ʱ����ڴ�ռ�
			}
			statement.executeBatch();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ʵ�ֵ�������
	 */
	public void insertOne(CommandContent content) {
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
			ICommandContent commandContent=sqlSession.getMapper(ICommandContent.class);
			commandContent.insertOne(content);		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * mybatisʵ����������
	 */
	public void insertBatch(List<CommandContent> contentList) {
		DBAccess dbAccess=new DBAccess();
		SqlSession session=null;
		try {
			session=dbAccess.getSqlSession();
			//ͨ��sessionִ��SQL���
			ICommandContent commandContent=session.getMapper(ICommandContent.class);
			/*for(CommandContent content:contentList) {//������������������
				commandContent.insertOne(content);
			}*/
			commandContent.insertBatch(contentList);
			session.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	}

}
