/**
 * 
 */
package com.zmm.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.dao.impl.OrderImpl;
import com.zmm.dao.IOrder;
import com.zmm.pojo.Computer;
import com.zmm.pojo.Order;
import com.zmm.pojo.OrderDetail;
import com.zmm.pojo.ShopCart;
import com.zmm.util.DataBase;

/**
 * @author Administrator
 *
 */
public class OrderService {
	IOrder order = new OrderImpl();

	Connection con = null;

	/*
	 * ͨ��������ŵõ�������Ϣ ������������ţ�Long�� ����ֵ��Order
	 */
	public Order getById(Long id) throws Exception {
		// TODO Auto-generated method stub
		Order o = null;
		try {
			con = DataBase.getConn();
			order.setConnection(con);
			o = order.getById(id);
		} catch (Exception e) {
		} finally {
			DataBase.releaseConnection(con);
		}
		return o;
	}

	/*
	 * ͨ���û�id�õ����� ������userId �û�id ����ֵ��Order
	 */
	public Order OrderById(String userId) throws Exception {
		// TODO Auto-generated method stub
		Order o = null;

		try {
			con = DataBase.getConn();
			order.setConnection(con);
			o = order.OrderById(userId);
		} catch (Exception e) {
		} finally {
			DataBase.releaseConnection(con);
		}
		return o;
	}

	/*
	 * ��Ӷ�����Ϣ ������Order ����List<ShopCart>,userId �޷���ֵ
	 */
	public void addOrder(List<ShopCart> sList, Order o, String userId) throws Exception {
		try {

			con = DataBase.getConn();
			order.setConnection(con);
			// ������Ż�õ�����1970-1-01 00:00:00.000 ����ǰʱ�̵�ʱ�����+�û�id
			Long orderId = System.currentTimeMillis();
			orderId=Long.parseLong(orderId.toString()+userId);
			o.setOrderId(orderId);
			order.addOrder(o);
			List<OrderDetail> lod = new ArrayList<OrderDetail>();
			// ��Ӷ�������
			for (int i = 0; i < sList.size(); i++) {
				ShopCart sc = sList.get(i);
				OrderDetail od = new OrderDetail();
				od.setAccount(sc.getCount());
				od.setBuy_price(sc.getCom().getRel_price());
				Computer com = new Computer();
				com.setCom_id(sc.getCom().getCom_id());
				com.setModel(sc.getCom().getModel());
				od.setCom(com);
				od.setOrder_id(orderId);
				lod.add(od);
				order.addOrderDetail(od);// ����for���棬����ֻ�����һ������
			}

		} catch (Exception e) {
		} finally {
			DataBase.releaseConnection(con);
		}

	}
	
	
	
	/*
	 * ��Ӷ���������Ϣ ������Order ����List<ShopCart>,userId �޷���ֵ
	 */
	public void addOneOrder(ShopCart sc, Order o, String userId) throws Exception {
		try {

			con = DataBase.getConn();
			order.setConnection(con);
			// ������Ż�õ�����1970-1-01 00:00:00.000 ����ǰʱ�̵�ʱ�����+�û�id
			Long orderId = System.currentTimeMillis();
			orderId=Long.parseLong(orderId.toString()+userId);
			o.setOrderId(orderId);
			order.addOrder(o);
			
//			List<OrderDetail> lod = new ArrayList<OrderDetail>();
			// ��Ӷ�������
//			for (int i = 0; i < sList.size(); i++) {
//				ShopCart sc = sList.get(i);
				OrderDetail od = new OrderDetail();
				od.setAccount(sc.getCount());
				od.setBuy_price(sc.getCom().getRel_price());
				Computer com = new Computer();
				com.setCom_id(sc.getCom().getCom_id());
				com.setModel(sc.getCom().getModel());
				od.setCom(com);
				od.setOrder_id(orderId);
//				lod.add(od);
				order.addOrderDetail(od);// ����for���棬����ֻ�����һ������
//			}

		} catch (Exception e) {
		} finally {
			DataBase.releaseConnection(con);
		}

	}

	/*
	 * ɾ��������Ϣ ������Order ���� ����ֵboolean
	 */
	public boolean deleteOrder(Long orderId) throws Exception {
		boolean result = false;
		try {
			con = DataBase.getConn();
			order.setConnection(con);
			result = order.deleteOrder(orderId);
			result = order.deleteOrderDetail(orderId);
		} catch (Exception e) {
		} finally {
			DataBase.releaseConnection(con);
		}
		return result;
	}

	/*
	 * �޸Ķ�����Ϣ ������Order ���� ����ֵboolean
	 */
	public boolean updateOrder(Order o) throws Exception {
		boolean result = false;
		try {
			con = DataBase.getConn();
			order.setConnection(con);
			result = order.updateOrder(o);
		} catch (Exception e) {
		} finally {
			DataBase.releaseConnection(con);
		}
		return result;
	}

	/*
	 * ��ʾ������Ϣ ������pageNo��ǰҳ��ҳ�ţ�pageSizeÿҳ��ʾ�ĸ�����Keyword�ؼ��ֲ�ѯ ����ֵ��List
	 */
	public List<Order> listOrder(int pageNo, int pageSize, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<Order> oList = null;
		try {
			con = DataBase.getConn();
			order.setConnection(con);
			oList = order.listOrder(pageNo, pageSize, keyWord);
		} catch (Exception e) {
		} finally {
			DataBase.releaseConnection(con);
		}
		return oList;
	}

	/*
	 * ͨ���û���Ż�ö�����Ϣ �������û���� ����ֵ��List
	 */

	public List<Order> listOrderByUserId(String userId) throws Exception {
		// TODO Auto-generated method stub
		List<Order> oList = null;
		try {
			con = DataBase.getConn();
			order.setConnection(con);
			oList = order.listOrderByUserId(userId);
		} catch (Exception e) {
		} finally {
			DataBase.releaseConnection(con);
		}
		return oList;
	}

	public List<Order> listMessge() throws Exception {
		// TODO Auto-generated method stub
		List<Order> oList = null;
		try {
			con = DataBase.getConn();
			order.setConnection(con);
			oList = order.listMessge();
		} catch (Exception e) {
		} finally {
			DataBase.releaseConnection(con);
		}
		return oList;
	}

	/*
	 * ͨ�����������ʾ������Ϣ ������������ţ�Long�� ����ֵ��List����
	 */
	public List<OrderDetail> listOrderDetail(Long orderId) throws Exception {
		// TODO Auto-generated method stub
		List<OrderDetail> oList = null;
		try {
			con = DataBase.getConn();
			order.setConnection(con);
			oList = order.listOrderDetail(orderId);
		} catch (Exception e) {
		} finally {
			DataBase.releaseConnection(con);
		}
		return oList;
	}

	/*
	 * ��ö����ܸ��� ����int ���� �������ؼ���keyWord
	 */
	public int getCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			con = DataBase.getConn();
			order.setConnection(con);
			count = order.getCount(keyWord);
		} catch (Exception e) {
		} finally {
			DataBase.releaseConnection(con);
		}

		return count;
	}

	/*
	 * ��ʾ��Ʒ������� List �������� ����List����
	 */
	public List<OrderDetail> sale() throws Exception {
		// TODO Auto-generated method stub

		List<OrderDetail> cList = null;

		try {
			con = DataBase.getConn();
			order.setConnection(con);
			cList = order.sale();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBase.releaseConnection(con);
		}
		return cList;
	}

}
