/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.zmm.dao.ICpu;
import com.zmm.pojo.Cpu;
import com.zmm.util.DataBase;

/**
 * @author Administrator
 *
 */
public class CpuImpl extends DataBase implements ICpu {

	private Session session;

	@Override
	public void setSesstion(Session session) throws Exception {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public void addCpu(Cpu c) throws Exception {
		// TODO Auto-generated method stub
		session.save(c);
	}

	@Override
	public void deleteCpu(Cpu c) throws Exception {
		// TODO Auto-generated method stub
		session.delete(c);
	}

	@Override
	public void modifyCpu(Cpu c) throws Exception {
		// TODO Auto-generated method stub
		session.update(c);
	}

	@Override
	public List<Cpu> listCpu() throws Exception {
		// TODO Auto-generated method stub
		return session.createQuery("from Cpu").list();
	}

	@Override
	public Cpu getCpu(int id) throws Exception {
		// TODO Auto-generated method stub
		return (Cpu) session.get(Cpu.class, id);
	}

	

}
