/*
*	Menu class performs all operations.
*	Imports:
*		Factory.ModelFactory   : ModelFactory class gives instances of models(User,Product,Order,Category),
*		Logic.UserHelper       : UserHelper class contains business login,
*		Models		       : Models package contains all models
*		Utils 		       : Utils package contains all Enums,Constants. 
*	Global variables :
*		console(Scanner)       : scanner object for readinInput,
*		choice(int)	       : for storing user choice on available options,
*		input(String) 	       : for reading user details,
*		userHelper(UserHelper) : object of UserHelper for Logic,
*	Utility Methods:
*		selectChoice()	       : reads choice into choice variable,
*		readInput()	       : reads user details into input variable.
 */
import java.util.Date;
import java.util.Scanner;

import Application.Models.*;

import java.util.List;
import Factory.ModelFactory;
import Logic.UserHelper;
import Utils.*;

public class Menu {

	private Scanner console;
	private int choice=0;
	private UserHelper userHelper;
	private String input="";
	private int parentCategory=0;
	// constructor
	public Menu(){
		userHelper=new UserHelper();
		console=new Scanner(System.in);
	}
	// loads application
	public void loadApplication(){
		
		System.out.println("\n");
		System.out.println(Constants.LOGGED_OFF_MENU);
		
		while(true){
			try{
				selectChoice();
				switch(choice)
				{
					case 1:
						if(Session.currentUser!=null){
							Session.currentUser=null;
						}
						else
							login();
						break;
					case 2:
						if(Session.currentUser!=null) loadMenu();
						else viewProducts();
						break;
					case 3:
						if(Session.currentUser==null) Register();
						break;
					default:
						break;
				}
			}
			catch(Exception e){
				System.out.println(Constants.INVALID_OPTIONS);
			}
			finally{
				System.out.println("\n");
				if(Session.currentUser!=null){
					System.out.println(Constants.LOGGED_IN_MENU);
				}
				else{				
					System.out.println(Constants.LOGGED_OFF_MENU);
				}
			}
		}
	}
	//login method
	private void login() {

		User user=ModelFactory.getUserInstance();

		System.out.print(Constants.MAIL_PROMPT);
		readInput();
		user.setEmail(input);

		System.out.print(Constants.PASSWORD_PROMPT);
		readInput();
		user.setPassword(input);

		System.out.println(Constants.SEPARATOR);		
		String result=userHelper.validateUser(user);
		System.out.println(result);
	}
	// load menu
	private void loadMenu(){

		switch(Session.currentUser.getUserCategory()){
			case Admin:
				loadAdminMenu();
				break;
			case Seller:
				if(Session.currentUser.getAccountStatus()==AccountStatus.Active) loadSellerMenu();
				else System.out.println(Constants.ACCOUNT_INACTIVE_ALERT);
				break;
			case User:
				loadUserMenu();
				break;
			default:
				loadUserMenu();
				break;
		}
		
	}	
	/*
	* admin operations
	*/
	// admin menu
	private void loadAdminMenu() {

		System.out.println(Constants.ADMIN_MENU);
		selectChoice();

		do{
			if(choice== 1)
				loadAdminAddMenu();
			else if(choice==2)
				loadAdminEditMenu();
			else if(choice==3)
				break;
			else
				System.out.println(Constants.INVALID_OPTIONS);
			System.out.println(Constants.ADMIN_MENU);
			selectChoice();
		}while(true);
	}
	// admin add menu
	private void loadAdminAddMenu() {

		System.out.println(Constants.ADMIN_ADD_MENU);
		selectChoice();
		do{
			if(choice==1) addAdmin();
			else if(choice==2) addSeller();
			else if(choice==3) addCategory();
			else if(choice==4) addSubCategory();
			else if(choice==5) break;
			else System.out.println(Constants.INVALID_OPTIONS);
			System.out.println(Constants.ADMIN_ADD_MENU);
			selectChoice();
		}while(true);
	}
	// accepting seller requests
	private void addSeller() {

		if(viewUsers(UserLevel.Seller)>0)
		{
			readInput();
			try{
				if(userHelper.containsUser(Integer.parseInt(input))){
					System.out.println(userHelper.addSeller(Integer.parseInt(input)));			
				}	
				else
					throw new NoSuchUserException();
			}
			catch(NoSuchUserException noSuchUserException){
				System.out.println(noSuchUserException);
			}
			System.out.println(Constants.SEPARATOR);
		}
	}
	// adding existing user to admin group
	private void addAdmin() {

		if(viewUsers(UserLevel.Seller)>0){
			readInput();
			System.out.println(Constants.SEPARATOR);
			System.out.println(userHelper.addAdmin(Integer.parseInt(input)));
		}
		else{
			System.out.println(Constants.NO_SELLER_RECORDS);
			System.out.println(Constants.SEPARATOR);
		}
	}
	// add category
	private void addCategory() {

		do{
			Category category=ModelFactory.getCategoryInstance();

			System.out.print(Constants.CATEGORY_NAME_PROMPT);
			readInput();
			category.setCategoryName(input);
			
			System.out.println(userHelper.addCategory(category));
			System.out.println(Constants.SEPARATOR);
			System.out.print(Constants.ADD_CATEGORY_ALERT);
			readInput();
			System.out.println(Constants.SEPARATOR);
		}while(input.matches(Constants.ACCEPT)&&input.length()==1);
	}
	//add subcategory
	private void addSubCategory(){
		do{
			Category category=ModelFactory.getCategoryInstance();
			viewCategories();
			System.out.print(Constants.PARENT_CATEGORY_PROMPT_WITH_ADD);
			readInput();
			parentCategory=Integer.parseInt(input);
			if(Integer.parseInt(input)==0) {
				addCategory();
				viewCategories();
			}
			while(true){	
				
				System.out.print(Constants.MOVE_TO_SUBCATEGORIES_ALERT);
				readInput();
				System.out.println(Constants.SEPARATOR);	
				if(input.matches(Constants.ACCEPT)&&viewSubCategories(parentCategory)>0){
					System.out.print(Constants.PARENT_CATEGORY_PROMPT);
					readInput();
					System.out.println(Constants.SEPARATOR);
					parentCategory=Integer.parseInt(input);		
				}
				else break;
				
			}	
			try{
				if(!userHelper.containsCategory(parentCategory))
					throw new NoSuchCategoryException();
				category.setParentCategory(parentCategory);
				System.out.println(Constants.SEPARATOR);	
				System.out.print(Constants.CATEGORY_NAME_PROMPT);
				readInput();
				System.out.println(Constants.SEPARATOR);
				category.setCategoryName(input);

				System.out.println(userHelper.addCategory(category));					
			}
			catch(NoSuchCategoryException noSuchCategoryException){
				System.out.println(noSuchCategoryException);		
			}
			
			System.out.println(Constants.SEPARATOR);
			System.out.print(Constants.ADD_SUBCATEGORY_ALERT);
			readInput();
			System.out.println(Constants.SEPARATOR);
		}while(input.matches(Constants.ACCEPT));
	}
	
	// admin edit menu
	private void loadAdminEditMenu() {
		
		do{
			if(choice==1) deleteUser();
			else if(choice==2) editSeller();
			else if(choice==3) deleteProduct();
			else if(choice==4) editCategory();
			else if(choice==5) break;
			else System.out.println(Constants.INVALID_OPTIONS);
			System.out.println(Constants.ADMIN_EDIT_MENU);
			selectChoice();
		}while(true);
	}
	// deletes users
	private void deleteUser() {
		
		if(viewUsers()>0)
		{
			readInput();
			System.out.println(userHelper.deleteUser(Integer.parseInt(input)));
		}
	}
	// edit sellers
	private void editSeller() {
	
		if(viewUsers(UserLevel.Seller)>0)
		{		
			System.out.print(Constants.SELECT_USER);
			readInput();
			int sellerId=Integer.parseInt(input);
			System.out.println(Constants.EDIT_OPTIONS);
			selectChoice();
			switch(choice){
				case 1:
					System.out.println(userHelper.removeSeller(sellerId));
					break;
				case 2:
					System.out.print(Constants.DEL_ALERT);
					readInput();
					if(input.matches(Constants.ACCEPT)) 
						System.out.println(userHelper.deleteSeller(sellerId));
					break;
				default:
					System.out.println(Constants.INVALID_OPTIONS);	
					break;		
			}
		}
	}
	// delete category
	private void editCategory()  {

		if(viewCategories()>0)
		{
			System.out.print(Constants.SELECT_CATEGORY);
			readInput();
			String category=input;
			System.out.println(Constants.SEPARATOR);
			System.out.print(Constants.EDIT_SUB_CATEGORY_PROPMT);
			readInput();
			System.out.println(Constants.SEPARATOR);
			do
			{
				if(viewSubCategories(Integer.parseInt(category))==0)
					break;
				System.out.print(Constants.SELECT_SUB_CATEGORY);					
				readInput();
				category=input;

				System.out.println(Constants.SEPARATOR);
				System.out.print(Constants.EDIT_SUB_CATEGORY_PROPMT);
				readInput();
				System.out.println(Constants.SEPARATOR);
			}while(input.matches(Constants.ACCEPT));
			System.out.println(Constants.EDIT_OPTIONS);
			System.out.println(Constants.SEPARATOR);
			selectChoice();
			switch(choice){
				case 1:
					updateCategory(Integer.parseInt(category));
					break;
				case 2:
					System.out.print(Constants.DEL_ALERT);
					readInput();
					if(input.contains(Constants.ACCEPT)) 
						System.out.println(userHelper.deleteCategory(Integer.parseInt(input)));	
					break;
				default:
					System.out.println(Constants.INVALID_OPTIONS);	
					break;		
			}
		}	
	}
	// update category
	private void updateCategory(int categoryId) {

		Category category=userHelper.getCategory(categoryId);
	
		System.out.print(Constants.CATEGORY_NAME_PROMPT);
		readInput();
		category.setCategoryName(input);

		viewCategories();
		System.out.print(Constants.PARENT_CATEGORY_PROMPT);
		readInput();
		category.setParentCategory(Integer.parseInt(input));

		System.out.println(Constants.SEPARATOR);
		System.out.println(userHelper.updateCategory(category));
		
	}
	// delete product
	private void deleteProduct() {

		if(viewAllProducts()>0){
			readInput();
			System.out.println(userHelper.deleteProduct(Integer.parseInt(input)));
		}
	}
	/*
	* seller operations
	*/
	// Seller menu
	private void loadSellerMenu() {

		do{
			if(choice==1) viewSellerCategories();
			else if(choice==2) viewMyProducts();
			else if(choice==3) editProducts();
			else if(choice==4) sellOrders();
			else if(choice==5) break;
			else System.out.println(Constants.INVALID_OPTIONS);
			System.out.println(Constants.SELLER_MENU);
			selectChoice();
		}while(true);
	}
	// view categories
	private int viewSellerCategories(){

		if(viewCategories()>0){
			System.out.print(Constants.SELECT_CATEGORY);
			readInput();
			parentCategory=Integer.parseInt(input);
			while(true){					
				System.out.println(Constants.SEPARATOR);	
				System.out.print(Constants.MOVE_TO_SUBCATEGORIES_ALERT);
				readInput();
				System.out.println(Constants.SEPARATOR);
				if(input.matches(Constants.ACCEPT)&&viewSubCategories(parentCategory)>0){
					System.out.print(Constants.SELECT_CATEGORY);
					readInput();
					parentCategory=Integer.parseInt(input);					
				}
				else break;
				try{
					if(!userHelper.containsCategory(parentCategory))
						throw new NoSuchCategoryException();				
				}
				catch(NoSuchCategoryException noSuchCategoryException){	
					System.out.println(noSuchCategoryException);
					break;				
				}
			}
			return 1;
		}	
		return 0;
	}
	// displays all sellers products 
	private int viewMyProducts() {

		List<Product> products=userHelper.getSellerProducts();
		System.out.println(Constants.SEPARATOR);
		System.out.println(Constants.PRODUCTS);
		System.out.println(Constants.SEPARATOR);	
		if(products.size()>0){
			System.out.println(Constants.PRODUCTS_HEADER);
			System.out.println(Constants.SEPARATOR);
		}else
			System.out.println(Constants.NO_RECORDS);	

		for(Product product:products){
			System.out.println(String.format(Constants.PRODUCTS_FORMAT,product.getProductId(),
					   product.getProductName(),
					   userHelper.getCategory(product.getCategoryId()).getCategoryName(),
					   product.getUnitsAvailable(),product.getProductPrice()));
		}

		System.out.println();
		System.out.println(Constants.SEPARATOR);
		return products.size();	
	}
	// edit products
	private void editProducts()
	{
		
		do{
			if(choice==1)addProduct();
			else if(choice==2) updateProduct();
			else if(choice==3) deleteSellersProduct();
			else if(choice==4) break;
			else System.out.println(Constants.INVALID_OPTIONS);
			System.out.println(Constants.SELLER_PRODUCTS_EDIT_OPTIONS);
			selectChoice();
		}while(true);
	}
	// add product
	private void addProduct()  {

		do{
			Product product=ModelFactory.getProductInstance();

			System.out.print(Constants.PRODUCT_NAME_PROMPT);
			readInput();
			product.setProductName(input);

			System.out.print(Constants.PRODUCT_DESCRIPTON_PROMPT);
			readInput();
			product.setProductDescription(input);

			System.out.print(Constants.PRODUCT_PRICE_PROMPT);
			readInput();
			product.setProductPrice(Long.parseLong(input));

			System.out.print(Constants.PRODUCT_UNITS_PROMPT);
			readInput();
			product.setUnitsAvailable(Integer.parseInt(input));
		
			if(viewSellerCategories()>0)
			{	
				try{
					if(!userHelper.containsCategory(parentCategory))
						throw new NoSuchCategoryException();
					product.setCategoryId(parentCategory);
					System.out.println(Constants.SEPARATOR);
					System.out.println(userHelper.addProduct(product));
				}
				catch(NoSuchCategoryException noSuchCategoryException){
					System.out.println(noSuchCategoryException);		
				}
			}
			System.out.print(Constants.ADD_PRODUCT_ALERT);
			readInput();
			System.out.println(Constants.SEPARATOR);
		}while((input.contains("y")||input.contains("Y"))&&input.length()==1);
	}
	// updating product
	private void updateProduct() {

		if(viewMyProducts()>0)
		{
			System.out.println(Constants.SELECT_PRODUCT);
			readInput();

			Product product=userHelper.getProduct(Integer.parseInt(input));

			System.out.print(Constants.PRODUCT_NAME_PROMPT);
			readInput();
			product.setProductName(input);

			System.out.print(Constants.PRODUCT_UNITS_PROMPT);
			readInput();
			product.setUnitsAvailable(Integer.parseInt(input));
			
			System.out.print(Constants.PRODUCT_PRICE_PROMPT);
			readInput();
			product.setProductPrice(Long.parseLong(input));

			System.out.println(Constants.SEPARATOR);
			System.out.print(userHelper.updateProduct(product));
		}
	}
	// delete product of sellers
	private void deleteSellersProduct() {

		if(viewMyProducts()>0){
			readInput();
			System.out.println(userHelper.deleteProduct(Integer.parseInt(input)));
		}
	}
	// seller accepts orders
	private void sellOrders() {

		if(viewSellerOrders()>0){
			readInput();
			System.out.println(userHelper.sellOrder(Integer.parseInt(input)));
		}
	}
	// displays all orders to the seller
	private int viewSellerOrders() {

		List<Order> orders=userHelper.getSellerOrders();
		System.out.println(Constants.SEPARATOR);
		System.out.println(Constants.ORDERS);
		System.out.println(Constants.SEPARATOR);	
		if(orders.size()>0){
			System.out.println(Constants.ORDERS_HEADER);
			System.out.println(Constants.SEPARATOR);		
		}else
			System.out.println(Constants.NO_RECORDS);
		
		for(Order order:orders){
			System.out.println(String.format(Constants.ORDERS_FORMAT,order.getOrderId(),
					   order.getDate(),order.getDeliveryTime(),order.getUserId()));
		}

		System.out.println();
		System.out.println(Constants.SEPARATOR);
		if(orders.size()>0) System.out.println(Constants.SELECT_TO_SELL);
		return orders.size();
	}
	/*
	* users operations
	*/
	// user menu
	private void loadUserMenu() {
		
		do{
			System.out.println(Constants.USERS_MENU);
			selectChoice();
			if(choice==1) viewProducts();
			else if(choice==2) order();
			else if(choice==3) viewUserOrders();
			else if(choice==4) break;
			else System.out.println(Constants.INVALID_OPTIONS);
		}while(true);
	}
			
	// view products 
	private int viewProducts()
	{
		System.out.println(Constants.VIEW_OPTIONS);
		selectChoice();
		switch(choice){
			case 1:
				return viewAllProducts();
			case 2:
				return viewProductsByCategory();
			default:
				System.out.println(Constants.INVALID_OPTIONS);
				return 0;
		}
	}
	// displays all products 
	private int viewAllProducts() {

		List<Product> products=userHelper.getProducts();
		System.out.println(Constants.SEPARATOR);
		System.out.println(Constants.PRODUCTS);
		System.out.println(Constants.SEPARATOR);	
		if(products.size()>0){
			System.out.println(Constants.PRODUCTS_HEADER);
			System.out.println(Constants.SEPARATOR);		
		}else
			System.out.println(Constants.NO_RECORDS);

		for(Product product:products){
			System.out.println(String.format(Constants.PRODUCTS_FORMAT,product.getProductId(),
					   product.getProductName(),
					   userHelper.getCategory(product.getCategoryId()).getCategoryName(),
					   product.getUnitsAvailable(),product.getProductPrice()));
		}

		System.out.println();
		System.out.println(Constants.SEPARATOR);
		return products.size();
	}
	// displays products by category
	private int viewProductsByCategory(){
		if(viewSellerCategories()>0){
			if(viewProducts(parentCategory)>0){
				
				try{
					if(!userHelper.containsCategory(Integer.parseInt(input)))
						throw new NoSuchCategoryException();				
				}
				catch(NoSuchCategoryException noSuchCategoryException){
					System.out.println(noSuchCategoryException);
				}
				return userHelper.getProducts(parentCategory).size();
			}
			return 0;	
		}
		return 0;	
	}
	// order method to make a order
	private void order() {

		if(viewProducts()>0){
			System.out.print(Constants.SELECT_PRODUCT);
			readInput();
			System.out.println(Constants.SEPARATOR);
			Order order=ModelFactory.getOrderInstance();
			order.setProductId(Integer.parseInt(input));

			order.setUserId(Session.currentUser.getId());
			order.setDate((new Date()).toString());

			System.out.println(userHelper.makeOrder(order));
		}

	}
	// displays all orders of users
	private int viewUserOrders() {

		List<Order> orders=userHelper.getOrders();
		System.out.println(Constants.SEPARATOR);
		System.out.println(Constants.ORDERS);
		System.out.println(Constants.SEPARATOR);	
		if(orders.size()>0){
			System.out.println(Constants.ORDERS_HEADER);
			System.out.println(Constants.SEPARATOR);			
		}
		else
			System.out.println(Constants.NO_RECORDS);
		
		for(Order order:orders){
			System.out.println(String.format(Constants.ORDERS_FORMAT,order.getOrderId(),
					   order.getDate(),order.getDeliveryTime(),order.getUserId()));
		}

		System.out.println();
		System.out.println(Constants.SEPARATOR);
		if(orders.size()>0) System.out.println(Constants.SELECT_TO_SELL);
		return orders.size();
	}
	
	// displays all products of specific category
	private int viewProducts(int categoryId) {

		List<Product> products=userHelper.getProducts(categoryId);
		System.out.println(Constants.SEPARATOR);
		System.out.println(Constants.PRODUCTS);
		System.out.println(Constants.SEPARATOR);	
		if(products.size()>0){
			System.out.println(Constants.PRODUCTS_HEADER);
			System.out.println(Constants.SEPARATOR);		
		}
		else
			System.out.println(Constants.NO_RECORDS);

		for(Product product:products){
			System.out.println(String.format(Constants.PRODUCTS_FORMAT,product.getProductId(),
					   product.getProductName(),
					   userHelper.getCategory(product.getCategoryId()).getCategoryName(),
					   product.getUnitsAvailable(),product.getProductPrice()));
		}

		System.out.println();
		System.out.println(Constants.SEPARATOR);
		return products.size();	
	}
	
	// displays all categories
	private int viewCategories() {

		List<Category> categories=userHelper.getCategories();
		System.out.println(Constants.SEPARATOR);
		System.out.println(Constants.CATEGORIES);
		System.out.println(Constants.SEPARATOR);	
		if(categories.size()>0){
			System.out.println(Constants.CATEGORIES_HEADER);
			System.out.println(Constants.SEPARATOR);		
		}		
		else
			System.out.println(Constants.NO_RECORDS);	

		for(Category category :categories){
			System.out.println(String.format(Constants.CATEGORIES_FORMAT,
					   category.getCatgeoryId(),
					   category.getCategoryName()));
		}

		System.out.println();
		System.out.println(Constants.SEPARATOR);
		return categories.size();	
	}
	// displays all subcategories
	private int viewSubCategories(int categoryId) {

		List<Category> subCategories=userHelper.getSubCategories(categoryId);
		System.out.println(Constants.SUB_CATEGORIES);
		System.out.println(Constants.SEPARATOR);	
		if(subCategories.size()>0){
			System.out.println(Constants.CATEGORIES_HEADER);
			System.out.println(Constants.SEPARATOR);
		}
		else
			System.out.println(Constants.NO_RECORDS);
		
		for(Category subCategory :subCategories){
			System.out.println(String.format(Constants.CATEGORIES_FORMAT,
					   subCategory.getCatgeoryId(),
					   subCategory.getCategoryName()));
		}

		System.out.println();
		System.out.println(Constants.SEPARATOR);
		return subCategories.size();	
	}
	
	// displays users of userType (for admin operations on users)
	private int viewUsers(UserLevel userType){		

		List<User> users=userHelper.getUsers(userType);
		System.out.println(Constants.SEPARATOR);
		System.out.println(Constants.USERS);
		System.out.println(Constants.SEPARATOR);
		if(users.size()>0){
			System.out.println(Constants.USERS_HEADER);
			System.out.println(Constants.SEPARATOR);	
		}	
		else 
			System.out.println(Constants.NO_RECORDS);

		for(User user:users){
			System.out.println(String.format(Constants.USERS_FORMAT,
					   user.getId(),user.getName(),user.getEmail(),
					   user.getPhone(),user.getUserCategory()));
		}

		System.out.println();
		if(users.size()>0) System.out.print(Constants.SELECT_USER);	
		return users.size();
	}
	// displays users (for admin operations on users)
	private int viewUsers(){		

		List<User> users=userHelper.getUsers();
		System.out.println(Constants.SEPARATOR);
		System.out.println(Constants.USERS);
		System.out.println(Constants.SEPARATOR);
		if(users.size()>0){
			System.out.println(Constants.USERS_HEADER);
			System.out.println(Constants.SEPARATOR);
		}else
			System.out.println(Constants.NO_RECORDS);

		for(User user:users){
			System.out.println(String.format(Constants.USERS_FORMAT,
					   user.getId(),user.getName(),user.getEmail(),
					   user.getPhone(),user.getUserCategory()));
		}

		System.out.println();
		System.out.println(Constants.SEPARATOR);
		if(users.size()>0) System.out.print(Constants.SELECT_USER);
		return users.size();
	}
	// register a user to inventory
	private void Register(){

		User user=ModelFactory.getUserInstance();
		user.setUserCategory(UserLevel.User);
		
		System.out.println(Constants.REG_TYPE_PROPMT);
		selectChoice();
		if(choice==1) user.setUserCategory(UserLevel.Seller);
		else if(choice==2) user.setUserCategory(UserLevel.User);
		else System.out.println(Constants.INVALID_OPTIONS);
	
		System.out.print(Constants.NAME_PROMPT);
		readInput();
		user.setName(input);

		System.out.print(Constants.MAIL_PROMPT);
		readInput();
		user.setEmail(input);

		System.out.print(Constants.PHONE_PROMPT);
		readInput();
		user.setPhone(input);

		System.out.print(Constants.PASSWORD_PROMPT);
		readInput();
		user.setPassword(input);

		System.out.println(Constants.SEPARATOR);
		System.out.println(userHelper.addUser(user));
	}
	/*
	*  utility functions
	*/
	// selecting user choice on available options
	private void selectChoice(){

		System.out.println(Constants.SEPARATOR);
		System.out.print(Constants.SELECT_CHOICE);
		choice=Integer.parseInt(console.nextLine());
		System.out.println(Constants.SEPARATOR);
	}
	// reads user's input
	private void readInput(){

		input =console.nextLine();
	}	
}
