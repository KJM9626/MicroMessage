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
 * 和message表相关的数据库操作
 */

public class MessageDao {
	
	/**
	 * 根据查询条件查询消息列表
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
			//通过sqlSession执行SQL语句
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
	 * 根据查询条件查询消息列表的条数
	 */
	
	public int count (Message message) {
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		int result=0;
		try {
			sqlSession=dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
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
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(Map<String, Object> parameter){
		DBAccess dbAccess=new DBAccess();
		List<Message> messageList=new ArrayList<Message>();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
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
	 * 实现单条信息删除
	 * @param id
	 */
	public void deleteOne(int id) {
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
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
	 * 实现多条信息删除
	 * @param id
	 */
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
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
	 * 根据查询条件查询消息列表
	 	
	public List<Message> queryMessageList(String command,String description) {
		List<Message> messageList=new ArrayList<Message>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_message", "root", "root");
			StringBuilder sql=new StringBuilder("select id,command,description,content from message where 1=1");
			//定义一个list来装查询的列表
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
			//把要查询的结果显示出来
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
