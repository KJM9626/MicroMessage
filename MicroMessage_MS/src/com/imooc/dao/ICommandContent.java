package com.imooc.dao;

import java.util.List;

import com.imooc.bean.CommandContent;

/**
 *��CommandContent�����ļ����Ӧ�Ľӿ�
 */
public interface ICommandContent {
	
	/**
	 * ��������
	 */
	public void insertOne(CommandContent content);
	
	/**
	 * ��������
	 */
	public void insertBatch(List<CommandContent> content);

}

