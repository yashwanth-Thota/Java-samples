package Application.Server;
// DataSorce has records of users, products, orders, categories
import java.util.HashMap;

import Application.Models.*;

public class DataSource {
	public static HashMap<String,User> users=new HashMap<String,User>();
	public static HashMap<Integer,Product> products=new HashMap<Integer,Product>();
	public static HashMap<Integer,Order> orders=new HashMap<Integer,Order>();
	public static HashMap<Integer,Category> categories=new HashMap<Integer,Category>();
	static {
		users.put("test", new User("email","pass",2,"123456789","name"));
		users.put("test1", new User("email","pass",4,"123456789","name"));
		users.put("test2", new User("email","pass",3,"123456789","name"));
		users.put("test3", new User("admin","admin",1,"123456789","name"));
		categories.put(1, new Category("Electronics"));
		categories.put(2, new Category("Clothes"));
		categories.put(3, new Category("Furnitures"));
		Product p;
		for(int i=0;i<15;i++) {
			p=new Product();
			p.setCategoryId(1);
			p.setProductName("Apple"+1);
			p.setProductId(products.size()+1);
			p.setProductDescription("STEVE JOBS");
			p.setProductPrice(120000);
			p.setUnitsAvailable(2000);
			p.setUserId(1);
			products.put(p.getProductId(), p);
		}
	}
}
