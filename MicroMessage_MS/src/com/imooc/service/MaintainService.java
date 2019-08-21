package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.MessageDao;

/**
 *ά����ص�ҵ����
 */
public class MaintainService {
	/**
	 * ����ɾ��
	 */
	public void deleteOne(String id) {
		if(id!=null&&!"".equals(id.trim())) {
			MessageDao messageDao=new MessageDao();
			messageDao.deleteOne(Integer.parseInt(id));
		}
	}
	
	/**
	 * ����ɾ��
	 */
	public void deleteBatch(String[] ids) {
			MessageDao messageDao=new MessageDao();
			List<Integer> idList=new ArrayList<Integer>();
			for(String id:ids) {
				idList.add(Integer.parseInt(id));
			}
			messageDao.deleteBatch(idList);
		
	}
	
//	public void insertOne()

}