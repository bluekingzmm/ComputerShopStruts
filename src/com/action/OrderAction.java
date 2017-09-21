package com.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zmm.pojo.Order;
import com.zmm.pojo.OrderDetail;
import com.zmm.pojo.ShopCart;
import com.zmm.pojo.User;
import com.zmm.service.ComputerService;
import com.zmm.service.OrderService;
import com.zmm.service.ShopCartService;
import com.zmm.service.UserService;

public class OrderAction extends BaseAction {

	private int pageNo = 1;
	private Order order;
	private String isPay, isDeliver, orderId, userName,label;
	private int comId;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getComId() {
		return comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getIsPay() {
		return isPay;
	}

	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}

	public String getIsDeliver() {
		return isDeliver;
	}

	public void setIsDeliver(String isDeliver) {
		this.isDeliver = isDeliver;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	OrderService os = new OrderService();

	/*
	 * ��̨�����б�
	 */
	public String list() throws Exception {
		int pageSize = 3, count = 0;
		boolean flag = false;
		String keyWord;
		StringBuffer sbf = null;
		List<Order> oList = null;
		try {
			sbf = new StringBuffer();
			if (isPay != null && !isPay.equals("")) {
				sbf.append(" ispay =' ");
				sbf.append(isPay);
				sbf.append(" '");
				flag = true;
			}
			if (isDeliver != null && !isDeliver.equals("")) {

				sbf.append(" isdeliver =' ");
				sbf.append(isDeliver);
				sbf.append(" '");
				flag = true;
			}
			if (orderId != null && !orderId.equals("")) {
				sbf.append(" order_id like '%");
				sbf.append(orderId);
				sbf.append("%'");
				flag = true;
			}
			if (userName != null && !userName.equals("")) {
				sbf.append(" user_name like '%");
				sbf.append(userName);
				sbf.append("%'");
				flag = true;
			}

			if (flag) {
				keyWord = "where";

			} else {
				keyWord = "";
			}
			if (sbf.toString().equals("")) {
				oList = os.listOrder(pageNo, pageSize, keyWord);
				count = os.getCount(keyWord);
			} else {
				oList = os.listOrder(pageNo, pageSize, keyWord + sbf.toString());
				count = os.getCount(keyWord + sbf.toString());
			}
			request.setAttribute("oList", oList);
			int totalPage = (int) Math.ceil((double) count / pageSize);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("count", count);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("totalPage", totalPage);
			return "list";

		} catch (

		Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return "error";
	}
	/*
	 * ǰ̨�����б�
	 */

	public String listInfo() throws Exception {
		User u = null;
		List<Order> ol = null;
		try {
			u = (User) session.get("userInfo");
			ol = os.listOrderByUserId(u.getUser_id());
			request.setAttribute("ol", ol);
			return "listInfo";
		} catch (

		Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		return "error";
	}

	/*
	 * ��̨��������
	 */
	public String show() throws Exception {
		List<OrderDetail> oList = null;
		try {
			order = os.getById(order.getOrderId());
			oList = os.listOrderDetail(order.getOrderId());
			request.setAttribute("ol", oList);
			request.setAttribute("od", order);
			return "listDetailOrder";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return "error";
	}


	/*
	 * ��̨��������
	 */
	public String updateDeliver() throws Exception {
		try {
			if (order != null) {
				order = os.getById(order.getOrderId());
				order.setIsDeliver(1);
				if (os.updateOrder(order)) {
					return "orderList";
				} else {
					return "orderList";
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return "error";
	}

	/*
	 * �޸�֧��״̬
	 */
	public String updatePay() throws Exception {
		try {
			if (order != null) {
				order = os.getById(order.getOrderId());
				order.setIsPay(1);
				if (os.updateOrder(order)) {
					return "orderInfoList";
				} else {
					return "orderInfoList";
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return "error";
	}

	/*
	 * ǰ̨ȡ������
	 */
	public String delete() throws Exception {
		try {
			if (order != null) {
				os.deleteOrder(order.getOrderId());
				return "orderInfoList";
			} else {
				return "orderInfoList";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return "error";
	}
	/*
	 * ��̨������ʾ
	 */

	public String sale() throws Exception {
		List<OrderDetail> oList = null;
		try {
			oList = os.sale();
			request.setAttribute("oList", oList);
			return "sale";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

	/*
	 * ����ͼ��
	 */

	public String echarts() throws Exception {
		try {
			return "echart";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		return "error";
	}
	/*
	 * ������Ʒ��ӵ�����
	 */

	public String addOne() throws Exception {
		UserService us = new UserService();
		ShopCartService scs = null;
		User u = (User) session.get("userInfo");
		ComputerService cs = null;
		try {
			cs = new ComputerService();
			scs = new ShopCartService();
			ShopCart sc = scs.getById(session, comId);// ��ö���
			// ����û�
			User user = us.getById(u.getUser_id());
			order.setUser(user);
			// �õ��ܼ۸�
			if (order.getTotalPrice() >= 5000) {
				order.setTotalPrice(order.getTotalPrice() - 100);// �Ż�100Ԫ
			} else {
				order.setTotalPrice(order.getTotalPrice());

			}
			order.setIsDeliver(0);
			order.setIsPay(0);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = new Date();
			String d = dateFormat.format(date);// ��ϵͳ��ǰʱ���ʽ��
			Date submitTime = java.sql.Date.valueOf(d);
			order.setSubmitTime(submitTime);
			
			cs.updateSubCount(session);
			os.addOneOrder(sc, order, order.getUser().getUser_id());
			// ɾ�����ﳵ
			scs.deleteShopCart(session, comId);
			return "orderInfoList";

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return "error";
	}

	/*
	 * ȫ�����㹺�ﳵ
	 */

	public String add() throws Exception {
		UserService us = new UserService();
		ShopCartService scs = null;
		ShopCart s = null;
		User u = (User) session.get("userInfo");
		System.out.println("u"+u);
		ComputerService cs = null;
		try {
			cs = new ComputerService();
			scs = new ShopCartService();
			List<ShopCart> sList = new ArrayList<ShopCart>(scs.getShopCart(session));
			// ����û�
			Order o = new Order();
			User user = us.getById(u.getUser_id());
			o.setUser(user);
			o.setIsDeliver(0);
			o.setIsPay(0);
			double totalPrice = 0.0;
			for (int i = 0; i < sList.size(); i++) {
				s = sList.get(i);
				totalPrice += s.getCom().getRel_price() * s.getCount();

			}
			// �õ��ܼ۸�
			if (totalPrice >= 5000) {
				o.setTotalPrice(totalPrice - 100);// �Ż�100Ԫ

			} else {
				o.setTotalPrice(totalPrice);

			}
			// �����ύ����ʱ��
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = new Date();
			String d = dateFormat.format(date);// ��ϵͳ��ǰʱ���ʽ��
			Date submitTime = java.sql.Date.valueOf(d);
			o.setSubmitTime(submitTime);
			cs.updateSubCount(session);
			os.addOrder(sList, o, u.getUser_id());
			scs.clearShopCart(session);
			return "orderInfoList";

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		return "error";
	}

	/*
	 * ��̨��ʾ��Ϣ
	 */

	public String listMessage() throws Exception {
		List<Order> ol = null;
		try {
			ol = os.listMessge();
			request.setAttribute("oList", ol);
			return "message";
		} catch (

		Exception e) {
			e.printStackTrace();
		}

		return "error";
	}
	/*
	 * ��̨ɾ����Ϣ
	 */

	public String deleteMessage() throws Exception {
		try {
			if (os.updateOrder(order)) {
				return "messageInfoList";
			} else {
				return "messageInfoList";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

	/*
	 * ǰ̨������Ϣ
	 */
	public String updateService() throws Exception {
		try {
			order.setTx(1);
			order.setStatus(1);
			if (os.updateOrder(order)) {
				return "orderInfoList";
			} else {
				return "orderInfoList";
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return "error";
	}
}
