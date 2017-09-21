/**
 * 
 */
package com.zmm.dao;

import java.util.List;

import org.hibernate.Session;

import com.zmm.pojo.Cpu;

/**
 * @author Administrator
 *
 */
public interface ICpu {
	
	public void setSesstion(Session session) throws Exception;

//	public void setConnection(Connection con) throws Exception;
	/*
	 * 功能：增加cpu名称
	 */
//	public boolean addCpu(Cpu c) throws Exception;
	public void addCpu(Cpu c) throws Exception;

	/*
	 * 功能：删除cpu名称
	 */

//	public boolean deleteCpu(int id) throws Exception;
	public void deleteCpu(Cpu c) throws Exception;

	/*
	 * 功能：修改cpu名称
	 */

//	public boolean modifyCpu(Cpu c) throws Exception;
	public void modifyCpu(Cpu c) throws Exception;

	/*
	 * 功能：cpu列表
	 */
	public List<Cpu> listCpu() throws Exception;
	
	/*
	 * 通过id找到
	 */
	
	public Cpu getCpu(int id) throws Exception;
}
