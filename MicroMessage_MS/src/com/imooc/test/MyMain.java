package com.imooc.test;

import java.util.List;

public class MyMain {
	public static void main(String[]args) {
		System.out.println("����������Ϣ....");
		System.out.println("ͨ������������Ϣ����һ����������Map:");
		System.out.println("���Map��ŵ��ǽӿ�Class���Ӧ�Ĵ�������");
		SqlSession session=new SqlSession();
		MyInterface myInterface=session.getMapper(MyInterface.class);
		List<Object>list=myInterface.query(new Object());
		System.out.println(list.size());
	}

}