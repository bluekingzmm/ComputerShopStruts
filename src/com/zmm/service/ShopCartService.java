/**
 * 
 */
package com.zmm.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.zmm.pojo.Computer;
import com.zmm.pojo.ShopCart;

/**
 * @author Administrator
 *
 */
public class ShopCartService {
	protected ActionContext context=ActionContext.getContext();
	protected Map<String, Object> session=context.getSession();
	/*
	 * �����Ʒid ��ӹ��ﳵ��Ϣ��0���ʧ�ܣ�1�����Ʒ�ɹ���2��Ʒ�Ѿ�����
	 */
	@SuppressWarnings("unchecked")
	public StringBuffer addShopCart(int comId, Map<String, Object> session) {
		Computer com = null;
	
		ComputerService coms = null;
		StringBuffer sbf = new StringBuffer();
		try {
			// ��õ���id�õ���Ϣ
			coms = new ComputerService();
			com = coms.get(comId);
			// ��װ���ﳵ��Ϣ
			ShopCart sc = new ShopCart();
			com.setBrand(com.getBrand());
			sc.setCom(com);
			sc.setCom_id(com.getCom_id());
			// Ĭ�Ϲ�������Ϊ1
			sc.setCount(1);
			// �����ﳵ�����set���Ͻӿ���
			Set<ShopCart> shopCart = null;
			// �жϹ��ﳵ�Ƿ�Ϊ�գ�
//			if (session.getAttribute("ShopCart") == null) {
//				// ����һ�����ﳵ
//				shopCart = new HashSet<ShopCart>();
//				shopCart.add(sc);// ��ӵ�set������
//				// ����ӵĹ��ﳵ���Ϸŵ�session��
//				session.setAttribute("ShopCart", shopCart);
//				return sbf.append("�����Ѿ���ӵ����ﳵ�У����Ժ����ҵĹ��ﳵ�鿴...");
//			} else {
//				// ���ﳵ��Ϊ�գ��ж��Ƿ���ͬ����Hashset���ϣ���дequale��hashcode����
//				shopCart = (HashSet<ShopCart>) session.getAttribute("ShopCart");
//				if (shopCart.add(sc)) {
//					return sbf.append("�����Ѿ���ӵ����ﳵ�У����Ժ����ҵĹ��ﳵ�鿴...");
//				} else {
//
//					return sbf.append("�����Ѿ��ڹ��ﳵ��...");
//				}
//			}
			if (session.get("ShopCart") == null) {
			// ����һ�����ﳵ
			shopCart = new HashSet<ShopCart>();
			shopCart.add(sc);// ��ӵ�set������
			// ����ӵĹ��ﳵ���Ϸŵ�session��
			session.put("ShopCart", shopCart);
//			session.setAttribute("ShopCart", shopCart);
			return sbf.append("�����Ѿ���ӵ����ﳵ�У����Ժ����ҵĹ��ﳵ�鿴...");
		} else {
			// ���ﳵ��Ϊ�գ��ж��Ƿ���ͬ����Hashset���ϣ���дequale��hashcode����
			shopCart = (HashSet<ShopCart>) session.get("ShopCart");
			if (shopCart.add(sc)) {
				return sbf.append("�����Ѿ���ӵ����ﳵ�У����Ժ����ҵĹ��ﳵ�鿴...");
			} else {

				return sbf.append("�����Ѿ��ڹ��ﳵ��...");
			}
		}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return sbf.append("ϵͳ��æ�����ʧ�ܣ�...");
	}

	/*
	 * �õ����ﳵ��Ϣ(����)
	 */
	@SuppressWarnings("unchecked")
	public HashSet<ShopCart> getShopCart(Map<String, Object> session) {
		if (session.get("ShopCart") != null) {
			return (HashSet<ShopCart>) session.get("ShopCart");
		} else {
			return null;
		}

	}
	public ShopCart getById(Map<String, Object> session,int id){
		Set<ShopCart> setShopCart = getShopCart(session);
		if (setShopCart != null) {
			for (ShopCart shopCart : setShopCart) 
				if(shopCart.getCom_id()==id)
					return shopCart;
				
				}
			
		return null;

	
	}

	/*
	 * ���ݵ���id����ɾ��
	 */
	@SuppressWarnings("unchecked")
	public void deleteShopCart(Map<String, Object> session, int id) {
		Set<ShopCart> shopCartSet = (HashSet<ShopCart>) session.get("ShopCart");
		ShopCart sc = new ShopCart();
		sc.setCom_id(id);
		shopCartSet.remove(sc);

		session.put("ShopCart", shopCartSet);
	}

	/*
	 * ������ﳵ
	 */
	public void clearShopCart(Map<String, Object> session) {
		if (session.get("ShopCart") != null)
//			session.removeAttribute("ShopCart");
			session.remove("ShopCart");
	}

	/*
	 * �޸Ĺ�������
	 */
	public boolean updateCount(int count, int comId, Map<String, Object> session) {
		Set<ShopCart> setShopCart = getShopCart(session);
		boolean result = false;
		if (setShopCart != null) {
			for (ShopCart shopCart : setShopCart) {
				if(shopCart.getCom_id()==comId){
					shopCart.setCount(count);
					result = true;
				}
			}
			
		}

		return result;
	}

}
