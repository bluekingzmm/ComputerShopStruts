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
	 * ��̨�û��б�
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
	 * ��̨�û�ɾ��������վ
	 */
	@SkipValidation
	public String recycleBin() throws Exception {
		try {
			if (user != null) {
				us.updateStatus(user);
					request.setAttribute("msg", "ɾ���ɹ���");
					return "success";
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return ERROR;
	}

	/*
	 * ��̨��ʾ�û�������Ϣ
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
	 * �û�����վ�б�
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
	 * ��̨�û�����ɾ��
	 */
	@SkipValidation
	public String delete() throws Exception {
		if (user != null) {
			us.delete(user);
				request.setAttribute("msg", "ɾ���ɹ���");
				return "clear";
			} 
	

		return "error";
	}

	/*
	 * ��̨��ԭ�û�
	 */
	@SkipValidation
	public String recover() throws Exception {
		try {
			if (user != null) {
				us.updateStatus(user);
					request.setAttribute("msg", "��ԭ�ɹ���");
					return "success";
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * ǰ̨�����޸��û���Ϣ����
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
	 * �û�δ�����б�
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
	 * ��̨�����û�������
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
	 * ǰ̨�û���¼
	 */
	@SkipValidation
	public String login() throws Exception {
		StringBuffer sbf = null;
		try {
			sbf = new StringBuffer();

			if (user.getUser_name() == null || user.getUser_name().equals("")) {
				sbf.append("�û�������Ϊ�գ�");
			}
			if (user.getUser_password() == null || user.getUser_password().equals("")) {
				sbf.append("���벻��Ϊ�գ�");
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
						request.setAttribute("msg", "�㻹û���");
						session.put("status", user.getStatus());
						return "input";
					}

				} else {
					request.setAttribute("msg", "�û������������ ");
					return "input";

				}

			}

		} catch (

		Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("msg", "���û��Ѿ���ɾ���ˣ�������ע�� ");
		return "error";
	}

	/*
	 * ǰ̨�û��˳�
	 */
	@SkipValidation
	public String quit() throws Exception {
		try {
			if (session != null) {
				session.remove("userInfo");// ɾ��session����
				return "index";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * ǰ̨�û�ע��
	 */
	public String register() throws Exception {
		try {
			if (user.getSex().equals("��")) {
				user.setSex(user.getSex());
			} else {
				user.setSex("Ů");
			}
			if (agree.equals("no")) {
				request.setAttribute("msg", "��ͬ�Ȿվ��Լ����ע�ᣡ");
				return "input";
				// sbf.append("��ͬ�Ȿվ��Լ����ע�ᣡ");
			}
			// ���ڸ�ʽ����
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();// �õ�ϵͳ��ǰʱ��
			String d = dateFormat.format(date);// ��ϵͳ��ǰʱ���ʽ��
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
				request.setAttribute("msg", "�û����Ѿ���ע���ˣ�������ע�ᣡ");
				return "input";
			} else {
				us.add(user);
					// ���ʼ�
					Utils ut = new Utils();
					ut.sendMail(user.getMail(), user.getCode(), "email.properties");
					request.setAttribute("msg", "��ϲ��ע��ɹ��������ϵ����伤��");
					return "add";
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * ǰ̨�û���Ϣ(��һ)
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
	 * ǰ̨�޸��û���Ϣ����һ��
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
				request.setAttribute("msg", "�޸ĳɹ���");
				return "input";
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "error";
	}

	/*
	 * ǰ̨�޸��û����루��¼�������룩�Զ���ȡԭ���룩
	 */
	@SkipValidation
	public String modifyPsw() throws Exception {
		StringBuffer sbf = new StringBuffer();
		try {
			if (user.getUser_password() == null || user.getUser_password().equals("")) {
				sbf.append("ԭ���벻��Ϊ��!<br/>");
			}
			user = us.getPassword(user.getUser_password(), user.getUser_name());
			if (user != null) {
				Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{6,12}$");
				Matcher matcher = pattern.matcher(newPsw);
				if (!matcher.matches()) {
					sbf.append("����ĳ���Ӧ����6-12֮��");
				}
				if (newPsw == null || newPsw.equals("")) {
					sbf.append("�����벻��Ϊ�գ�<br/>");
				}
				if (againPsw == null || againPsw.equals("")) {
					sbf.append("�ٴ����������벻��Ϊ�գ�<br/>");
				}
				if (user.getUser_password().equals(newPsw)) {
					sbf.append("�����벻��ԭ��������ͬ��<br/>");
				}
				if (!newPsw.equals(againPsw)) {
					sbf.append("�����������벻ͬ��<br/>");
				}
			} else {
				sbf.append("ԭ�����������<br/>");
			}

			if (sbf.length() != 0) {
				request.setAttribute("msg", sbf.toString());
				return "input";
			} else {
				us.updatePsw(newPsw, user.getUser_name());
					request.setAttribute("msg", "�޸�����ɹ���");
					return "backLogin";
				} 

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";

	}

	@SkipValidation
	/*
	 * forgetPassword���������ͣ�
	 */
	public String sendMail() throws Exception {
		HttpSession s = request.getSession();
		StringBuffer sbf = null;
		try {
			sbf = new StringBuffer();
			us = new UserService();
			if (user.getMail() == null || user.getMail().equals("")) {
				sbf.append("���䲻��Ϊ�գ�");
			}
			if (user.getUser_name() == null || user.getUser_name().equals("")) {
				sbf.append("�û�������Ϊ�գ�");
			}
			user = us.searchMail(user.getMail(), user.getUser_name());// ���������ҵ��û�
			if (user != null) {
				s.setAttribute("userName", user.getUser_name());
				if (sbf.length() != 0) {
					request.setAttribute("msg", sbf.toString());
					return "backLogin";
				} else {
					Utils utils = new Utils();
					utils.sendMail(user.getMail(), user.getUser_name(), "send.properties");
					request.setAttribute("msg", "�����ϵ�����鿴��Ϣ");
					return "backLogin";
				}

			} else {
				request.setAttribute("msg", "���䲻�ԣ������ԣ�");
				return "backLogin";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * ���ͼ�����
	 */
	@SkipValidation
	public String activate() throws Exception {
		try {
			user = us.active(user.getCode());// ��ѯ�������Ƿ����
			System.out.println(user);
			if (user == null) {
				request.setAttribute("msg", "��������Ч");
			} else if (user.getStatus() == 1) {
				request.setAttribute("msg", "���Ѿ�������ˣ�");
			} else {
				user.setStatus(1);
				us.updateStatus(user);
				request.setAttribute("msg", "����ɹ������¼");

			}
			return "add";
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "error";
	}

	/*
	 * ǰ̨forgetpasswordt������send������ת���޸Ľ���
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
	 * ǰ̨�û�����
	 */
	@SkipValidation
	public String mail() throws Exception {
		StringBuffer sbf = null;
		try {
			sbf = new StringBuffer();
			us = new UserService();
			if (user.getMail() == null || user.getMail().equals("")) {
				sbf.append("���䲻��Ϊ�գ�");
			}
			if (user.getUser_name() == null || user.getUser_name().equals("")) {
				sbf.append("�û�������Ϊ�գ�");
			}
			user = us.searchMail(user.getMail(), user.getUser_name());// ���������ҵ��û�
			if (user != null) {
				if (sbf.length() != 0) {
					request.setAttribute("msg", sbf.toString());
					return "input";
				} else {
					user.setCode(Uuid.uuid());// ������
					Utils utils = new Utils();
					utils.sendMail(user.getMail(), user.getCode(), "email.properties");
					us.modifyOwn(user);
						request.setAttribute("msg", "�����ϵ����伤��");
						return "backLogin";
					

				}
			} else {
				request.setAttribute("msg", "���䲻�ԣ������ԣ�");
				return "input";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * ǰ̨�޸��û����루��ȫ�������룩��һ�����裨�����û������û�������ʵ�û��Ƿ�ע�����
	 */
	@SkipValidation
	public String forgetPwd1() throws Exception {
		StringBuffer sbf = new StringBuffer();
		HttpSession session = request.getSession();
		try {
			if (user.getUser_name() == null || user.getUser_name().equals("")) {
				sbf.append("�û�������Ϊ�գ�");
			}
			if (checkCode == null || checkCode.equals("")) {
				sbf.append("��֤�벻�ܿգ�");
			}
			if (sbf.length() != 0) {
				request.setAttribute("msg", sbf.toString());
				return "forgetPwd1";
			} else {
				if (us.searchUsername(user.getUser_name())) {
					if (!checkCode.equalsIgnoreCase((String) session.getAttribute("randCheckCode"))) {
						request.setAttribute("msg", "��֤�����");
						return "forgetPwd1";
					} else {
						session.setAttribute("userName", user.getUser_name());
						return "forgetPwd2";
					}
				} else {
					request.setAttribute("msg", "�û��������ڣ�");
					return "forgetPwd1";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * ǰ̨�޸��û����루��ȫ�������룩�ڶ������裨�����û����������ַ��ѯ��ƥ�����ݿ��û���ǰע�������Ƿ���ȷ��
	 */
	@SkipValidation
	public String forgetPwd2() throws Exception {
		StringBuffer sbf = null;
		try {
			sbf = new StringBuffer();
			if (user.getMail() == null || user.getMail().equals("")) {
				sbf.append("���䲻��Ϊ�գ�");
			}
			if (sbf.length() != 0) {
				request.setAttribute("msg", sbf.toString());
				return "forgetPwd2";
			} else {
				if (us.searchMailName(user.getMail())) {
					return "forgetPwd3";
				} else {
					request.setAttribute("msg", "���䲻��ȷ��");
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
				sbf.append("�����벻��Ϊ�գ�");
			}
			if (againPsw == null || againPsw.equals("")) {
				sbf.append("���ٴ��������룡");
			}
			if (!newPsw.equals(againPsw)) {
				sbf.append("�����������벻ͬ��");
			}
			if (sbf.length() != 0) {
				request.setAttribute("msg", sbf.toString());
				return "forgetPwd3";
			} else {
				us.updatePsw(newPsw, user.getUser_name());
					request.setAttribute("msg", "�޸�����ɹ���");
					return "forgetPwd4";
				} 

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	@SkipValidation
	public String yzm() throws Exception {
		// ���ò�����ͼƬ
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// ָ�����ɵ���ӦͼƬ,һ������ȱ����仰,�������.
		response.setContentType("image/jpeg");
		Utils.yzm(response, request);
		return "error";
	}
}
