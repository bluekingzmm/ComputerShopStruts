package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.zmm.pojo.User;
import com.zmm.service.UserService;
import com.zmm.util.Utils;
import com.zmm.util.Uuid;

public class UserAction extends BaseAction {
	int pageNo = 1, count = 0;
	private String agree, againPsw, newPsw, checkCode;

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	UserService us = new UserService();

	public String getAgainPsw() {
		return againPsw;
	}

	public void setAgainPsw(String againPsw) {
		this.againPsw = againPsw;
	}

	public String getNewPsw() {
		return newPsw;
	}

	public void setNewPsw(String newPsw) {
		this.newPsw = newPsw;
	}

	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*
	 * 后台用户列表
	 */
	@SkipValidation
	public String list() throws Exception {
		List<User> uList = null;
		int pageSize = 6;
		user = new User();
		user.setStatus(1);
		try {
			count = us.getUserCount(user);
			int totalPage = (int) Math.ceil((double) count / pageSize);
			if (pageNo <= 0) {
				pageNo = 1;
			}
			if (pageNo > totalPage) {
				pageNo = totalPage;
			}
			uList = us.listUser(pageNo, pageSize);
			request.setAttribute("uList", uList);
			request.setAttribute("count", count);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("pageSize", pageSize);
			System.out.println("action"+uList.toString());
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ERROR;
	}

	/*
	 * 后台用户删除到回收站
	 */
	@SkipValidation
	public String recycleBin() throws Exception {
		try {
			if (user != null) {
				us.updateStatus(user);
					request.setAttribute("msg", "删除成功！");
					return "success";
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return ERROR;
	}

	/*
	 * 后台显示用户个人信息
	 */
	@SkipValidation
	public String show() throws Exception {
		try {
			user = us.getById(user.getUser_id());
			request.setAttribute("user", user);
			return "userInfo_sec";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ERROR;
	}

	/*
	 * 用户回收站列表
	 */
	@SkipValidation
	public String recycleBinList() throws Exception {
		List<User> uList = null;
		int pageSize = 3;
		try {
			user = new User();
			user.setStatus(-1);
			count = us.getUserCount(user);
			uList = us.recycleBinList(pageNo, pageSize, user);
			int totalPage = (int) Math.ceil((double) count / pageSize);
			if (pageNo <= 0) {
				pageNo = 1;
			}
			if (pageNo > totalPage) {
				pageNo = totalPage;
			}
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("uList", uList);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("count", count);
			return "recycleList";
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "error";

	}

	/*
	 * 后台用户彻底删除
	 */
	@SkipValidation
	public String delete() throws Exception {
		if (user != null) {
			us.delete(user);
				request.setAttribute("msg", "删除成功！");
				return "clear";
			} 
	

		return "error";
	}

	/*
	 * 后台还原用户
	 */
	@SkipValidation
	public String recover() throws Exception {
		try {
			if (user != null) {
				us.updateStatus(user);
					request.setAttribute("msg", "还原成功！");
					return "success";
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 前台跳到修改用户信息界面
	 */
	@SkipValidation
	public String modify() throws Exception {
		try {
			user = us.getById(user.getUser_id());
			request.setAttribute("user", user);
			return "showOne";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 用户未激活列表
	 */
	@SkipValidation
	public String noActive() throws Exception {
		List<User> uList = null;
		int pageSize = 6;
		try {
			count = us.getUserCount(user);
			uList = us.recycleBinList(pageNo, pageSize, user);
			int totalPage = (int) Math.ceil((double) count / pageSize);
			if (pageNo <= 0) {
				pageNo = 1;
			}
			if (pageNo > totalPage) {
				pageNo = totalPage;
			}
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("uList", uList);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("count", count);
			return "recycleList";
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "error";
	}

	/*
	 * 后台按照用户名查找
	 */
	@SkipValidation
	public String searchName() throws Exception {
		List<User> uList = null;
		try {
			uList = us.search(user.getUser_name());
			request.setAttribute("uList", uList);
			return "userSearch";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 前台用户登录
	 */
	@SkipValidation
	public String login() throws Exception {
		StringBuffer sbf = null;
		try {
			sbf = new StringBuffer();

			if (user.getUser_name() == null || user.getUser_name().equals("")) {
				sbf.append("用户名不能为空！");
			}
			if (user.getUser_password() == null || user.getUser_password().equals("")) {
				sbf.append("密码不能为空！");
			}
			user = us.login(user.getUser_name(), user.getUser_password());
			if (sbf.length() != 0) {
				request.setAttribute("msg", sbf.toString());
				return "input";
			} else {
				if (user != null) {
					if (user.getStatus() == 1) {
						session.put("userInfo", user);
						return "index";
					} else if (user.getStatus() == 0) {
						request.setAttribute("msg", "你还没激活！");
						session.put("status", user.getStatus());
						return "input";
					}

				} else {
					request.setAttribute("msg", "用户名或密码错误 ");
					return "input";

				}

			}

		} catch (

		Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("msg", "该用户已经被删除了！请重新注册 ");
		return "error";
	}

	/*
	 * 前台用户退出
	 */
	@SkipValidation
	public String quit() throws Exception {
		try {
			if (session != null) {
				session.remove("userInfo");// 删除session数据
				return "index";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 前台用户注册
	 */
	public String register() throws Exception {
		try {
			if (user.getSex().equals("男")) {
				user.setSex(user.getSex());
			} else {
				user.setSex("女");
			}
			if (agree.equals("no")) {
				request.setAttribute("msg", "请同意本站条约才能注册！");
				return "input";
				// sbf.append("请同意本站条约才能注册！");
			}
			// 日期格式工具
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();// 得到系统当前时间
			String d = dateFormat.format(date);// 将系统当前时间格式化
			Date reg_time = java.sql.Date.valueOf(d);
			// Id
			int a1 = Utils.subStringToId(user.getId());
			// time
			int a2 = Utils.subStringToTime(d);
			int age = a2 - a1;
			user.setAge(age);
			user.setReg_time(reg_time);
			user.setCode(Uuid.uuid());
			if (us.searchUsername(user.getUser_name())) {
				request.setAttribute("msg", "用户名已经被注册了，请重新注册！");
				return "input";
			} else {
				us.add(user);
					// 发邮件
					Utils ut = new Utils();
					ut.sendMail(user.getMail(), user.getCode(), "email.properties");
					request.setAttribute("msg", "恭喜，注册成功！请马上到邮箱激活");
					return "add";
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 前台用户信息(单一)
	 */
	@SkipValidation
	public String ownInfo() throws Exception {
		try {
			user = us.getById(user.getUser_id());
			request.setAttribute("user", user);
			return "userInfo_fir";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 前台修改用户信息（单一）
	 */
	public String OwnInfo() throws Exception {
		try {
			SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String d = si.format(date);
			// Id
			int a1 = Utils.subStringToId(user.getId());
			// time
			int a2 = Utils.subStringToTime(d);
			int age = a2 - a1;
			user.setAge(age);
			user.setStatus(1);
			us.modifyOwn(user);
				request.setAttribute("msg", "修改成功！");
				return "input";
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "error";
	}

	/*
	 * 前台修改用户密码（登录过改密码）自动获取原密码）
	 */
	@SkipValidation
	public String modifyPsw() throws Exception {
		StringBuffer sbf = new StringBuffer();
		try {
			if (user.getUser_password() == null || user.getUser_password().equals("")) {
				sbf.append("原密码不能为空!<br/>");
			}
			user = us.getPassword(user.getUser_password(), user.getUser_name());
			if (user != null) {
				Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{6,12}$");
				Matcher matcher = pattern.matcher(newPsw);
				if (!matcher.matches()) {
					sbf.append("密码的长度应该在6-12之间");
				}
				if (newPsw == null || newPsw.equals("")) {
					sbf.append("新密码不能为空！<br/>");
				}
				if (againPsw == null || againPsw.equals("")) {
					sbf.append("再次输入新密码不能为空！<br/>");
				}
				if (user.getUser_password().equals(newPsw)) {
					sbf.append("新密码不能原来密码相同！<br/>");
				}
				if (!newPsw.equals(againPsw)) {
					sbf.append("两次输入密码不同！<br/>");
				}
			} else {
				sbf.append("原密码输入错误！<br/>");
			}

			if (sbf.length() != 0) {
				request.setAttribute("msg", sbf.toString());
				return "input";
			} else {
				us.updatePsw(newPsw, user.getUser_name());
					request.setAttribute("msg", "修改密码成功！");
					return "backLogin";
				} 

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";

	}

	@SkipValidation
	/*
	 * forgetPassword（弹出框发送）
	 */
	public String sendMail() throws Exception {
		HttpSession s = request.getSession();
		StringBuffer sbf = null;
		try {
			sbf = new StringBuffer();
			us = new UserService();
			if (user.getMail() == null || user.getMail().equals("")) {
				sbf.append("邮箱不能为空！");
			}
			if (user.getUser_name() == null || user.getUser_name().equals("")) {
				sbf.append("用户名不能为空！");
			}
			user = us.searchMail(user.getMail(), user.getUser_name());// 按照邮箱找到用户
			if (user != null) {
				s.setAttribute("userName", user.getUser_name());
				if (sbf.length() != 0) {
					request.setAttribute("msg", sbf.toString());
					return "backLogin";
				} else {
					Utils utils = new Utils();
					utils.sendMail(user.getMail(), user.getUser_name(), "send.properties");
					request.setAttribute("msg", "请马上到邮箱查看信息");
					return "backLogin";
				}

			} else {
				request.setAttribute("msg", "邮箱不对，请重试！");
				return "backLogin";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 发送激活码
	 */
	@SkipValidation
	public String activate() throws Exception {
		try {
			user = us.active(user.getCode());// 查询激活码是否存在
			System.out.println(user);
			if (user == null) {
				request.setAttribute("msg", "激活码无效");
			} else if (user.getStatus() == 1) {
				request.setAttribute("msg", "你已经激活过了！");
			} else {
				user.setStatus(1);
				us.updateStatus(user);
				request.setAttribute("msg", "激活成功！请登录");

			}
			return "add";
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "error";
	}

	/*
	 * 前台forgetpasswordt弹出后send邮箱跳转到修改界面
	 */
	@SkipValidation
	public String pMail() throws Exception {
		HttpSession session = request.getSession();
		try {
			session.setAttribute("UserName", user.getUser_name());

			return "forgetPwd5";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 前台用户激活
	 */
	@SkipValidation
	public String mail() throws Exception {
		StringBuffer sbf = null;
		try {
			sbf = new StringBuffer();
			us = new UserService();
			if (user.getMail() == null || user.getMail().equals("")) {
				sbf.append("邮箱不能为空！");
			}
			if (user.getUser_name() == null || user.getUser_name().equals("")) {
				sbf.append("用户名不能为空！");
			}
			user = us.searchMail(user.getMail(), user.getUser_name());// 按照邮箱找到用户
			if (user != null) {
				if (sbf.length() != 0) {
					request.setAttribute("msg", sbf.toString());
					return "input";
				} else {
					user.setCode(Uuid.uuid());// 激活码
					Utils utils = new Utils();
					utils.sendMail(user.getMail(), user.getCode(), "email.properties");
					us.modifyOwn(user);
						request.setAttribute("msg", "请马上到邮箱激活");
						return "backLogin";
					

				}
			} else {
				request.setAttribute("msg", "邮箱不对，请重试！");
				return "input";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 前台修改用户密码（完全忘记密码）第一个步骤（先由用户输入用户名，核实用户是否注册过）
	 */
	@SkipValidation
	public String forgetPwd1() throws Exception {
		StringBuffer sbf = new StringBuffer();
		HttpSession session = request.getSession();
		try {
			if (user.getUser_name() == null || user.getUser_name().equals("")) {
				sbf.append("用户名不能为空！");
			}
			if (checkCode == null || checkCode.equals("")) {
				sbf.append("验证码不能空！");
			}
			if (sbf.length() != 0) {
				request.setAttribute("msg", sbf.toString());
				return "forgetPwd1";
			} else {
				if (us.searchUsername(user.getUser_name())) {
					if (!checkCode.equalsIgnoreCase((String) session.getAttribute("randCheckCode"))) {
						request.setAttribute("msg", "验证码错误");
						return "forgetPwd1";
					} else {
						session.setAttribute("userName", user.getUser_name());
						return "forgetPwd2";
					}
				} else {
					request.setAttribute("msg", "用户名不存在！");
					return "forgetPwd1";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 前台修改用户密码（完全忘记密码）第二个步骤（先由用户输入邮箱地址查询，匹配数据库用户先前注册邮箱是否正确）
	 */
	@SkipValidation
	public String forgetPwd2() throws Exception {
		StringBuffer sbf = null;
		try {
			sbf = new StringBuffer();
			if (user.getMail() == null || user.getMail().equals("")) {
				sbf.append("邮箱不能为空！");
			}
			if (sbf.length() != 0) {
				request.setAttribute("msg", sbf.toString());
				return "forgetPwd2";
			} else {
				if (us.searchMailName(user.getMail())) {
					return "forgetPwd3";
				} else {
					request.setAttribute("msg", "邮箱不正确！");
					return "forgetPwd2";

				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	@SkipValidation
	public String forgetPwd3() throws Exception {
		StringBuffer sbf = null;
		try {
			sbf = new StringBuffer();
			if (newPsw == null || newPsw.equals("")) {
				sbf.append("新密码不能为空！");
			}
			if (againPsw == null || againPsw.equals("")) {
				sbf.append("请再次输入密码！");
			}
			if (!newPsw.equals(againPsw)) {
				sbf.append("两次输入密码不同！");
			}
			if (sbf.length() != 0) {
				request.setAttribute("msg", sbf.toString());
				return "forgetPwd3";
			} else {
				us.updatePsw(newPsw, user.getUser_name());
					request.setAttribute("msg", "修改密码成功！");
					return "forgetPwd4";
				} 

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	@SkipValidation
	public String yzm() throws Exception {
		// 设置不缓存图片
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// 指定生成的响应图片,一定不能缺少这句话,否则错误.
		response.setContentType("image/jpeg");
		Utils.yzm(response, request);
		return "error";
	}
}
