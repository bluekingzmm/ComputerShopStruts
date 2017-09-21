/**
 * 
 */
package com.zmm.dao;

import java.util.List;

import org.hibernate.Session;

import com.zmm.pojo.Screen;

/**
 * @author Administrator
 *
 */
public interface IScreen {
	public void setSesstion(Session session) throws Exception;

	public Screen getScreen(int id) throws Exception;
	
	
//	public void setConnection(Connection con) throws Exception;
	/*
	 * ���ܣ�������Ļ�ߴ�����
	 */
//	public boolean addScreen(Screen s) throws Exception;
	public void addScreen(Screen s) throws Exception;

	/*
	 * ���ܣ�ɾ����Ļ�ߴ�����
	 */

//	public boolean deleteScreen(int id) throws Exception;
	public void deleteScreen(Screen s) throws Exception;

	/*
	 * ���ܣ��޸���Ļ�ߴ�����
	 */

//	public boolean modifyScreen(Screen s) throws Exception;
	public void modifyScreen(Screen s) throws Exception;

	/*
	 * ���ܣ���Ļ�ߴ��б�
	 */
	public List<Screen> listScreen() throws Exception;
}
