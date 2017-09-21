/**
 * 
 */
package com.zmm.pojo;

import java.util.Date;

/**
 * @author Administrator ������Ϣ
 */
public class Order {
	private Long orderId;
	private User user;
	private Date submitTime;// �ύ����ʱ��
	private double totalPrice;
	// �Ƿ���֧��
	private int isPay;
	// �Ƿ����ͻ�
	private int isDeliver;
	
	private String label;//��ע
	private int tx;//����
	private int status;//����

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTx() {
		return tx;
	}

	public void setTx(int tx) {
		this.tx = tx;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getIsPay() {
		return isPay;
	}

	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}

	public int getIsDeliver() {
		return isDeliver;
	}

	public void setIsDeliver(int isDeliver) {
		this.isDeliver = isDeliver;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", submitTime=" + submitTime + ", totalPrice="
				+ totalPrice + ", isPay=" + isPay + ", isDeliver=" + isDeliver + ", label=" + label + ", tx=" + tx
				+ ", status=" + status + "]";
	}

	

	

}
