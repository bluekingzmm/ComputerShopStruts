package com.zmm.dao;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;

import com.zmm.pojo.User;

public interface IUser {
	
	public void setConnection(Connection con) throws Exception;

	/*
	 * �û�ע��
	 */
	public void add(User user) throws Exception;

	/*
	 * ɾ���û�
	 */

	public void delete(User user) throws Exception;

	/*
	 * �û��޸ĸ�����Ϣ
	 */
	public void modifyOwn(User user) throws Exception;

	/*
	 * ͨ��id���û�
	 */

	public User getById(String userId) throws Exception;
	
	/*
	 * ��ʾ�û��б�
	 */
	
	public List<User> listUser(int pageNo,int pageSize)throws Exception;
	
	/*
	 * �û���¼
	 */
	
	public User login(String userName, String userPassword) throws Exception;
	

	/*
	 * ��ȡ�û��ĸ���
	 */
	public int getUserCount(User user) throws Exception;
	
	/*
	 * ɾ���û�������վ
	 */

	public void updateStatus(User user) throws Exception;

	/*
	 * �鿴����վ
	 */

	public List<User> recycleBinList(int pageNo,int pageSize,User u) throws Exception;

	/*
	 * ��ջ���վ
	 */

	public void deleteStatus() throws Exception;

	
	/*
	 * ���չؼ��ֲ�ѯ
	 */
	
	public List<User> search(String keyword) throws Exception;
	
	/*
	 * �޸�����õ�������
	 */
	
	public User getPassword(String userPassword,String userName)throws Exception;
	
	/*
	 * ��ѯ�����룬�ж��Ƿ�ע���
	 */
	public boolean searchUsername(String userName)throws Exception;
	
	/*
	 * ��ѯע����
	 */
	
	
	public User active(String code) throws Exception;
	
	/*
	 * ͨ�������ѯ�Ƿ񼤻���
	 */
	public User searchMail(String mail,String userName) throws Exception;
	
	public void updatePsw(String userPassword,String userName) throws Exception;
	
	public boolean searchMailName(String mail) throws Exception;
	public void setSesstion(Session session) throws Exception;

}
