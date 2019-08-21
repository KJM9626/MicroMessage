package com.imooc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.naming.java.javaURLContextFactory;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;
import com.sun.prism.Image;

import sun.launcher.resources.launcher;

/**
 * ��message����ص����ݿ����
 */

public class MessageDao {
	
	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Message> queryMessageList(Map<String, Object> parameter){
		DBAccess dbAccess=new DBAccess();
		List<Message> messageList=new ArrayList<Message>();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
			IMessage iMessage=sqlSession.getMapper(IMessage.class);
			messageList=iMessage.queryMessageList(parameter);
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}

		}
		return messageList;
	}
	
	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б������
	 */
	
	public int count (Message message) {
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		int result=0;
		try {
			sqlSession=dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
			IMessage iMessage=sqlSession.getMapper(IMessage.class);
			result=iMessage.count(message);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return result;
	}
	
	/**
	 * ���ݲ�ѯ������ҳ��ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageListByPage(Map<String, Object> parameter){
		DBAccess dbAccess=new DBAccess();
		List<Message> messageList=new ArrayList<Message>();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
			IMessage iMessage=sqlSession.getMapper(IMessage.class);
			messageList=iMessage.queryMessageListByPage(parameter);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	/**
	 * ʵ�ֵ�����Ϣɾ��
	 * @param id
	 */
	public void deleteOne(int id) {
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
            sqlSession.delete("Message.deleteOne",id);
            sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}

		}
	}
	
	/**
	 * ʵ�ֶ�����Ϣɾ��
	 * @param id
	 */
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
            sqlSession.delete("Message.deleteBatch",ids);
            sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}

		}
	}
	
/*	public static void main(String[] args) {
		MessageDao messageDao=new MessageDao();
		messageDao.queryMessageList("", "");
	}*/
	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 	
	public List<Message> queryMessageList(String command,String description) {
		List<Message> messageList=new ArrayList<Message>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_message", "root", "root");
			StringBuilder sql=new StringBuilder("select id,command,description,content from message where 1=1");
			//����һ��list��װ��ѯ���б�
			List<String> paramList=new ArrayList<String>();
			if(command!=null&&!"".equals(command.trim())) {
				sql.append(" and command=?");
				paramList.add(command);
			}
			if(description!=null&&!"".equals(description.trim())) {
				sql.append(" and description like concat('%',?,'%')");
				paramList.add(description);
			}
			PreparedStatement statement=conn.prepareStatement(sql.toString());
			//��Ҫ��ѯ�Ľ����ʾ����
			for(int i=0;i<paramList.size();i++) {
				statement.setString(i+1, paramList.get(i));
			}
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Message message=new Message();
				message.setId(rs.getInt("id"));
				message.setCommand(rs.getString("command"));
				message.setContent(rs.getString("content"));
				message.setDescription(rs.getString("description"));
				messageList.add(message);
			}
			
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return messageList;
	}	 
	*/
}
