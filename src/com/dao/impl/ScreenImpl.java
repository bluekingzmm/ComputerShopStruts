/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.zmm.dao.IScreen;
import com.zmm.pojo.Screen;
import com.zmm.util.DataBase;

/**
 * @author Administrator
 *
 */
public class ScreenImpl extends DataBase implements IScreen {

	
	private Session session=null;
	public void setSesstion(Session session) throws Exception{
		this.session=session;
	}

	@Override
	public Screen getScreen(int id) throws Exception {
		// TODO Auto-generated method stub
		return (Screen)session.get(Screen.class, id);
	}

	@Override
	public void addScreen(Screen s) throws Exception {
		// TODO Auto-generated method stub
		session.save(s);
	}

	@Override
	public void deleteScreen(Screen s) throws Exception {
		// TODO Auto-generated method stub
		session.delete(s);
	}

	@Override
	public void modifyScreen(Screen s) throws Exception {
		// TODO Auto-generated method stub
		session.update(s);
	}

	@Override
	public List<Screen> listScreen() throws Exception {
		// TODO Auto-generated method stub
		return session.createQuery("from Screen").list();
	}


}
