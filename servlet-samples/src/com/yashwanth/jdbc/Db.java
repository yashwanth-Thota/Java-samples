package com.yashwanth.jdbc;
import java.util.ArrayList;
import java.util.List;

public class Db {
	
	public static List<Product> products=new ArrayList<Product>();
	static {
		Product  p=new Product();
		p.setProductName("Dell");
		p.setCategory(2);
		p.setPrice(25000);
		products.add(p);
		p=new Product();
		p.setProductName("Hp");
		p.setCategory(2);
		p.setPrice(32000);
		products.add(p);
	}
}