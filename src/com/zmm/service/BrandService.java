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
			// ͨ��HibernateSessionFactory�Ự�����õ��Ự������Ȼ�����openSession�õ�session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO
			brand.setSesstion(session);
			brand.addBrand(b);//��impl�������־�״̬
			// �ύ����
			session.getTransaction().commit();   
		} catch (SQLException e) {
			// �����쳣�ع�����
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	public void deleteBrand(Brand b) throws Exception {
		Session session = null;
		try {
			// ͨ��HibernateSessionFactory�Ự�����õ��Ự������Ȼ�����openSession�õ�session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO
			brand.setSesstion(session);
			brand.deleteBrand(b);
			// �ύ����
			session.getTransaction().commit();
		} catch (SQLException e) {
			// �����쳣�ع�����
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void modifyBrand(Brand b) throws Exception {
		Session session = null;
		try {
			// ͨ��HibernateSessionFactory�Ự�����õ��Ự������Ȼ�����openSession�õ�session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO
			brand.setSesstion(session);
			brand.modifyBrand(b);

			// �ύ����
			session.getTransaction().commit();
		} catch (SQLException e) {
			// �����쳣�ع�����
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
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO
			brand.setSesstion(session);
			b = brand.getBrand(id);
			// �ύ����
			session.getTransaction().commit();
		} catch (SQLException e) {
			// �����쳣�ع�����
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
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO
			brand.setSesstion(session);
			bList = brand.listBrand();
			// �ύ����
			session.getTransaction().commit();
		} catch (SQLException e) {
			// �����쳣�ع�����
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

		return bList;
	}

}
