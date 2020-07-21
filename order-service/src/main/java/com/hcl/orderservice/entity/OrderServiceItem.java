package com.hcl.orderservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="order_service_item")
public class OrderServiceItem  implements Serializable{

	private static final long serialVersionUID = 7784287585781440851L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_service_item_Id")
	private int orderServiceItemId;
	
	@Column(name="order_item_id")
	private int orderItemId;
	
	@Column(name="order_Id")
	private int orderId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_Id",insertable = false, updatable = false)
	@JsonBackReference
	private Order order;
	

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getOrderServiceItemId() {
		return orderServiceItemId;
	}

	public void setOrderServiceItemId(int orderServiceItemId) {
		this.orderServiceItemId = orderServiceItemId;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	
	

}
