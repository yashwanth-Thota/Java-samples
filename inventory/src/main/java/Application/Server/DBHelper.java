package Application.Server;
/*
	DBHelper class performs all operations on the data source(HashMap stored in server class)
*/
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Application.Models.*;
import Utils.*;

public class DBHelper {

	// adds users to application
	public static String addUser(User user){
		if(!DataSource.users.containsKey(user.getEmail())){
			user.setId(DataSource.users.size()+1);
			DataSource.users.put(user.getEmail(), user);
			if(user.getUserCategory()==UserLevel.Seller)
				user.setAccountStatus(AccountStatus.Inactive);
			return Constants.SUCCESS_ALERT;
		}
		return Constants.USER_EXISTS;
	}
	// authorize seller
	public static String addSeller(int userId){
		User user=getUser(userId);
		if(DataSource.users.containsKey(user.getEmail()) ){
			if(user.getAccountStatus()!=AccountStatus.Active){
				user.setAccountStatus(AccountStatus.Active);
				return Constants.SUCCESS_ALERT;
			}
			return Constants.USER_EXISTS;
		}
		return Constants.NO_SELLER_RECORDS;
	}
	// remove (disable) seller
	public static String removeSeller(int userId){
		User user=getUser(userId);
		if(DataSource.users.containsKey(user.getEmail())){
			if(DataSource.users.get(user.getEmail()).getUserCategory()!=UserLevel.Seller){
				user.setAccountStatus(AccountStatus.Inactive);
				return Constants.SUCCESS_ALERT;
			}
			return Constants.USER_EXISTS;
		}
		return Constants.NO_SELLER_RECORDS;	
	}
	// contains User
	public static  boolean containsUser(int userId){
		if(getUser(userId)==null)
			return false;
		return true;	
	}
	// remove seller
	public static String deleteSeller(int userId)
	{
		return deleteSeller(userId);
	}
	// deletes users
	public static String deleteUser(int userId){
		User user=getUser(userId);
		if(DataSource.users.containsKey(user.getEmail())){
			DataSource.users.remove(user.getEmail());
			return Constants.SUCCESS_ALERT;
		}
		return Constants.NO_USER_RECORDS;
	}
	// method returns login activity result
	public static String validateUser(User user){
		if(DataSource.users.containsKey(user.getEmail()))
		{
			if(DataSource.users.get(user.getEmail()).getPassword().equals(user.getPassword()))
			{
				Session.currentUser=DataSource.users.get(user.getEmail());
				return Constants.SUCCESS_ALERT;
			}
			return Constants.INVALID_CREDENTIALS;
		}
		return Constants.NO_USER_RECORDS;
	}
	// adds exisisting user to admin group
	public static String addAdmin(int userId){
		User user=getUser(userId);
		if(DataSource.users.containsKey(user.getEmail()) ){
			if(DataSource.users.get(user.getEmail()).getUserCategory()!=UserLevel.Admin){
				user.setUserCategory(UserLevel.Admin);
				DataSource.users.put(user.getEmail(), user);
				return Constants.SUCCESS_ALERT;
			}
			return Constants.USER_EXISTS;
		}
		return Constants.NO_SELLER_RECORDS;
	}
	
	// removes user from admin group
	public static String removeAdmin(int userId){
		User user=getUser(userId);
		if(DataSource.users.containsKey(user.getEmail())){
			DataSource.users.get(user.getEmail()).setUserCategory(UserLevel.Seller);
			return Constants.SUCCESS_ALERT;
		}
		return Constants.NO_ADMIN_RECORDS;
	}

	/*
	* operations on categories
	*/
	// adds new category
	public static String addCategory(Category category){

		if(!containsCategory(category.getCategoryName())){
			category.setCatgeoryId(DataSource.categories.size()+1);
			DataSource.categories.put(category.getCatgeoryId(), category);
			return Constants.SUCCESS_ALERT;
		}
		return Constants.USER_EXISTS;
	}
	// returns whether category present with name 
	private static boolean containsCategory(String categoryName){
		return DataSource.categories.values().stream().filter(p->p.getCategoryName().equals(categoryName))
					.collect(Collectors.toList()).size()>0;
	}
	//  returns whether category present with id
	public static boolean containsCategory(int categoryId)
	{
		return DataSource.categories.containsKey(categoryId);
	}
	// updates category
	public static String updateCategory(Category category){
		
		if(DataSource.categories.containsKey(category.getCatgeoryId())){
			DataSource.categories.put(category.getCatgeoryId(), category);
			return Constants.SUCCESS_ALERT;
		}
		return Constants.NO_CATEGORY_RECORDS;
	}
	// deletes category
	public static String deleteCategory(int categoryId){
		
		if(!DataSource.categories.containsKey(categoryId)){
			DataSource.categories.remove(categoryId);
			return Constants.SUCCESS_ALERT;
		}
		return Constants.NO_CATEGORY_RECORDS;
	}	
	// return list of categories
	public static List<Category> getCategories(){
		return DataSource.categories.values().stream()
					.filter(c->c.getParentCategory()==0)
					.collect(Collectors.toList());
	}
	//returns list of subCategories for a category
	public static List<Category> getSubCategories(int categoryId){
		
		// used stream to filter based on parent category
		return DataSource.categories.values().stream()
				.filter(p->p.getParentCategory()==categoryId)
				.collect(Collectors.toList());
	}
	// returns category by category id
	public static Category getCategory(int categoryId){
		return DataSource.categories.get(categoryId);
	}

	/*
	* operations on products
	*/
	private static boolean containsProduct(String productName)
	{
		return DataSource.products.values().stream()
				.filter(p->p.getProductName().equals(productName)&&p.getUserId()==Session.currentUser.getId())
				.collect(Collectors.toList()).size()>0;
	}
	// adds product
	public static String addProduct(Product product){
		if(DataSource.categories.containsKey(product.getCategoryId())){
			if(!containsProduct(product.getProductName()))
			{
				product.setProductId(DataSource.products.size()+1);
				product.setUserId(1);
				DataSource.products.put(product.getProductId(), product);
				return Constants.SUCCESS_ALERT;
			}
			return Constants.USER_EXISTS;
		}
		return Constants.NO_CATEGORY_RECORDS;
	}
	// deletes product
	public static String deleteProduct(int productId){
		
		if(DataSource.products.containsKey(productId)){
			DataSource.products.remove(productId);
			return Constants.SUCCESS_ALERT;
		}
		return Constants.NO_PRODUCT_RECORDS;
	}
	// returns list of products specific to category
	public static List<Product> getProducts(int categoryId){
		return new ArrayList<>(DataSource.products.values().stream().filter(p->p.getCategoryId()==categoryId).collect(Collectors.toList()));
	}
	// returns list of products
	public static List<Product> getProducts( ){
		return new ArrayList<>(DataSource.products.values());
	}
	// returns Product 
	public static Product getProduct(int productId) {
		return DataSource.products.get(productId);
	}
	// updates product
	public static String updateProduct(Product product) {
		if(DataSource.products.containsKey(product.getProductId())){
			DataSource.products.put(product.getProductId(), product);
			return Constants.SUCCESS_ALERT;
		}
		return Constants.NO_PRODUCT_RECORDS;
	}

		
	
	//returns user using email
	public static User getUser(String email){
		return DataSource.users.get(email);
	}
	//returns List of users of userLevel
	public static List<User> getUsers(UserLevel userLevel){
		return new ArrayList<>(DataSource.users.values().stream()
					.filter(u->u.getUserCategory()==userLevel&&u.getId()!=Session.currentUser.getId())
					.collect(Collectors.toList()));
	}
	//return list of all users
	public static List<User> getUsers()
	{
		return DataSource.users.values().stream().collect(Collectors.toList());
	}
	//returns user using
	public static User getUser(int userId){
		return DataSource.users.values().stream().filter(p->p.getId()==userId).collect(Collectors.toList()).get(0);
	}
	// returns sellerId from order productId
	public static int getSeller(int productId){
		return (DataSource.products.get(productId)!=null)?DataSource.products.get(productId).getUserId():0;
	}


	/*
	* operations on orders
	*/
	
	// returns list of all orders
	public static List<Order> getSellerOrders(int sellerId){
		return new ArrayList<>(DataSource.orders.values().stream()
				.filter(o->getSeller(o.getProductId())==sellerId)
				.collect(Collectors.toList()));
	}
	// returns all products of a seller
	public static List<Product> getSellerProducts(){
		return new ArrayList<>(DataSource.products.values().stream()
				.filter(p->p.getUserId()==1)
				.collect(Collectors.toList()));	
	}
	// returns  list of all orders of a user
	public static List<Order> getOrders(int userId){
		return DataSource.orders.values().stream()
				.filter(o->o.getUserId()==userId)
				.collect(Collectors.toList());
	}
	// places order and returns order status
	public static String makeOrder(Order order){
		
		if(getProduct(order.getProductId()).getUnitsAvailable()>0){
			order.setOrderId(DataSource.orders.size()+1);
			DataSource.orders.put(order.getOrderId(),order);
			return Constants.ORDER_SUCCESS;
		}
		return Constants.ORDER_FAIL;
	}
	// accepts order from users
	public static String sellOrder(int orderId){
		
		if(DataSource.orders.containsKey(orderId))
		{
			if(DataSource.products.get(DataSource.orders.get(orderId).getProductId()).getUnitsAvailable()>0){
				DataSource.orders.get(orderId).setDeliveryTime(2);
				return Constants.ORDER_ACCEPTED;		
			}
			return Constants.ORDER_FAIL;
		}
		return Constants.NO_ORDER_RECORDS;	
	}
	
}
