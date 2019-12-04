package Logic;

// UserHelper to perform operation on dataSorce using DBHelper

import java.util.List;

import Application.Models.*;
import Application.Server.DBHelper;
import Utils.*;

public class UserHelper {
	private DBHelper dbHelper;
	public UserHelper(){
		dbHelper=new DBHelper();	
	}
	public String addUser(User user){
		return dbHelper.addUser(user);
	}
	public String deleteUser(int userId){
		
		return dbHelper.deleteUser(userId);
	}
	public String validateUser(User user){
	    	return dbHelper.validateUser(user);
	}
	
	public String addSeller(int userId){
		return dbHelper.addSeller(userId);
	}
	public String addAdmin(int userId){
		return dbHelper.addAdmin(userId);
	}
	public String deleteSeller(int sellerId)
	{
		return dbHelper.deleteSeller(sellerId);
	}	
	public String removeSeller(int sellerId){
		return dbHelper.removeSeller(sellerId);
	}	
	
	public boolean containsUser(int userId){
		return dbHelper.containsUser(userId);
	}
	public List<Product> getSellerProducts()
	{
		return dbHelper.getSellerProducts();
	}
	public String addCategory(Category category){
		return dbHelper.addCategory(category);
	}
	public String updateCategory(Category category){
		
		return dbHelper.updateCategory(category);
	}
	public String deleteCategory(int categoryId){
		
		return dbHelper.deleteCategory(categoryId);
	}	
	public List<Category> getCategories(){
		return dbHelper.getCategories();
	}
	public List<Category> getSubCategories(int categoryId){
		return dbHelper.getSubCategories(categoryId);
	}
	public Category getCategory(int categoryId){
		return dbHelper.getCategory(categoryId);
	}
	
	
	public String addProduct(Product product){

		return dbHelper.addProduct(product);
	}
	public String deleteProduct(int productId){
		
		return dbHelper.deleteProduct(productId);
	}
	public List<Product> getProducts(int categoryId){

		return dbHelper.getProducts( categoryId);
	}
	public List<Product> getProducts(){

		return dbHelper.getProducts();
	}	


	public boolean containsCategory(int categoryId)
	{
		return dbHelper.containsCategory(categoryId);
	}
	public User getUser(String email){
		return dbHelper.getUser(email);
	}
	public List<User> getUsers(UserLevel userLevel){
		return dbHelper.getUsers(userLevel);
	}
	public List<User> getUsers(){
		return dbHelper.getUsers();	
	}
	public User getUser(int userId){
		return dbHelper.getUser(userId);
	}

	public String sellOrder(int orderId){
		return dbHelper.sellOrder(orderId);	
	}
	public String makeOrder(Order order){
		return dbHelper.makeOrder(order);
	}
	public List<Order> getOrders(){
		return dbHelper.getOrders(Session.currentUser.getId());
	}
	public List<Order> getSellerOrders(){
		return dbHelper.getSellerOrders(Session.currentUser.getId());
	}
	public Product getProduct(int productId) {
		return dbHelper.getProduct(productId);
	}
	public String updateProduct(Product product) {
		return dbHelper.updateProduct(product);
	}
}
