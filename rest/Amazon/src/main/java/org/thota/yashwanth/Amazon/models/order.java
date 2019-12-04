package org.thota.yashwanth.Amazon.models;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="orders")
public class order {
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public int getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(int payment_mode) {
		this.payment_mode = payment_mode;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public int getDelivery_duration() {
		return delivery_duration;
	}
	public void setDelivery_duration(int delivery_duration) {
		this.delivery_duration = delivery_duration;
	}


	@Id
	private int order_id;
	private int product_id;
	private int user_id;
	private String order_date;
	private int units;
	private int payment_mode;
	private String order_address;
	private int delivery_duration;
}
