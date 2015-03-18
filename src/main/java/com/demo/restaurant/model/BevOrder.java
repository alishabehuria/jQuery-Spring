package com.demo.restaurant.model;

public class BevOrder {
	private int orderId;
	private int bevId;
	private String item_name;
	private String status;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getBevId() {
		return bevId;
	}
	public void setBevId(int bevId) {
		this.bevId = bevId;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
