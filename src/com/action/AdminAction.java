package com.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.zmm.pojo.Admin;
import com.zmm.pojo.User;
import com.zmm.service.AdminService;
import com.zmm.service.UserService;

public class AdminAction extends BaseAction {

	AdminService as = new AdminService();
	UserService us = new UserService();

	int pageNo = 1, pageSize = 6, count = 0;

	private Admin admin;

	private String newPsw;

	public String getNewPsw() {
		return newPsw;
	}

	public void setNewPsw(String newPsw) {
		this.newPsw = newPsw;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/*
	 * 管理员登录
	 */

	public String login() throws Exception {
		Admin ad = null;
		try {
			List<Admin> aList = null;
			List<User> uList = null;
			int pageSize = 3;
			ad = as.login(admin.getAdmin_name(), admin.getAdmin_password());
			if (ad != null) {
				session.put("admin", ad);
				aList = as.listAdmin(pageNo, pageSize);
				request.setAttribute("aList", aList);
				uList = us.listUser(pageNo, pageSize);
				request.setAttribute("uList", uList);
				return "index";
			} else {
				request.setAttribute("msg", "用户名或密码错误 ");
				return "input";
			}

		} catch (Exception e) {

		}
		return "error";
	}

	/*
	 * 管理员列表
	 */
	@SkipValidation
	public String list() throws Exception {
		try {
			List<Admin> aList = null;
			admin = new Admin();
			admin.setStatus(1);
			count = as.getCount(admin);
			int totalPage = (int) Math.ceil((double) count / pageSize);
			if (pageNo <= 0) {
				pageNo = 1;
			}
			if (pageNo > totalPage) {
				pageNo = totalPage;
			}
			aList = as.listAdmin(pageNo, pageSize);

			request.setAttribute("pageSize", pageSize);
			request.setAttribute("aList", aList);
			request.setAttribute("count", count);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("totalPage", totalPage);
			return "list";

		} catch (Exception e) {
			// TODO: handle exception
		}

		return ERROR;
	}

	/*
	 * 管理员添加功能
	 */
	public String add() throws Exception {
		try {
			System.out.println("action" + admin);
			as.addAdmin(admin);
			request.setAttribute("msg", "添加成功");
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ERROR;
	}

	/*
	 * 管理员创建跳转页面
	 */
	@SkipValidation
	public String create() throws Exception {
		return "add";
	}

	/*
	 * 用户彻底删除（在回收站中删除）
	 */
	@SkipValidation
	public String delete() throws Exception {
		try {
			as.delete(admin);
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ERROR;
	}

	/*
	 * 管理员退出功能
	 */
	@SkipValidation
	public String quit() throws Exception {
		try {
			if (session != null) {
				session.remove("admin");
				return "quit";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 删除用户到回收站功能
	 */
	@SkipValidation
	public void recycleBin() throws Exception {
		StringBuffer sbf = new StringBuffer();
		try {
			if (admin != null) {
				as.updateStatus(admin);
				sbf.append("{\"error\":0}");

			} else {
				sbf.append("{\"error\":1}");

			}
			PrintWriter out = response.getWriter();
			out.println(sbf.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 管理员修改跳转页面
	 */
	@SkipValidation
	public String modify() throws Exception {
		try {
			admin = as.getById(admin.getId());
			if (admin != null) {
				return "update";
			} else {
				return "success";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ERROR;

	}

	/*
	 * 管理员修改功能：
	 */
	public String update() throws Exception {
		try {
			as.modify(admin);
			request.setAttribute("msg", "修改成功");
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
		}

		return ERROR;
	}

	/*
	 * 管理员回收站列表
	 */
	@SkipValidation
	public String recycleBinList() throws Exception {
		List<Admin> aList = null;
		admin = new Admin();
		try {
			admin.setStatus(0);
			count = as.getCount(admin);
			aList = new ArrayList<Admin>();
			aList = as.recycleBinList(pageNo, pageSize);
			int totalPage = (int) Math.ceil((double) count / pageSize);
			if (pageNo <= 0) {
				pageNo = 1;
			}
			if (pageNo > totalPage) {
				pageNo = totalPage;

			}
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("aList", aList);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("count", count);
			return "recycleBinList";
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ERROR;
	}

	/*
	 * 管理员回收站数据还原
	 */
	@SkipValidation
	public String recover() throws Exception {
		try {
			if (admin != null) {
				as.updateStatus(admin);
				request.setAttribute("msg", "还原成功！");
				return "clear";
			} else {
				return "clear";

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ERROR;
	}

	@SkipValidation
	public String clearRecycleBinList() throws Exception {
		try {

			as.deleteStatus();
			request.setAttribute("msg", "全部清空！");
			return "recycleBinList";

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ERROR;
	}

	/*
	 * 修改管理员密码
	 */
	public String modifyPsw() throws Exception {
		try {
			admin = as.getPassword(admin.getAdmin_password(), admin.getAdmin_name());
			admin.setAdmin_password(newPsw);
			as.modify(admin);
			request.setAttribute("msg", "修改密码成功！");
			return "quit";

		} catch (Exception e) {
			// TODO: handle exception
		}
		return INPUT;
	}

}
