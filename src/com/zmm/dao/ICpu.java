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
	 * ���ܣ�����cpu����
	 */
//	public boolean addCpu(Cpu c) throws Exception;
	public void addCpu(Cpu c) throws Exception;

	/*
	 * ���ܣ�ɾ��cpu����
	 */

//	public boolean deleteCpu(int id) throws Exception;
	public void deleteCpu(Cpu c) throws Exception;

	/*
	 * ���ܣ��޸�cpu����
	 */

//	public boolean modifyCpu(Cpu c) throws Exception;
	public void modifyCpu(Cpu c) throws Exception;

	/*
	 * ���ܣ�cpu�б�
	 */
	public List<Cpu> listCpu() throws Exception;
	
	/*
	 * ͨ��id�ҵ�
	 */
	
	public Cpu getCpu(int id) throws Exception;
}
