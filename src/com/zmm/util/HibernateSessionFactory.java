package com.zmm.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateSessionFactory {

	private static final SessionFactory sessionFactory=buildSessionFactory();
	private static SessionFactory buildSessionFactory(){
		try {
			//��ȡhibernate.cfg.xml�����ļ�
			Configuration cfg=new Configuration().configure();
			//����ͨ��
			return cfg.buildSessionFactory();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void main(String[] args)throws Exception{
		Configuration cfg=new Configuration();
		SchemaExport export=new SchemaExport(cfg);
		export.create(true, true);

	}
}
