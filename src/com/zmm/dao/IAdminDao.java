/**
 * 
 */
package com.zmm.dao;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;

import com.zmm.pojo.Admin;


/**
 * @author Administrator
 *
 */
public interface IAdminDao {

	public void setConnection(Connection con) throws Exception;

	/*
	 * ���ܣ�����Ա��¼
	 */

	public Admin login(String adminName, String adminPassword) throws Exception;

	/*
	 * ��ȡ������Ʒ�ĸ���
	 */
	public int getComputerCount() throws Exception;
	/*
	 * ��ȡ����Ա�ĸ���
	 */
	public int getCount(Admin ad) throws Exception;

	/*
	 * �ڻ���վ��ɾ������Ա
	 */

//	public boolean delete(int id) throws Exception;
	
	public void delete(Admin ad) throws Exception;

	/*
	 * ��ӹ���Ա
	 */

//	public boolean add(Admin ad) throws Exception;
	public void add(Admin ad) throws Exception;


	/*
	 * �ҵ�����Աid
	 */

	public Admin getById(String id) throws Exception;

	/*
	 * �޸Ĺ���Ա��Ϣ
	 */
//	public boolean update(Admin ad) throws Exception;
	public void update(Admin ad) throws Exception;

	/*
	 * ��ʾ���й���Ա
	 */
	public List<Admin> listAdmin(int pageNo,int pageSize) throws Exception;

	/*
	 * ɾ������Ա������վ
	 */

	public void updateStatus(Admin ad) throws Exception;

	/*
	 * �鿴����վ
	 */

	public List<Admin> recycleBinList(int pageNo,int pageSize) throws Exception;

	/*
	 * ��ջ���վ
	 */

	public void deleteStatus() throws Exception;
	
	/*
	 * �޸�����õ�������
	 */
	
	public Admin getPassword(String adminPassword,String adminName)throws Exception;
	
	public void setSesstion(Session session) throws Exception;
}
