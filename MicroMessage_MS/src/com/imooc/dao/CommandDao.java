package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Command;
import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

/**
 * @author ��
 *��ָ����Ӧ�����ݿ������
 */
public class CommandDao {
	/**
	 * ���ݲ�ѯ������ѯָ���б�
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
			//ͨ��sqlSessionִ��SQL���
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
