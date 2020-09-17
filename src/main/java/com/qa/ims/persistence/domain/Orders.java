package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	
	private long orderId;
	private Customer customer;
	private List<Items> items = new ArrayList<>();
	
	
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public Customer getCust() {
		return customer;
	}
	public void setCust(Customer customer) {
		this.customer = customer;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public Orders(long orderId, Customer customer, List<Items> items) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.items = items;
	}
	public Orders(Customer customer, List<Items> items) {
		super();
		this.customer = customer;
		this.items = items;
	}
	public Orders(long orderId, Customer cust) {
		super();
		this.orderId = orderId;
		this.customer = cust;
	}
	public Orders(long orderId) {
		super();
		this.orderId = orderId;
	}
	
	@Override
	public String toString() {
		StringBuilder order = new StringBuilder();
		order.append(String.format("orderId: %s", this.orderId));
		order.append(String.format("customerId: %s", customer.getId()));
		order.append(String.format(" customer: %s %s", customer.getFirst_name(), customer.getSurname()));
		this.items.forEach(item -> {
			order.append("\n -> ");
			order.append(item);
		});
		return order.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	
	
}
