package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Command;
import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

/**
 * @author 明
 *与指令表对应的数据库操作类
 */
public class CommandDao {
	/**
	 * 根据查询条件查询指令列表
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Command> queryCommandList(String name,String description){
		DBAccess dbAccess=new DBAccess();
		List<Command> commandList=new ArrayList<Command>();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			Command command=new Command();
			command.setName(name);
			command.setDescription(description);
			//通过sqlSession执行SQL语句
			commandList=sqlSession.selectList("Command.queryCommandList",command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}

		}
		return commandList;
	}

}
