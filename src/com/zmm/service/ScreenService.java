package com.zmm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import com.dao.impl.ScreenImpl;
import com.zmm.dao.IScreen;
import com.zmm.pojo.Screen;
import com.zmm.util.HibernateSessionFactory;

public class ScreenService {
	IScreen screen=new ScreenImpl();
//	Connection con=null;
//	public boolean addScreen(Screen s) throws Exception {
//
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			screen.setConnection(con);
//			result = screen.addScreen(s);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//
//		return result;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.zmm.dao.IBrand#deleteBrand(int)
//	 */
//
//	public boolean deleteScreen(int id) throws Exception {
//
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			screen.setConnection(con);
//			result = screen.deleteScreen(id);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//
//		return result;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.zmm.dao.IBrand#modifyBrand(com.zmm.dto.Brand)
//	 */
//
//	public boolean modifyScreen(Screen s) throws Exception {
//
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			screen.setConnection(con);
//			result = screen.modifyScreen(s);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//
//		return result;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.zmm.dao.IBrand#listBrand()
//	 */
//
//	public List<Screen> listScreen() throws Exception {
//		// TODO Auto-generated method stub
//		Connection con = null;
//		List<Screen> sList = null;
//		try {
//			con = DataBase.getConn();
//			screen.setConnection(con);
//			sList = screen.listScreen();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally {
//			DataBase.releaseConnection(con);
//		}
//
//		return sList;
//	}
//
//	public Screen getScreen(int id) throws Exception {
//		Connection con = null;
//		Screen s = null;
//		try {
//			con = DataBase.getConn();
//			screen.setConnection(con);
//			s = screen.getScreen(id);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//
//		return s;
//	}
	
	public void addScreen(Screen s) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			screen.setSesstion(session);
			screen.addScreen(s);//从impl传来，持久状态
			// 提交事务
			session.getTransaction().commit();   
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	public void deleteScreen(Screen s) throws Exception {
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			screen.setSesstion(session);
			screen.deleteScreen(s);
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void modifyScreen(Screen s) throws Exception {
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			screen.setSesstion(session);
			screen.modifyScreen(s);

			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public Screen getScreen(int id) throws Exception {

		Session session = null;
		Screen b = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			screen.setSesstion(session);
			b = screen.getScreen(id);
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		return b;
	}


	public List<Screen> listScreen() throws Exception {
		Session session = null;
		List<Screen> sList = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			screen.setSesstion(session);
			sList = screen.listScreen();
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

		return sList;
	}
}
