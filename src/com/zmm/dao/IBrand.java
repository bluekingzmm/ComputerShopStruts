package com.zmm.dao;

import java.util.List;

import org.hibernate.Session;

import com.zmm.pojo.Brand;

public interface IBrand {
	
	public void setSesstion(Session session) throws Exception;
//	public void setConnection(Connection con) throws Exception;

	/*
	 * 功能：增加品牌名称
	 */
//	public boolean addBrand(Brand b) throws Exception;
	public void addBrand(Brand b) throws Exception;

	/*
	 * 功能：删除品牌名称
	 */

//	public boolean deleteBrand(int id) throws Exception;

	public void deleteBrand(Brand b) throws Exception;

	/*
	 * 功能：修改品牌名称
	 */

//	public boolean modifyBrand(Brand b) throws Exception;

	public void modifyBrand(Brand b) throws Exception;

	/*
	 * 功能：品牌列表
	 */
	public List<Brand> listBrand() throws Exception;
	
	
	/*
	 * 功能：获取品牌id
	 */
	public Brand getBrand(int id) throws Exception;
}
