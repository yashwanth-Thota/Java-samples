package org.thota.yashwanth.Amazon.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name="products")
public class product{
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(int payment_mode) {
		this.payment_mode = payment_mode;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	@Id
	private int product_id;
	private int category_id;
	private int payment_mode;
	private int units;
	private String product_description;
	private int user_id;
	private int product_price;
}
