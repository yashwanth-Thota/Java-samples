package Factory;

import Application.Models.*;

public class ModelFactory {
	
	public static User getUserInstance(){
		return new User();
	}
	public static Product getProductInstance(){
		return new Product();
	}
	public static Category getCategoryInstance(){
		return new Category();
	}
	public static Order getOrderInstance(){
		return new Order();
	}
}
