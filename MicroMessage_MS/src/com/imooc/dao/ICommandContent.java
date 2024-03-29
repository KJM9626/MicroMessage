package com.imooc.dao;

import java.util.List;

import com.imooc.bean.CommandContent;

/**
 *与CommandContent配置文件相对应的接口
 */
public interface ICommandContent {
	
	/**
	 * 单挑新增
	 */
	public void insertOne(CommandContent content);
	
	/**
	 * 批量新增
	 */
	public void insertBatch(List<CommandContent> content);

}

