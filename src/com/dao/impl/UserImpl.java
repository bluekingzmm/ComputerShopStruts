/**
 * 
 */
package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zmm.dao.IUser;
import com.zmm.pojo.User;
import com.zmm.util.DataBase;

/**
 * @author Administrator
 *
 */
public class UserImpl implements IUser {
	Connection con = null;

	/*
	 * (non-Javadoc) �������ݿ�����
	 * 
	 * @see com.zmm.dao.IUser#setConnection(java.sql.Connection)
	 */
	public void setConnection(Connection con) throws Exception {
		this.con = con;
	}

	/*
	 * (non-Javadoc) �û�ע����Ϣ
	 * 
	 * @see com.zmm.dao.IUser#add(com.zmm.dto.User)
	 */
	// public boolean add(User user) throws Exception {
	// // TODO Auto-generated method stub
	// PreparedStatement ps = null;
	// try {
	// ps = con.prepareStatement(
	// "insert into user_info (user_password,
	// phone,address,mail,rel_name,user_name,sex,Id,reg_time,code,age)
	// values(?,?,?,?,?,?,?,?,?,?,?) ");
	// ps.setString(1, user.getUser_password());
	// ps.setString(2, user.getPhone());
	// ps.setString(3, user.getAddress());
	// ps.setString(4, user.getMail());
	// ps.setString(5, user.getRel_name());
	// ps.setString(6, user.getUser_name());
	// ps.setString(7, user.getSex());
	// ps.setString(8, user.getId());
	// java.sql.Date reg_time = (java.sql.Date) user.getReg_time();
	// ps.setDate(9, reg_time);
	// ps.setString(10, user.getCode());
	// ps.setInt(11, user.getAge());
	// if (ps.executeUpdate() > 0) {
	// DataBase.commit();
	// return true;
	// }
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// DataBase.rollback();
	// } finally {
	// ps.close();
	// }
	//
	// return false;
	// }
	public void add(User user) throws Exception {
		// TODO Auto-generated method stub
		session.save(user);
	}

	public void modifyOwn(User user) throws Exception {
		// TODO Auto-generated method stub
		session.update(user);

	}

	/*
	 * (non-Javadoc) ����ɾ���û���Ϣ
	 * 
	 * @see com.zmm.dao.IUser#delete(int)
	 */
	// public boolean delete(String userId) throws Exception {
	// PreparedStatement ps = null;
	// try {
	// ps = con.prepareStatement("delete from user_info where user_id=?");
	// ps.setString(1, userId);
	// if (ps.executeUpdate() > 0) {
	// DataBase.commit();
	// return true;
	// }
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// DataBase.rollback();
	// } finally {
	// ps.close();
	// }
	//
	// return false;
	// }
	public void delete(User user) throws Exception {
		// TODO Auto-generated method stub
		session.delete(user);

	}
	/*
	 * (non-Javadoc) �޸��û���Ϣ
	 * 
	 * @see com.zmm.dao.IUser#modifyOwn(com.zmm.dto.User)
	 */
	// public boolean modifyOwn(User user) throws Exception {
	// // TODO Auto-generated method stub
	// PreparedStatement ps = null;
	// try {
	// ps = con.prepareStatement(
	// "update user_info set
	// phone=?,address=?,mail=?,rel_name=?,age=?,Id=?,code=?,status=? where
	// user_name=?");
	// ps.setString(1, user.getPhone());
	// ps.setString(2, user.getAddress());
	// ps.setString(3, user.getMail());
	// ps.setString(4, user.getRel_name());
	// ps.setInt(5, user.getAge());
	// ps.setString(6, user.getId());
	// ps.setString(7, user.getCode());
	// ps.setInt(8, user.getStatus());
	// ps.setString(9, user.getUser_name());
	//
	// if (ps.executeUpdate() > 0) {
	// DataBase.commit();
	// return true;
	// }
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// DataBase.rollback();
	// } finally {
	// ps.close();
	// }
	//
	// return false;
	// }

	/*
	 * (non-Javadoc) ͨ��id�õ��û���Ϣ
	 * 
	 * @see com.zmm.dao.IUser#getById(int)
	 */
	public User getById(String userId) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		User user = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select * from user_info where user_id=?");
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setAddress(rs.getString("address"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setCode(rs.getString("code"));
				user.setMail(rs.getString("mail"));
				user.setPhone(rs.getString("phone"));
				user.setRel_name(rs.getString("rel_name"));
				user.setUser_id(rs.getString("user_id"));
				user.setReg_time(rs.getDate("reg_time"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setId(rs.getString("Id"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			rs.close();
			ps.close();
		}
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#listUser(int, int) ��ʾ�û���Ϣ
	 */
	// public List<User> listUser(int pageNo, int pageSize) throws Exception {
	// // TODO Auto-generated method stub
	// PreparedStatement ps = null;
	// List<User> uList = null;
	// User user = null;
	// ResultSet rs = null;
	// try {
	// ps = con.prepareStatement("select * from user_info where status=? limit
	// ?,?");
	// ps.setInt(1, 1);
	// ps.setInt(2, (pageNo - 1) * pageSize);
	// ps.setInt(3, pageSize);
	// rs = ps.executeQuery();
	// uList = new ArrayList<User>();
	// while (rs.next()) {
	// user = new User();
	// user.setAddress(rs.getString("address"));
	// user.setUser_name(rs.getString("user_name"));
	// user.setCode(rs.getString("code"));
	// user.setMail(rs.getString("mail"));
	// user.setPhone(rs.getString("phone"));
	// user.setRel_name(rs.getString("rel_name"));
	// user.setUser_id(rs.getString("user_id"));
	// user.setReg_time(rs.getDate("reg_time"));
	// user.setSex(rs.getString("sex"));
	// user.setAge(rs.getInt("age"));
	// user.setId(rs.getString("Id"));
	// user.setUser_password(rs.getString("user_password"));
	//
	// uList.add(user);
	// }
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// } finally {
	// rs.close();
	// ps.close();
	// }
	// return uList;
	// }
	public List<User> listUser(int pageNo, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("impl");
		Query query;
		query = session.createQuery("from User where status=1");
		// ��ȡ����������ҳ��ѯ��������
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);

		List<User> userList = query.list();
		System.out.println("impl"+userList.toString());
		return userList;
	}

	/*
	 * (non-Javadoc) �û���¼
	 * 
	 * @see com.zmm.dao.IUser#login(java.lang.String, java.lang.String)
	 */
	// public User login(String userName, String userPassword) throws Exception
	// {
	// // TODO Auto-generated method stub
	// PreparedStatement ps = null;
	// ResultSet rs = null;
	// User user = null;
	// try {
	//
	// ps = con.prepareStatement("select * from user_info where user_name=? and
	// user_password=?");
	// ps.setString(1, userName);
	// ps.setString(2, userPassword);
	// rs = ps.executeQuery();
	// if (rs.next()) {
	// user = new User();
	// user.setAddress(rs.getString("address"));
	// user.setUser_name(rs.getString("user_name"));
	// user.setCode(rs.getString("code"));
	// user.setMail(rs.getString("mail"));
	// user.setPhone(rs.getString("phone"));
	// user.setRel_name(rs.getString("rel_name"));
	// user.setUser_id(rs.getString("user_id"));
	// user.setReg_time(rs.getDate("reg_time"));
	// user.setAge(rs.getInt("age"));
	// user.setId(rs.getString("Id"));
	// user.setStatus(rs.getInt("status"));
	//
	// }
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// } finally {
	// rs.close();
	// ps.close();
	// }
	// return user;
	// }
	public User login(String userName, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		User user = null;
		try {
			Query query = session.createQuery("from User where user_name=? and user_password=?");
			query.setString(0, userName.trim());
			query.setString(1, userPassword.trim());
			user = (User) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return user;
	}

	/*
	 * (non-Javadoc) �õ��û�����
	 * 
	 * @see com.zmm.dao.IUser#getUserCount()
	 */
	// public int getUserCount(User user) throws Exception {
	// // TODO Auto-generated method stub
	// PreparedStatement ps = null;
	// ResultSet rs = null;
	// int count = 0;
	// try {
	// ps = con.prepareStatement("select count(*) from user_info where
	// status=?");
	// ps.setInt(1, user.getStatus());
	// rs = ps.executeQuery();
	// if (rs.next()) {
	// return rs.getInt(1);
	// }
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// } finally {
	// rs.close();
	// ps.close();
	// }
	// return count;
	// }
	public int getUserCount(User user) throws Exception {
		Query query;

		query = session.createQuery("select count(*) from User where status=?");
		query.setLong(0, user.getStatus());
		Object result = query.uniqueResult();

		return Integer.parseInt(result.toString());

	}

	/*
	 * (non-Javadoc) �޸��û�״̬
	 * 
	 * @see com.zmm.dao.IUser#updateStatus(com.zmm.dto.Admin)
	 */
	// public boolean updateStatus(User user) throws Exception {
	// // TODO Auto-generated method stub
	// PreparedStatement ps = null;
	// try {
	// ps = con.prepareStatement("update user_info set status=? where
	// user_id=?");
	// ps.setInt(1, user.getStatus());
	// ps.setString(2, user.getUser_id());
	// if (ps.executeUpdate() > 0) {
	// DataBase.commit();
	// return true;
	// }
	//
	// } catch (Exception e) {
	// DataBase.rollback();
	// } finally {
	// ps.close();
	// }
	// return false;
	// }
	public void updateStatus(User user) throws Exception {
		// TODO Auto-generated method stub
		Query query;

		query = session.createQuery("update User set status=? where user_id=?");
		query.setLong(0, user.getStatus());
		query.setString(1, user.getUser_id());
		query.executeUpdate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#updatePsw(java.lang.String, java.lang.String)
	 * �û��޸�����
	 */
//	public boolean updatePsw(String userPassword, String userName) throws Exception {
//		// TODO Auto-generated method stub
//		PreparedStatement ps = null;
//		try {
//			ps = con.prepareStatement("update user_info set user_password=? where user_name=?");
//			ps.setString(1, userPassword);
//			ps.setString(2, userName);
//			if (ps.executeUpdate() > 0) {
//				DataBase.commit();
//				return true;
//			}
//
//		} catch (Exception e) {
//			DataBase.rollback();
//		} finally {
//			ps.close();
//		}
//		return false;
//	}
	public void updatePsw(String userPassword, String userName) throws Exception {
		// TODO Auto-generated method stub
		Query query;
		query = session.createQuery("update User set user_password=? where user_name=?");
		query.setString(0, userPassword);
		query.setString(1, userName);
		query.executeUpdate();

	}

	/*
	 * (non-Javadoc) ����վ�б�
	 * 
	 * @see com.zmm.dao.IUser#recycleBinList(int, int)
	 */
	// public List<User> recycleBinList(int pageNo, int pageSize, User u) throws
	// Exception {
	// // TODO Auto-generated method stub
	// PreparedStatement ps = null;
	// List<User> uList = null;
	// User user = null;
	// ResultSet rs = null;
	// try {
	// ps = con.prepareStatement("select * from user_info where status=? limit
	// ?,?");
	// ps.setInt(1, u.getStatus());
	// ps.setInt(2, (pageNo - 1) * pageSize);
	// ps.setInt(3, pageSize);
	// rs = ps.executeQuery();
	// uList = new ArrayList<User>();
	// while (rs.next()) {
	// user = new User();
	// user.setUser_id(rs.getString("user_id"));
	// user.setAddress(rs.getString("address"));
	// user.setCode(rs.getString("code"));
	// user.setUser_name(rs.getString("user_name"));
	// user.setMail(rs.getString("mail"));
	// user.setPhone(rs.getString("phone"));
	// user.setRel_name(rs.getString("rel_name"));
	// user.setReg_time(rs.getDate("reg_time"));
	// user.setSex(rs.getString("sex"));
	// user.setAge(rs.getInt("age"));
	// user.setId(rs.getString("Id"));
	// user.setUser_password(rs.getString("user_password"));
	// uList.add(user);
	// }
	// } catch (Exception e) {
	// // TODO: handle exception
	// } finally {
	// rs.close();
	// ps.close();
	// }
	// return uList;
	// }
	public List<User> recycleBinList(int pageNo, int pageSize, User u) throws Exception {
		// TODO Auto-generated method stub
		Query query;
		query = session.createQuery("from User where status=?");
		query.setLong(0, u.getStatus());
		// ��ȡ����������ҳ��ѯ��������
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);

		List<User> userList = query.list();

		return userList;
	}

	/*
	 * (non-Javadoc) �����û���Ϣ
	 * 
	 * @see com.zmm.dao.IUser#deleteStatus()
	 */
	// public boolean deleteStatus() throws Exception {
	// // TODO Auto-generated method stub
	// PreparedStatement ps = null;
	// try {
	// ps = con.prepareStatement("delete from user_info where status=?");
	// ps.setInt(1, -1);
	// if (ps.executeUpdate() > 0) {
	// DataBase.commit();
	// return true;
	// }
	//
	// } catch (Exception e) {
	// DataBase.rollback();
	// } finally {
	// ps.close();
	// }
	// return false;
	// }
	public void deleteStatus() throws Exception {
		// TODO Auto-generated method stub
		Query query;
		query = session.createQuery("delete from User where status=?");
		query.setLong(0, 0);
		query.executeUpdate();

	}

	/*
	 * (non-Javadoc) ��ȡ�û���������
	 * 
	 * @see com.zmm.dao.IUser#getPassword(java.lang.String, java.lang.String)
	 */
	public User getPassword(String userPassword, String userName) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		User user = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select * from user_info where user_name=? and user_password=?");
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setAddress(rs.getString("address"));
				user.setUser_name(rs.getString("user_name"));
				user.setCode(rs.getString("code"));
				user.setMail(rs.getString("mail"));
				user.setPhone(rs.getString("phone"));
				user.setRel_name(rs.getString("rel_name"));
				user.setUser_id(rs.getString("user_id"));
				user.setReg_time(rs.getDate("reg_time"));
				user.setAge(rs.getInt("age"));
				user.setId(rs.getString("Id"));
				user.setUser_password(rs.getString("user_password"));

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			rs.close();
			ps.close();
		}
		return user;
	}

	public List<User> search(String keyword) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		List<User> uList = null;
		try {
			ps = con.prepareStatement("select * from user_info where user_name like ? ");
			ps.setString(1, "%" + keyword + "%");
			rs = ps.executeQuery();
			uList = new ArrayList<User>();
			while (rs.next()) {
				user = new User();
				user.setAddress(rs.getString("address"));
				user.setUser_name(rs.getString("user_name"));
				user.setCode(rs.getString("code"));
				user.setMail(rs.getString("mail"));
				user.setPhone(rs.getString("phone"));
				user.setRel_name(rs.getString("rel_name"));
				user.setUser_id(rs.getString("user_id"));
				user.setReg_time(rs.getDate("reg_time"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setId(rs.getString("Id"));
				uList.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			rs.close();
			ps.close();
		}
		return uList;
	}

	/*
	 * ��ѯ�û������ж��Ƿ�ע���
	 */
	public boolean searchUsername(String userName) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select user_id  from user_info where user_name=?");
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()) {

				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			rs.close();
			ps.close();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#searchMailName(java.lang.String) ������ʱ��ѯ�����ַ�Ƿ����
	 */
	public boolean searchMailName(String mail) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select mail  from user_info where mail=?");
			ps.setString(1, mail);
			rs = ps.executeQuery();
			if (rs.next()) {

				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			rs.close();
			ps.close();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zmm.dao.IUser#searchUserName(java.lang.String) �������Ƿ񼤻�
	 */
	public User searchMail(String mail, String userName) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;

		try {
			ps = con.prepareStatement("select *  from user_info where mail=? and user_name=?");
			ps.setString(1, mail);
			ps.setString(2, userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setAddress(rs.getString("address"));
				user.setUser_name(rs.getString("user_name"));
				user.setCode(rs.getString("code"));
				user.setMail(rs.getString("mail"));
				user.setPhone(rs.getString("phone"));
				user.setRel_name(rs.getString("rel_name"));
				user.setUser_id(rs.getString("user_id"));
				user.setReg_time(rs.getDate("reg_time"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setId(rs.getString("Id"));
				user.setUser_password(rs.getString("user_password"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			rs.close();
			ps.close();
		}
		return user;
	}

	/*
	 * �ʺż���
	 */
	public User active(String code) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		User user = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select * from user_info where code=?");
			ps.setString(1, code);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setAddress(rs.getString("address"));
				user.setCode(rs.getString("code"));
				user.setUser_name(rs.getString("user_name"));
				user.setMail(rs.getString("mail"));
				user.setPhone(rs.getString("phone"));
				user.setRel_name(rs.getString("rel_name"));
				user.setUser_id(rs.getString("user_id"));
				user.setReg_time(rs.getDate("reg_time"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setUser_password(rs.getString("user_password"));
				user.setId(rs.getString("Id"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			rs.close();
			ps.close();
		}
		return user;
	}

	public void setSesstion(Session session) throws Exception {
		// TODO Auto-generated method stub
		this.session = session;
	}

	private Session session = null;

}
