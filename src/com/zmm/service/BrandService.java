package com.zmm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import com.dao.impl.BrandImpl;
import com.zmm.dao.IBrand;
import com.zmm.pojo.Brand;
import com.zmm.util.HibernateSessionFactory;

public class BrandService {
	IBrand brand = new BrandImpl();

	public void addBrand(Brand b) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			brand.setSesstion(session);
			brand.addBrand(b);//从impl传来，持久状态
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

	public void deleteBrand(Brand b) throws Exception {
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			brand.setSesstion(session);
			brand.deleteBrand(b);
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

	public void modifyBrand(Brand b) throws Exception {
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			brand.setSesstion(session);
			brand.modifyBrand(b);

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

	public Brand getBrand(int id) throws Exception {

		Session session = null;
		Brand b = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			brand.setSesstion(session);
			b = brand.getBrand(id);
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


	public List<Brand> listBrand() throws Exception {
		Session session = null;
		List<Brand> bList = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			brand.setSesstion(session);
			bList = brand.listBrand();
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

		return bList;
	}

}
