package com.qa.ims.persistence.domain;

public class Items {
	
	private long product_id;
	private String product_name;
	private String product_type;
	private float product_price;
	
	public Items (String product_name, String product_type, float product_price) {
		this.setProduct_name(product_name);
		this.setProduct_type(product_type);
		this.setProduct_price(product_price);
	}
	
	public Items (Long product_id, String product_name, String product_type, float product_price) {
		this.setProduct_id(product_id);
		this.setProduct_name(product_name);
		this.setProduct_type(product_type);
		this.setProduct_price(product_price);
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}

	@Override
	public String toString() {
		return "Items [ID: " + product_id + ", Name: " + product_name + ", Type: " + product_type
				+ ", Price: £" + product_price + "]";
	}
	
	
	
	

}
