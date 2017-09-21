/**
 * 
 */
package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zmm.dao.IAdminDao;
import com.zmm.pojo.Admin;

/**
 * @author Administrator
 *
 */
public class AdminImpl implements IAdminDao {
	Connection con = null;

	/*
	 * @see com.zmm.dao.IAdminDao#deleteAdmin(int)
	 */
	public void setConnection(Connection con) throws Exception {
		// TODO Auto-generated method stub
		this.con = con;
	}

	public Admin login(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		Admin admin = null;
		try {
			Query query = session.createQuery("from Admin where admin_name=? and admin_password=?");
			query.setString(0, name.trim());
			query.setString(1, password.trim());
			admin = (Admin) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return admin;
	}

	public int getCount(Admin ad) throws Exception {
		Query query;

		query = session.createQuery("select count(*) from Admin where status=?");
		query.setLong(0, ad.getStatus());
		Object result = query.uniqueResult();

		return Integer.parseInt(result.toString());

	}

	public int getComputerCount() throws Exception {
		// TODO Auto-generated method stub
		// Query query;
		//
		// query = session.createQuery("select count(*) from Computer");
		// query.setLong(0, ad.getStatus());
		// Object result = query.uniqueResult();
		//
		// return Integer.parseInt(result.toString());

		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(*) from computer_shop";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rs.close();
			ps.close();
		}
		return count;
	}

	public List<Admin> listAdmin(int pageNo, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		Query query;
		query = session.createQuery("from Admin where status=1");

		// 获取根据条件分页查询的总行数
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);

		List<Admin> adminList = query.list();

		return adminList;
	}

	public void updateStatus(Admin ad) throws Exception {
		// TODO Auto-generated method stub
		Query query;

		query = session.createQuery("update Admin set status=? where id=?");
		query.setLong(0, ad.getStatus());
		query.setString(1, ad.getId());

		query.executeUpdate();

	}

	public List<Admin> recycleBinList(int pageNo, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		Query query;
		query = session.createQuery("from Admin where status=0");

		// 获取根据条件分页查询的总行数
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);

		List<Admin> adminList = query.list();

		return adminList;
	}
	public void deleteStatus() throws Exception {
		// TODO Auto-generated method stub
		Query query;
		query = session.createQuery("delete from Admin where status=?");
		query.setLong(0, 0);
		query.executeUpdate();

	}


	@Override
	public void delete(Admin ad) throws Exception {
		// TODO Auto-generated method stub
		session.delete(ad);

	}

	@Override
	public void add(Admin ad) throws Exception {
		// TODO Auto-generated method stub
		session.save(ad);
	}

	@Override
	public void update(Admin ad) throws Exception {
		// TODO Auto-generated method stub
		session.update(ad);

	}

	@Override
	public void setSesstion(Session session) throws Exception {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public Admin getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return (Admin) session.get(Admin.class, id);

	}

	public Admin getPassword(String adminPassword, String adminName) throws Exception {
		// TODO Auto-generated method stub
		Admin admin = null;
		try {
			Query query = session.createQuery("from Admin where admin_name=? and admin_password=?");
			query.setString(0, adminName.trim());
			query.setString(1, adminPassword.trim());
			admin = (Admin) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return admin;

	}

	private Session session = null;

}
