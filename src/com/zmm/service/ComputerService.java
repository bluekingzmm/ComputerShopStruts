package com.zmm.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.dao.impl.ComputerImpl;
import com.zmm.dao.IComputer;
import com.zmm.pojo.Computer;
import com.zmm.pojo.ShopCart;
import com.zmm.util.DataBase;
import com.zmm.util.HibernateSessionFactory;

public class ComputerService {
	Connection con = null;
	IComputer com = new ComputerImpl();
	/*
	 * (non-Javcoc)
	 * 
	 * @see com.zmm.dao.IComputer#save(com.zmm.dto.Computer)
	 */

	public void save(Computer c) throws Exception{
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			com.setSesstion(session);
			com.save(c);//从impl传来，持久状态
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
	
//	public boolean save(Computer c) throws Exception {
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			com.setConnection(con);
//			result = com.save(c);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//		return result;
//	}

	/*
	 * (non-Javcoc)
	 * 
	 * @see com.zmm.dao.IComputer#update(com.zmm.dto.Computer)
	 */
	
	public void update(Computer c) throws Exception{
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			com.setSesstion(session);
			com.update(c);

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

//	public boolean update(Computer c) throws Exception {
//		// TODO Auto-generated method stub
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			com.setConnection(con);
//			result = com.update(c);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//		return result;
//	}

	/*
	 * 修改库存（库存=库存-购买数量）
	 */

	public void updateSubCount(Map<String, Object> session) {
		// TODO Auto-generated method stub
		ShopCartService scs = null;
		ShopCart s = null;
		int count = 0;
		try {
			scs = new ShopCartService();
			List<ShopCart> sList = new ArrayList<ShopCart>(scs.getShopCart(session));
			for (int i = 0; i < sList.size(); i++) {
				s = sList.get(i);
				count = s.getCom().getNum() - s.getCount();
				Computer com = get(s.getCom().getCom_id());
				com.setNum(count);
				update(com);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void updateStatus(Computer c) throws Exception{
		Session session = null;
		try {
			// 通过HibernateSessionFactory会话工厂得到会话工厂，然后调用openSession得到session
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			com.setSesstion(session);
			com.updateStatus(c);

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

//	public boolean updateStatus(Computer c) throws Exception {
//		// TODO Auto-generated method stub
//		boolean result = false;
//		try {
//			con = DataBase.getConn();
//			com.setConnection(con);
//			result = com.updateStatus(c);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//		return result;
//	}

	/*
	 * (non-Javcoc)
	 * 
	 * @see com.zmm.dao.IComputer#get(int)
	 */

//	public Computer get(int comId) throws Exception {
//		Computer c = null;
//		try {
//			con = DataBase.getConn();
//			com.setConnection(con);
//			c = com.get(comId);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DataBase.releaseConnection(con);
//		}
//		return c;
//	}
	

	/*
	 * (non-Javcoc)
	 * 
	 * @see com.zmm.dao.IComputer#list(int, int, java.lang.String)
	 */

	public List<Computer> list(int pageSize, int pageNo, String keyWord) throws Exception {
		// TODO Auto-generated method stub

		List<Computer> cList = null;

		try {
			con = DataBase.getConn();
			com.setConnection(con);
			cList = com.list(pageSize, pageNo, keyWord);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBase.releaseConnection(con);
		}
		return cList;
	}

	public int getCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub

		int count = 0;
		try {
			con = DataBase.getConn();
			com.setConnection(con);
			count = com.getCount(keyWord);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DataBase.releaseConnection(con);
		}
		return count;
	}
	
	public Computer get(int comId) throws Exception {
		Session session = null;
		Computer c = null;
		
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			// 开始数据库事务
			session.beginTransaction();
			// 把session交给usersDAO
			com.setSesstion(session);
		
			c = com.get(comId);
			System.out.println("asd");
			// 提交事务
			session.getTransaction().commit();
		} catch (SQLException e) {
			// 出现异常回滚事务
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		return c;
	}

}
