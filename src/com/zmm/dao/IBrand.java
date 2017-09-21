package com.zmm.dao;

import java.util.List;

import org.hibernate.Session;

import com.zmm.pojo.Brand;

public interface IBrand {
	
	public void setSesstion(Session session) throws Exception;
//	public void setConnection(Connection con) throws Exception;

	/*
	 * ���ܣ�����Ʒ������
	 */
//	public boolean addBrand(Brand b) throws Exception;
	public void addBrand(Brand b) throws Exception;

	/*
	 * ���ܣ�ɾ��Ʒ������
	 */

//	public boolean deleteBrand(int id) throws Exception;

	public void deleteBrand(Brand b) throws Exception;

	/*
	 * ���ܣ��޸�Ʒ������
	 */

//	public boolean modifyBrand(Brand b) throws Exception;

	public void modifyBrand(Brand b) throws Exception;

	/*
	 * ���ܣ�Ʒ���б�
	 */
	public List<Brand> listBrand() throws Exception;
	
	
	/*
	 * ���ܣ���ȡƷ��id
	 */
	public Brand getBrand(int id) throws Exception;
}
