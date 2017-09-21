/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.zmm.dao.IBrand;
import com.zmm.pojo.Admin;
import com.zmm.pojo.Brand;
import com.zmm.util.DataBase;

/**
 * @author Administrator
 *
 */
public class BrandImpl extends DataBase implements IBrand {

	private Session session=null;
	public void setSesstion(Session session) throws Exception{
		this.session=session;
	}

	@Override
	public void addBrand(Brand b) throws Exception {
		// TODO Auto-generated method stub
		session.save(b);
	}

	@Override
	public void deleteBrand(Brand b) throws Exception {
		// TODO Auto-generated method stub
		session.delete(b);
	}

	@Override
	public void modifyBrand(Brand b) throws Exception {
		// TODO Auto-generated method stub
		session.update(b);
	}


	@Override
	public List<Brand> listBrand() throws Exception {
		// TODO Auto-generated method stub
		return session.createQuery("from Brand").list();
	}

	@Override
	public Brand getBrand(int id) throws Exception {
		// TODO Auto-generated method stub
		return (Brand)session.get(Brand.class, id);
	}

}
