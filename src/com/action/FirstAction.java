package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.zmm.pojo.Computer;
import com.zmm.pojo.ShopCart;
import com.zmm.service.ComputerService;
import com.zmm.service.ShopCartService;

public class FirstAction extends BaseAction {

	
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
		int pageNo = 1;
		int pageSize = 6;
		List<Computer> comList = null;
		String keyWord;
		StringBuffer sbf = null;
		ComputerService coms = null;
		boolean flag = false;
		try {
			sbf = new StringBuffer();
			coms = new ComputerService();

			if (flag) {
				keyWord = "where  status = 1 and";
			} else {
				keyWord = "  where status = 1  ";
			}
			if (sbf.toString().equals("")) {
				comList = coms.list(pageSize, pageNo, keyWord);
			} else {
				comList = coms.list(pageSize, pageNo, keyWord + sbf.toString());
			}
			
			List<ShopCart> ls = null;
			ShopCartService ss = null;
			double totalPrice = 0.0;
		    double tp=0.0;
				ss = new ShopCartService();
				if (ss.getShopCart(session) != null) {
					ls = new ArrayList<ShopCart>(ss.getShopCart(session));
					// 计算总价格
					for (int i = 0; i < ls.size(); i++) {
						ShopCart sc = ls.get(i);
						totalPrice += sc.getCount() * sc.getCom().getRel_price();
					}
					if(totalPrice>=5000){
						tp=totalPrice-100;
					}else{
						tp=totalPrice;
					}
				}
				request.setAttribute("totalPrice", tp);
				request.setAttribute("ls", ls);
				request.setAttribute("comList", comList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	
}
