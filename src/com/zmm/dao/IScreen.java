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
	 * 功能：增加屏幕尺寸名称
	 */
//	public boolean addScreen(Screen s) throws Exception;
	public void addScreen(Screen s) throws Exception;

	/*
	 * 功能：删除屏幕尺寸名称
	 */

//	public boolean deleteScreen(int id) throws Exception;
	public void deleteScreen(Screen s) throws Exception;

	/*
	 * 功能：修改屏幕尺寸名称
	 */

//	public boolean modifyScreen(Screen s) throws Exception;
	public void modifyScreen(Screen s) throws Exception;

	/*
	 * 功能：屏幕尺寸列表
	 */
	public List<Screen> listScreen() throws Exception;
}
