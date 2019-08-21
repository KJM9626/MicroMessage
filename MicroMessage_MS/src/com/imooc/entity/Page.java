package com.imooc.entity;

/**
 *��ҳ��Ӧ��ʵ����
 */
public class Page {
	private int totalNumber;//������
	private int currentPage;//��ǰ�ڼ�ҳ
	private int totalPage;//��ҳ��
	private int pageNumber=5;//ÿҳ��ʾ����
	private int dbIndex;//���ݿ���limit�Ĳ������ӵڼ�����ʼȡ
	private int dbNumber;//���ݿ���limit�Ĳ�����һ��ȡ������
	
	/**
	 * ���ݵ�ǰ����������ֵ���㲢�����������ֵ
	 */
	public void count() {
		//������ҳ��
		int totalPageTemp=this.totalNumber/this.pageNumber;
		int plus=(this.totalNumber % this.pageNumber)==0?0:1;//�����Ϊ�㣬����Ҫ�¶࿪һҳ��
		totalPageTemp=totalPageTemp+plus;
		if(totalPageTemp<=0) {
			totalPageTemp=1;
		}
		this.totalPage=totalPageTemp;
		
		//���õ�ǰҳ��
		//��ҳ��С�ڵ�ǰҳ����Ӧ����ǰҳ������Ϊ��ҳ��
		if(this.totalPage<this.currentPage) {
			this.currentPage=this.totalPage;
		}
		//��ǰҳ��С��1����Ϊ1
		if(this.currentPage<1) {
			this.currentPage=1;
		}
		
		//����limit�Ĳ���
		this.dbIndex=(this.currentPage-1)*this.pageNumber;
		this.dbNumber=this.pageNumber;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		this.count();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
		this.count();
	}

	public int getDbIndex() {
		return dbIndex;
	}

	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}

	public int getDbNumber() {
		return dbNumber;
	}

	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}
	
	

}
