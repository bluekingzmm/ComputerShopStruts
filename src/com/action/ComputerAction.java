package com.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.zmm.pojo.Brand;
import com.zmm.pojo.Computer;
import com.zmm.pojo.Cpu;
import com.zmm.pojo.Screen;
import com.zmm.service.BrandService;
import com.zmm.service.ComputerService;
import com.zmm.service.CpuService;
import com.zmm.service.ScreenService;

public class ComputerAction extends BaseAction {
	private Computer com;
	private int pageNo = 1;

	private String search, status, colorName, first_Price, second_Price, brandName, cpuName, screenName, start, over,
			modelName;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getFirst_Price() {
		return first_Price;
	}

	public void setFirst_Price(String first_Price) {
		this.first_Price = first_Price;
	}

	public String getSecond_Price() {
		return second_Price;
	}

	public void setSecond_Price(String second_Price) {
		this.second_Price = second_Price;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getOver() {
		return over;
	}

	public void setOver(String over) {
		this.over = over;
	}

	public String getCpuName() {
		return cpuName;
	}

	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Computer getCom() {
		return com;
	}

	public void setCom(Computer com) {
		this.com = com;
	}

	ComputerService coms = new ComputerService();
	BrandService bs = new BrandService();
	ScreenService ss = new ScreenService();
	CpuService cs = new CpuService();

	/*
	 * 增加商品(跳转)
	 */
	public String create() {
		try {
			List<Screen> sList = null;
			List<Brand> bList = null;
			List<Cpu> cList = null;
			sList = ss.listScreen();
			cList = cs.listCpu();
			bList = bs.listBrand();
			request.setAttribute("cList", cList);
			request.setAttribute("bList", bList);
			request.setAttribute("sList", sList);
			return "add";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ERROR;
	}

	/*
	 * 添加商品
	 */

	public String add() throws Exception {
		try {
			com.setBrand(com.getBrand());
			com.setCpu(com.getCpu());
			com.setScreen(com.getScreen());
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String strDate = dateformat.format(date);
			Date regDate = java.sql.Date.valueOf(strDate);
			com.setReg_date(regDate);
			coms.save(com);
			request.setAttribute("msg", "添加成功！");
			return "comList";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

	/*
	 * 后台显示商品
	 */
	public String list() throws Exception {
		System.out.println("iiii");
		System.out.println(brandName);
		int pageSize = 6;
		int count = 0;
		List<Computer> comList = null;
		String keyWord;
		List<Brand> bList = null;
		List<Screen> sList = null;
		List<Cpu> cList = null;
		StringBuffer sbf = null;
		boolean flag = false;
		try {
			sbf = new StringBuffer();
			if (brandName != null && !brandName.equals("")) {
				if (flag)
					sbf.append(" and ");
				sbf.append(" brand_name = '");
				sbf.append(brandName);
				sbf.append(" '");
				flag = true;
			}
			if (status != null && !status.equals("")) {
				sbf.append(" status ='");
				sbf.append(status);
				sbf.append("'");
				flag = true;
			}
			if (cpuName != null && !cpuName.equals("")) {
				if (flag)
					sbf.append(" and ");
				sbf.append(" cpu_name = '");
				sbf.append(cpuName);
				sbf.append(" '");
				flag = true;
			}
			if (screenName != null && !screenName.equals("")) {
				if (flag)
					sbf.append(" and ");
				sbf.append(" screen_name = ' ");
				sbf.append(screenName);
				sbf.append(" '");
				flag = true;
			}
			if (colorName != null && !colorName.equals("")) {
				if (flag)
					sbf.append(" and ");
				sbf.append(" color like '%");
				sbf.append(colorName);
				sbf.append("%' ");
				flag = true;
			}
			if (start != null && !start.equals("") || over != null && !over.equals("")) {
				if (flag)
					sbf.append(" and ");
				sbf.append(" reg_date BETWEEN ' ");
				sbf.append(start);
				sbf.append(" ' and '");
				sbf.append(over);
				sbf.append(" '");
				flag = true;
			}
			if (modelName != null && !modelName.equals("")) {
				if (flag)
					sbf.append(" and ");
				sbf.append(" model like '%");
				sbf.append(modelName);
				sbf.append("%' ");
				flag = true;
			}

			if (flag) {
				keyWord = "where";
			} else {
				keyWord = "";
			}
			if (sbf.toString().equals("")) {
				comList = coms.list(pageSize, pageNo, keyWord);
				count = coms.getCount(keyWord);
			} else {
				comList = coms.list(pageSize, pageNo, keyWord + sbf.toString());
				count = coms.getCount(keyWord + sbf.toString());
			}
			int totalPage = (int) Math.ceil((double) count / pageSize);
			if (pageNo >= totalPage)
				pageNo = totalPage;

			request.setAttribute("comList", comList);
			cList = cs.listCpu();
			request.setAttribute("cList", cList);

			bList = bs.listBrand();
			request.setAttribute("bList", bList);
			sList = ss.listScreen();
			request.setAttribute("sList", sList);

			request.setAttribute("count", count);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("totalPage", totalPage);

			return "list";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/*
	 * 前台电脑列表
	 */
	public String listInfo() throws Exception {
		int pageSize = 6;
		int count = 0;
		List<Computer> comList = null;
		String keyWord;
		List<Brand> bList = null;
		List<Screen> sList = null;
		List<Cpu> cList = null;
		StringBuffer sbf = null;
		boolean flag = false;
		try {
			sbf = new StringBuffer();
			if (brandName != null && !brandName.equals("")) {
				if (flag)
					sbf.append(" and ");
				sbf.append(" brand_name = '");
				sbf.append(brandName);
				sbf.append(" '");
				flag = true;
			}
			if (cpuName != null && !cpuName.equals("")) {
				if (flag)
					sbf.append(" and ");
				sbf.append(" cpu_name = '");
				sbf.append(cpuName);
				sbf.append(" '");
				flag = true;
			}
			if (screenName != null && !screenName.equals("")) {
				if (flag)
					sbf.append(" and ");
				sbf.append(" screen_name = '");
				sbf.append(screenName);
				sbf.append("英寸'");
				flag = true;
			}
			if (colorName != null && !colorName.equals("")) {
				if (flag)
					sbf.append(" and ");
				sbf.append(" color like '%");
				sbf.append(colorName);
				sbf.append("%' ");
				flag = true;
			}
			if (first_Price != null && !first_Price.equals("") || second_Price != null && !second_Price.equals("")) {
				if (flag)
					sbf.append(" and ");
				sbf.append(" rel_price BETWEEN ' ");
				sbf.append(first_Price);
				sbf.append(" ' and '");
				sbf.append(second_Price);
				sbf.append(" '");
				flag = true;
			}
			if (search != null && !search.equals("")) {
				if (flag)
					sbf.append(" and ");
				sbf.append(" brand_name like '%");
				sbf.append(search);
				sbf.append("%' ");
				sbf.append(" or ");
				sbf.append(" model like '%");
				sbf.append(search);
				sbf.append("%' ");
				sbf.append(" or ");
				sbf.append(" pixels like '%");
				sbf.append(search);
				sbf.append("%' ");
				sbf.append(" or ");
				sbf.append(" ram like '%");
				sbf.append(search);
				sbf.append("%' ");
				sbf.append(" or ");
				sbf.append(" screen_name like '%");
				sbf.append(search);
				sbf.append("%' ");
				sbf.append(" or ");
				sbf.append(" cpu_name like '%");
				sbf.append(search);
				sbf.append("%' ");
				sbf.append(" or ");
				sbf.append(" color like '%");
				sbf.append(search);
				sbf.append("%' ");
				flag = true;
			}
			if (flag) {
				keyWord = " where status = 1 and ";
			} else {
				keyWord = " where status = 1  ";
			}
			if (sbf.toString().equals("")) {
				comList = coms.list(pageSize, pageNo, keyWord);
				count = coms.getCount(keyWord);
			} else {
				comList = coms.list(pageSize, pageNo, keyWord + sbf.toString());
				count = coms.getCount(keyWord + sbf.toString());
			}
			int totalPage = (int) Math.ceil((double) count / pageSize);

			request.setAttribute("comList", comList);
			cList = cs.listCpu();
			request.setAttribute("cList", cList);
			bList = bs.listBrand();
			request.setAttribute("bList", bList);
			sList = ss.listScreen();
			request.setAttribute("sList", sList);
			request.setAttribute("count", count);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("totalPage", totalPage);

			return "listinfo";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/*
	 * 前台单个商品显示
	 */

	public String getProduct() throws Exception {
		System.out.println("kkkk");
		try {
			System.out.println("oo"+com);
			com = coms.get(com.getCom_id());
			request.setAttribute("com", com);
			System.out.println("ll"+com);
			return "product";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 后台显示单个商品
	 */

	public String show() throws Exception {
		try {
			com = coms.get(com.getCom_id());
			request.setAttribute("com", com);
			return "show";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";

	}

	/*
	 * 后台(跳转)编辑电脑商品
	 */

	public String edit() throws Exception {
		List<Screen> sList = null;
		List<Brand> bList = null;
		List<Cpu> cList = null;
		try {
			com = coms.get(com.getCom_id());
			sList = ss.listScreen();
			cList = cs.listCpu();
			bList = bs.listBrand();
			request.setAttribute("cList", cList);
			request.setAttribute("bList", bList);
			request.setAttribute("sList", sList);
			return "update";

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "error";
	}

	/*
	 * 后台电脑商品修改
	 */

	public String update() throws Exception {
		try {
			if (com != null) {
				com.setBrand(com.getBrand());
				com.setCpu(com.getCpu());
				com.setScreen(com.getScreen());
				coms.update(com);
				request.setAttribute("msg", "修改成功！");
				return "comList";
			} else {
				request.setAttribute("msg", "修改失败！！");
				return "editInfo";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/*
	 * 修改商品上下架
	 */
	public String changeState() throws Exception {
		try {
			com = coms.get(com.getCom_id());
			if (com != null) {
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String strDate = dateformat.format(date);
				Date regDate = java.sql.Date.valueOf(strDate);
				com.setReg_date(regDate);
				if (com.getStatus() == 0) {
					com.setStatus(1);
				} else {
					com.setStatus(0);
				}
				coms.updateStatus(com);
				return "comList";
			} else {
				request.setAttribute("msg", "find not id");
				return "comList";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	public void allList() throws Exception {
		List<Screen> sList = null;
		List<Brand> bList = null;
		List<Cpu> cList = null;
		sList = ss.listScreen();
		cList = cs.listCpu();
		bList = bs.listBrand();
		try {

			StringBuffer result = new StringBuffer();
			result.append("{\"sList\" :[");
			for (int i = 0; i < sList.size(); i++) {
				Screen sc = sList.get(i);
				result.append("{\"screen_id\":\"");
				result.append(sc.getScreen_id());
				result.append("\",\"screen_name\":\"");
				result.append(sc.getScreen_name());
				result.append("\"}");
				if (i != sList.size() - 1) {
					result.append(",");
				}
			}
			result.append("],\"cList\" :[");
			for (int i = 0; i < cList.size(); i++) {
				Cpu c = cList.get(i);
				result.append("{\"cpu_id\":\"");
				result.append(c.getCpu_id());
				result.append("\",\"cpu_name\":\"");
				result.append(c.getCpu_name());
				result.append("\"}");
				if (i != cList.size() - 1) {
					result.append(",");
				}
			}
			result.append("],\"bList\" :[");
			for (int i = 0; i < bList.size(); i++) {
				Brand b = bList.get(i);
				result.append("{\"brand_id\":\"");
				result.append(b.getBrand_id());
				result.append("\",\"brand_name\":\"");
				result.append(b.getBrand_name());
				result.append("\"}");
				if (i != bList.size() - 1) {
					result.append(",");
				}
			}
			result.append("]}");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(result.toString());
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
