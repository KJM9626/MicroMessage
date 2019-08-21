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
	 * JDBC方式批量新增
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
				statement.addBatch();//将每一条新增的信息加到list里，然后一次性执行批量新增，避免每次来回更新浪费时间和内存空间
			}
			statement.executeBatch();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 实现单条新增
	 */
	public void insertOne(CommandContent content) {
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
			ICommandContent commandContent=sqlSession.getMapper(ICommandContent.class);
			commandContent.insertOne(content);		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * mybatis实现批量新增
	 */
	public void insertBatch(List<CommandContent> contentList) {
		DBAccess dbAccess=new DBAccess();
		SqlSession session=null;
		try {
			session=dbAccess.getSqlSession();
			//通过session执行SQL语句
			ICommandContent commandContent=session.getMapper(ICommandContent.class);
			/*for(CommandContent content:contentList) {//初级做法，逐条插入
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
