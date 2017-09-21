package com.zmm.dao;

import java.sql.Connection;
import java.util.List;

import com.zmm.pojo.Order;
import com.zmm.pojo.OrderDetail;

public interface IOrder {

	/*
	 * ��������
	 */
	public void setConnection(Connection con) throws Exception;

	/*
	 * ͨ��id��ö�����Ϣ
	 */

	public Order getById(Long id) throws Exception;

	/*
	 * ��Ӷ���
	 */

	public boolean addOrder(Order o) throws Exception;

	/*
	 * ��Ӷ�������
	 */

	
	public boolean addOrderDetail(OrderDetail od) throws Exception;

	/*
	 * ɾ������
	 */

	public boolean deleteOrder(Long orderId) throws Exception;
	/*
	 * ɾ����������
	 */

	public boolean deleteOrderDetail(Long orderId) throws Exception;

	/*
	 * �޸Ķ���
	 */
	public boolean updateOrder(Order o) throws Exception;

	/*
	 * ͨ��������ŵõ�������Ϣ
	 */

	public Order OrderById(String userId) throws Exception;
	/*
	 * �����б���ʾ
	 */

	public List<Order> listOrder(int pageNo, int pageSize, String keyWord) throws Exception;
	
	/*
	 * ͨ���û����ȡ������Ϣ
	 */
	public List<Order> listOrderByUserId(String userId) throws Exception;

	/*
	 * ��ȡ��������
	 * 
	 */

	public int getCount(String keyWord) throws Exception;

	/*
	 * ���������б�
	 */
	public List<OrderDetail> listOrderDetail(Long orderId) throws Exception;
	

	
	/*
	 * ��������
	 */
	public List<OrderDetail> sale() throws Exception;
	
	
	
	/*
	 * ��ʾ��Ϣ����
	 */
	public List<Order> listMessge() throws Exception;
	
}
