/**
 * 
 */
package com.zmm.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import com.dao.impl.UserImpl;
import com.zmm.dao.IUser;
import com.zmm.pojo.Admin;
import com.zmm.pojo.User;
import com.zmm.util.DataBase;
import com.zmm.util.HibernateSessionFactory;


/**
 * @author Administrator
 *
 */
public class UserService {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#add(com.zmm.dto.User)
	 */
	IUser user = new UserImpl();

//	public boolean add(User u) throws Exception {
//		// TODO Auto-generated method stub
//		Connection con = null;
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			user.setConnection(con);
//			result = user.add(u);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//		return result;
//
//	}
	public void add(User u) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			user.setSesstion(session);
			user.add(u);// 从impl传来，持久状态
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

	public List<User> search(String keyword) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		List<User> uList=null;
		try {
			con = DataBase.getConn();
			user.setConnection(con);
			uList = user.search(keyword);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBase.releaseConnection(con);
		}
		return uList;
		
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#delete(int)
	 */
//	public boolean delete(String userId) throws Exception {
//		// TODO Auto-generated method stub
//		Connection con = null;
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			user.setConnection(con);
//			result = user.delete(userId);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//		return result;
//
//	}
	public void delete(User u) throws Exception {
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			user.setSesstion(session);
			user.delete(u);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#modifyOwn(com.zmm.dto.User)
	 */
//	public boolean modifyOwn(User u) throws Exception {
//		// TODO Auto-generated method stub
//		Connection con = null;
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			user.setConnection(con);
//			result = user.modifyOwn(u);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//		return result;
//	}
	public void modifyOwn(User u) throws Exception {
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			user.setSesstion(session);
			user.modifyOwn(u);

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#getById(int)
	 */
	public User getById(String userId) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		User u = null;
		try {
			con = DataBase.getConn();
			user.setConnection(con);
			u = user.getById(userId);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBase.releaseConnection(con);
		}
		return u;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#listUser(int, int)
	 */

//	public List<User> listUser(int pageNo, int pageSize) throws Exception {
//		// TODO Auto-generated method stub
//		Connection con = null;
//		List<User> uList = null;
//		try {
//			con = DataBase.getConn();
//			user.setConnection(con);
//			uList = user.listUser(pageNo, pageSize);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//		return uList;
//	}
	public List<User> listUser(int pageNo, int pageSize) throws Exception {
		System.out.println("service");
		List<User> uList = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			user.setSesstion(session);
			uList = user.listUser(pageNo, pageSize);
			System.out.println("service"+uList.toString());
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		return uList;

	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#login(java.lang.String, java.lang.String)
	 */
//	public User login(String userName, String userPassword) throws Exception {
//		// TODO Auto-generated method stub
//		Connection con = null;
//		User u = null;
//		try {
//			con = DataBase.getConn();
//			user.setConnection(con);
//			u = user.login(userName, userPassword);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//		return u;
//	}
	public User login(String userName, String userPassword) throws Exception {
		Session session = null;
		User u = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			user.setSesstion(session);
			u = user.login(userName, userPassword);
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		return u;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#getUserCount()
	 */
//	public int getUserCount(User u) throws Exception {
//		// TODO Auto-generated method stub
//		Connection con = null;
//		int count = 0;
//		try {
//			con = DataBase.getConn();
//			user.setConnection(con);
//			count = user.getUserCount(u);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//		return count;
//	}
	public int getUserCount(User u) throws Exception {
		Session session = null;
		int count=0;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			user.setSesstion(session);
			count = user.getUserCount(u);
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#updateStatus(com.zmm.dto.Admin)
	 */
//	public boolean updateStatus(User u) throws Exception {
//		// TODO Auto-generated method stub
//		Connection con = null;
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			user.setConnection(con);
//			result = user.updateStatus(u);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//		return result;
//	}
	public void updateStatus(User u) throws Exception {
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			user.setSesstion(session);
			user.updateStatus(u);
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
//	public boolean updatePsw(String userPassword,String userName) throws Exception {
//		// TODO Auto-generated method stub
//		Connection con = null;
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			user.setConnection(con);
//			result = user.updatePsw(userPassword, userName);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//		return result;
//	}
	public void updatePsw(String userPassword,String userName) throws Exception {
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			user.setSesstion(session);
			user.updatePsw(userPassword, userName);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#recycleBinList(int, int)
	 */
//	public List<User> recycleBinList(int pageNo, int pageSize,User u) throws Exception {
//		Connection con = null;
//		List<User> uList = null;
//		try {
//			con = DataBase.getConn();
//			user.setConnection(con);
//			uList = user.recycleBinList(pageNo, pageSize,u);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//
//		}
//		return uList;
//	}
	
	public List<User> recycleBinList(int pageNo, int pageSize,User u) throws Exception {
		List<User> uList = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			user.setSesstion(session);
			uList = user.recycleBinList(pageNo, pageSize,u);
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		return uList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#deleteStatus()
	 */
	public boolean deleteStatus() throws Exception {
		Connection con = null;
		boolean result = false;
		try {
			con = DataBase.getConn();
			user.setConnection(con);
			user.deleteStatus();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBase.releaseConnection(con);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#getPassword(java.lang.String, java.lang.String)
	 */
	public User getPassword(String userPassword, String userName) throws Exception {
		Connection con = null;
		User u = null;
		try {
			con = DataBase.getConn();
			user.setConnection(con);
			u = user.getPassword(userPassword, userName);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBase.releaseConnection(con);
		}

		return u;
	}

	/*
	 * 查询用密码，判断是否注册过
	 */
	public boolean searchUsername(String userName) throws Exception {
		Connection con = null;
		boolean result=false;
		try {
			con = DataBase.getConn();
			user.setConnection(con);
			result = user.searchUsername(userName);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBase.releaseConnection(con);
		}
		return result;
	}
	public User searchMail(String mail,String userName) throws Exception {
		Connection con = null;
		User u=null;
		try {
			con = DataBase.getConn();
			user.setConnection(con);
			u = user.searchMail(mail,userName);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBase.releaseConnection(con);
		}
		return u;
	}
	public boolean searchMailName(String mail) throws Exception {
		Connection con = null;
		
		boolean result=false;
		try {
			con = DataBase.getConn();
			user.setConnection(con);
			result = user.searchMailName(mail);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBase.releaseConnection(con);
		}
		return result;
	}
	/*
	 * 查询注册码，
	 */
	public User active(String code) throws Exception{
		Connection con = null;
		User u = null;
		try {
			con = DataBase.getConn();
			user.setConnection(con);
			u = user.active(code);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBase.releaseConnection(con);
		}
		return u;
	}
	
}
