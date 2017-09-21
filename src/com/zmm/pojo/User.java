/**
 * 
 */
package com.zmm.pojo;

import java.util.Date;

/**
 * @author Administrator
 *用户信息
 */
public class User {

	private String user_id;
	private String user_name;
	private String rel_name;
	private String user_password;
	private String phone;
	private String address;
	private String mail;
	private Date reg_time;
	private String code;
	private int status;
	private String sex;
	private String Id;
	private int age;
	
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", rel_name=" + rel_name + ", user_password="
				+ user_password + ", phone=" + phone + ", address=" + address + ", mail=" + mail + ", reg_time="
				+ reg_time + ", code=" + code + ", status=" + status + ", sex=" + sex + ", Id=" + Id + ", age=" + age
				+ "]";
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getRel_name() {
		return rel_name;
	}
	public void setRel_name(String rel_name) {
		this.rel_name = rel_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getReg_time() {
		return reg_time;
	}
	public void setReg_time(Date reg_time) {
		this.reg_time = reg_time;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	

	
}
