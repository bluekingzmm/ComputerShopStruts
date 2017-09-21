package com.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.zmm.pojo.Computer;
import com.zmm.pojo.ShopCart;
import com.zmm.service.ComputerService;
import com.zmm.service.ShopCartService;

public class ShopCartAction extends BaseAction {

	private ShopCart sc;

	public ShopCart getSc() {
		return sc;
	}

	public void setSc(ShopCart sc) {
		this.sc = sc;
	}

	ShopCartService scs = new ShopCartService();

	/*
	 * 添加到购物车
	 */

	public void add() throws Exception {
		StringBuffer sbf = new StringBuffer();
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			sbf = scs.addShopCart(sc.getCom_id(), session);
			if (sbf.length() != 0) {
				out.print("<script language=javascript>alert('" + sbf.toString()
						+ "');javascript:history.back(-1);</script>");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * 显示购物车列表
	 */

	 public String list() throws Exception {
	 List<ShopCart> ls = null;
	 double totalPrice = 0.0;
	 double tp = 0.0;
	 int totalCount = 0;// 库存
	 try {
	 if (scs.getShopCart(session) != null) {
	 ls = new ArrayList<ShopCart>(scs.getShopCart(session));
	 // 计算总价格
	 for (int i = 0; i < ls.size(); i++) {
	 sc = ls.get(i);
	 totalCount = sc.getCom().getNum();
	 totalPrice += sc.getCount() * sc.getCom().getRel_price();
	 }
	 if (totalPrice >= 5000) {
	 tp = totalPrice - 100;
	 } else {
	 tp = totalPrice;
	 }
	 
	 request.setAttribute("totalCount", totalCount);
	 request.setAttribute("totalPrice", tp);

	 request.setAttribute("ls", ls);
	 }
	
	 return "list";
	 } catch (Exception e) {
	 // TODO: handle exception
	 }
	 return "error";
	 }
//	public void list() throws Exception {
//		StringBuffer sbf = new StringBuffer();
//		List<ShopCart> ls = null;
//		// double totalPrice = 0.0;
//		// double tp = 0.0;
//		// int totalCount = 0;// 库存
//		try {
//			if (scs.getShopCart(session) != null) {
//				ls = new ArrayList<ShopCart>(scs.getShopCart(session));
//				// // 计算总价格
//				sbf.append("{\"shopCart\":[");
//				for (int i = 0; i < ls.size(); i++) {
//					sc = ls.get(i);
//					sbf.append("{\"totalPrice\":\"");
//					sbf.append(sc.getCount() * sc.getCom().getRel_price());
//					sbf.append("{\"totalCount\":\"");
//					sbf.append(sc.getCom().getNum());
//					sbf.append("\"}");
//					if (i != ls.size() - 1) {
//						sbf.append(",");
//					}
//				}
//				sbf.append("]}");
//				response.setContentType("text/html;charset=UTF-8");
//				PrintWriter out = response.getWriter();
//
//				out.println(sbf.toString());
//				out.flush();
//				out.close();
//				// totalCount = sc.getCom().getNum();
//				// totalPrice += sc.getCount() * sc.getCom().getRel_price();
//				// }
//				// if (totalPrice >= 5000) {
//				// tp = totalPrice - 100;
//				// } else {
//				// tp = totalPrice;
//				// }
//			}
//			// request.setAttribute("totalCount", totalCount);
//			// request.setAttribute("totalPrice", tp);
//			// request.setAttribute("ls", ls);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	/*
	 * 删除购物车中商品
	 */

	// public String delete() throws Exception {
	// try {
	// scs.deleteShopCart(session, sc.getCom_id());
	// return "shopcartList";
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return "error";
	// }
	public void delete() throws Exception {
		StringBuffer sbf = new StringBuffer();
		scs.deleteShopCart(session, sc.getCom_id());
		ShopCart s = scs.getById(session, sc.getCom_id());
		if (s == null) {
			
			sbf.append("{\"error\":0}");
		
		} else {
			sbf.append("{\"error\":1}");

		}

		PrintWriter writer = response.getWriter();
		writer.println(sbf.toString());
		writer.flush();
		writer.close();
	}

	/*
	 * 清除购物车
	 */

	public String clear() throws Exception {
		scs.clearShopCart(session);
		try {
			return "shopcartList";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 更改商品数量
	 */

	 public String updateCount() throws Exception {
	 ComputerService coms = null;
	 Computer com = null;
	 try {
	 coms = new ComputerService();
	 com = coms.get(sc.getCom_id());
	 int totalCount = com.getNum();
	 if (scs.updateCount(sc.getCount(), sc.getCom_id(), session)) {
	 request.setAttribute("count", sc.getCount());
	 request.setAttribute("totalCount", totalCount);
	 return "shopcartList";
	 } else {
	 request.setAttribute("msg", "修改失败");
	 return "shopcartList";
	 }
	
	 } catch (Exception e) {
	 // TODO: handle exception
	 }
	 return "error";
	 }
//	public String  updateCount() throws Exception {
//		StringBuffer sbf=new StringBuffer();
//		ComputerService coms = null;
//		Computer com = null;
//		try {
//			coms = new ComputerService();
//			com = coms.get(sc.getCom_id());
//			int totalCount = com.getNum();
//			if (scs.updateCount(sc.getCount(), sc.getCom_id(), session)) {
//				sbf.append("{\"count\":\"");
//				sbf.append(sc.getCount());
//				sbf.append("\",\"totalCount\":\"");
//				sbf.append(totalCount);
//				sbf.append("\",\"error\":0");
//				sbf.append("\"}");
//			} else {
//				sbf.append("{\"error\":1}");
//			}
//			PrintWriter writer = response.getWriter();
//			response.setContentType("text/html;charset=utf-8");
//			writer.println(sbf.toString());
//			writer.flush();
//			writer.close();
//			return "shopcartList";
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return "error";
//	}

}
