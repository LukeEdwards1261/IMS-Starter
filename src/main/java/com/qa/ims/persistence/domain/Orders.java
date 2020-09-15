package com.qa.ims.persistence.domain;

public class Orders {
	
	private long order_id;
	private long customer_id;
	private long ordered_products;
	private long product_quantity;
	
	public Orders(long customer_id, long ordered_products,long product_quantity ) {
		this.setCustomer_id(customer_id);
		this.setOrdered_products(ordered_products);
		this.setProduct_quantity(product_quantity);
	}
	
	public Orders(long order_id,long customer_id, long ordered_products,long product_quantity) {
		this.setOrder_id(order_id);
		this.setCustomer_id(customer_id);
		this.setOrdered_products(ordered_products);
		this.setProduct_quantity(product_quantity);
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public long getOrdered_products() {
		return ordered_products;
	}

	public void setOrdered_products(long ordered_products) {
		this.ordered_products = ordered_products;
	}

	public long getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(long product_quantity) {
		this.product_quantity = product_quantity;
	}

	@Override
	public String toString() {
		return "Orders [order ID: " + order_id + ", customer ID: " + customer_id + ", ordered product ID: "
				+ ordered_products + ",quantity: " + product_quantity + "]";
	}

//	@Override
//	public String toString() {
//		return "Orders [order_id=" + order_id + ", ordercustomer_id=" + ordercustomer_id + ", orderproducts="
//				+ orderproducts + ", orderquantity=" + orderquantity + "]";
//	}
	
	

}
