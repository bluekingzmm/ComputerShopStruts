package com.zmm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import com.dao.impl.AdminImpl;
import com.zmm.dao.IAdminDao;
import com.zmm.pojo.Admin;
import com.zmm.util.HibernateSessionFactory;

public class AdminService {

	IAdminDao admin = new AdminImpl();


	public void addAdmin(Admin ad) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			admin.setSesstion(session);
			admin.add(ad);// 从impl传来，持久状态
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

	public void delete(Admin ad) throws Exception {
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			admin.setSesstion(session);
			admin.delete(ad);
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

	public void modify(Admin ad) throws Exception {
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			admin.setSesstion(session);
			admin.update(ad);

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

	public Admin login(String admin_name, String admin_password) throws Exception {
		Session session = null;
		Admin ad = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			admin.setSesstion(session);
			ad = admin.login(admin_name, admin_password);
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		return ad;
	}

	public Admin getById(String id) throws Exception {

		Session session = null;
		Admin ad = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			admin.setSesstion(session);
			ad = admin.getById(id);
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		return ad;
	}

	

	public List<Admin> listAdmin(int pageNo, int pageSize) throws Exception {
		List<Admin> aList = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			admin.setSesstion(session);
			aList = admin.listAdmin(pageNo, pageSize);
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		return aList;

	}


	public void updateStatus(Admin ad) throws Exception {
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			admin.setSesstion(session);
			admin.updateStatus(ad);
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
	public void deleteStatus() throws Exception {
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			admin.setSesstion(session);
			admin.deleteStatus();
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


	public List<Admin> recycleBinList(int pageNo, int pageSize) throws Exception {
		List<Admin> aList = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			admin.setSesstion(session);
			aList = admin.recycleBinList(pageNo, pageSize);
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		return aList;

	}


	public Admin getPassword(String adminPassword, String adminName) throws Exception {

		Session session = null;
		Admin ad = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			admin.setSesstion(session);
			ad = admin.getPassword(adminPassword, adminName);
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		return ad;
	}

	


	public int getCount(Admin ad) throws Exception {
		Session session = null;
		int count=0;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			admin.setSesstion(session);
			count = admin.getCount(ad);
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

}
