package com.zmm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import com.dao.impl.CpuImpl;
import com.zmm.dao.ICpu;
import com.zmm.pojo.Cpu;
import com.zmm.util.HibernateSessionFactory;

public class CpuService {
//	Connection con = null;
	ICpu cpu = new CpuImpl();

//	public boolean addCpu(Cpu c) throws Exception {
//
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			cpu.setConnection(con);
//			result = cpu.addCpu(c);
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
//	 * @see com.zmm.dao.ICpu#deleteCpu(int)
//	 */
//
//	public boolean deleteCpu(int id) throws Exception {
//
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			cpu.setConnection(con);
//			result = cpu.deleteCpu(id);
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
//	 * @see com.zmm.dao.ICpu#modifyCpu(com.zmm.dto.Cpu)
//	 */
//
//	public boolean modifyCpu(Cpu c) throws Exception {
//
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			cpu.setConnection(con);
//			result = cpu.modifyCpu(c);
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
//	 * @see com.zmm.dao.ICpu#listCpu()
//	 */
//
//	public List<Cpu> listCpu() throws Exception {
//		// TODO Auto-generated method stub
//		Connection con = null;
//		List<Cpu> cList = null;
//		try {
//			con = DataBase.getConn();
//			cpu.setConnection(con);
//			cList = cpu.listCpu();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally {
//			DataBase.releaseConnection(con);
//		}
//
//		return cList;
//	}
//
//	public Cpu getCpu(int id) throws Exception {
//		Connection con = null;
//		Cpu c = null;
//		try {
//			con = DataBase.getConn();
//			cpu.setConnection(con);
//			c = cpu.getCpu(id);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//
//		return c;
//	}
	public void addCpu(Cpu b) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			// ͨ��HibernateSessionFactory�Ự�����õ��Ự������Ȼ�����openSession�õ�session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO
			cpu.setSesstion(session);
			cpu.addCpu(b);//��impl�������־�״̬
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

	public void deleteCpu(Cpu b) throws Exception {
		Session session = null;
		try {
			// ͨ��HibernateSessionFactory�Ự�����õ��Ự������Ȼ�����openSession�õ�session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO
			cpu.setSesstion(session);
			cpu.deleteCpu(b);
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

	public void modifyCpu(Cpu b) throws Exception {
		Session session = null;
		try {
			// ͨ��HibernateSessionFactory�Ự�����õ��Ự������Ȼ�����openSession�õ�session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO
			cpu.setSesstion(session);
			cpu.modifyCpu(b);

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

	public Cpu getCpu(int id) throws Exception {

		Session session = null;
		Cpu b = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO
			cpu.setSesstion(session);
			b = cpu.getCpu(id);
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


	public List<Cpu> listCpu() throws Exception {
		Session session = null;
		List<Cpu> cList = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO
			cpu.setSesstion(session);
			cList = cpu.listCpu();
			// �ύ����
			session.getTransaction().commit();
		} catch (SQLException e) {
			// �����쳣�ع�����
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

		return cList;
	}
}
