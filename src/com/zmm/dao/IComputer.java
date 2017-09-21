package com.zmm.dao;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;

import com.zmm.pojo.Computer;

public interface IComputer {
	/*
	 * ��������
	 */
	public void setConnection(Connection con) throws Exception;

	/*
	 * ��ӵ�����Ʒ
	 */
	// public boolean save(Computer com) throws Exception;
	public void save(Computer com) throws Exception;

	/*
	 * �޸ĵ�����Ϣ
	 */
	// public boolean update(Computer com) throws Exception;
	public void update(Computer com) throws Exception;

	/*
	 * �޸ĵ���״̬
	 */
	// public boolean updateStatus(Computer com) throws Exception;
	public void updateStatus(Computer com) throws Exception;

	/*
	 * ͨ��id��õ�����Ϣ
	 */

	public Computer get(int comId) throws Exception;

	/*
	 * ��ʾ������Ϣ
	 */
	public List<Computer> list(int pageSize, int pageNo, String keyWord) throws Exception;

	/*
	 * ���������Ϣ����
	 */
	public int getCount(String keyWord) throws Exception;

	public void setSesstion(Session session) throws Exception;

}
