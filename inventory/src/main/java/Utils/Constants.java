package Utils;
import Application.Models.User;
// Contains all string literals used in application
public class Constants {
	public static String ADMIN_MENU=String.format("%s\r\n%s\r\n%s","1. ADD","2. EDIT","3. BACK");
	public static String ADMIN_ADD_MENU=String.format("%s\r\n%s\r\n%s\r\n%s\r\n%s","1. ADD ADMIN","2. ADD SELLER","3. ADD CATEGORY","4. ADD SUBCATEGORY","5. BACK");
	public static String ADMIN_EDIT_MENU=String.format("%s\r\n%s\r\n%s\r\n%s\r\n%s","1. DELETE USER","2. EDIT SELLER","3. DELETE PRODUCT","4. EDIT CATEGORY","5. BACK");
	
	public static String SELLER_MENU=String.format("%s\r\n%s\r\n%s\r\n%s\r\n%s","1. VIEW CATEGORIES","2. VIEW MY PRODUCTS","3. EDIT PRODUCTS","4. SELL ORDERS","5. BACK");
	public static String SELLER_PRODUCTS_EDIT_OPTIONS=String.format("%s\r\n%s\r\n%s\r\n%s","1. ADD PRODUCT","2. UPDATE PRODUCT","3. DELETE PRODUCT","4. BACK");
	public static String SELECT_TO_SELL=String.format("%s","Select order to sell:" );

	public static String USERS_MENU=String.format("%s\r\n%s\r\n%s\r\n%s","1. VIEW PRODUCTS ","2. ORDER","3. VIEW ORDERS","4. BACK");

	public static String INVALID_CREDENTIALS="Invalid login details !";

	public static String LOGIN_SUCCESS="Login successfull !";
	public static String REGISTER_SUCCESS="Registration success!";
	
	public static String ACCOUNT_INACTIVE_ALERT="Your account is not enabled contact the admin!!";
	public static String USER_EXISTS="Already exists!";
	public static String EDIT_OPTIONS=String.format("%s\r\n%s","1. UPDATE","2. DELETE");
	public static String VIEW_OPTIONS="1. VIEW ALL PRODUCTS\t2. VIEW PRODUCTS BY CATEGORY";	
	
	public static String REG_TYPE_PROPMT="Register as:\n1. Seller  2. Customer";
	public static String EDIT_SUB_CATEGORY_PROPMT="Do you want to edit sub category (y|n)?:";
	public static String DEL_ALERT="Do you want to delete (y|n)?:"; 
	public static String ADD_CATEGORY_ALERT="Do you want to add new category (y|n)?:";
	public static String ADD_SUBCATEGORY_ALERT="Do you want to add new sub category (y|n)?:";
	public static String ADD_PRODUCT_ALERT="Do you want to add new product (y|n)?:";
	public static String PRODUCTS="PRODUCTS";
	public static String USERS="USERS";
	public static String CATEGORIES="CATEGORIES";
	public static String SUB_CATEGORIES="SUBCATEGORIES";
	public static String ORDERS="ORDERS";
	public static String NO_ADMIN_RECORDS="No admins found!!";
	public static String NO_SELLER_RECORDS="No users found to add to admins group!!!";
	public static String NO_USER_RECORDS="No users exists!";
	public static String NO_PRODUCT_RECORDS="Given product doesnot exist!";
	public static String NO_CATEGORY_RECORDS="Given category doesnot exists!";
	public static String NO_ORDER_RECORDS="Order doesnot exists!";
	public static String NO_RECORDS="No Records!!";
	public static String LOGGED_IN_MENU=String.format("%s\r\n%s", "1. LOGOFF","2. MENU");
	public static String LOGGED_OFF_MENU=String.format("%s\r\n%s\r\n%s", "1. LOGIN ","2. VIEW PRODUCTS","3. REGISTER");	

	public static String MOVE_TO_SUBCATEGORIES_ALERT="Do you want select from sub categories (y|n)?";
	public static String ACCEPT="[y|Y]";
	public static String INVALID_OPTIONS = "Invalid Option";
	
	public static String NAME_PROMPT	  ="Enter Name :";
	public static String MAIL_PROMPT      ="Enter Email :";
	public static String PHONE_PROMPT 	  ="Enter Phone Number :";
	public static String PASSWORD_PROMPT ="Enter Password :";
	
	public static String PRODUCT_NAME_PROMPT	   ="Enter product name :";
	public static String PRODUCT_PRICE_PROMPT      ="Enter product price :";
	public static String PRODUCT_UNITS_PROMPT 	   ="Enter product available units :";
	public static String PRODUCT_DESCRIPTON_PROMPT ="Enter product descripton :";
	public static String PRODUCT_CATEGORY_PROMPT   ="Enter product category	 :";
	
	public static String CATEGORY_NAME_PROMPT	     ="Enter category name :";
	public static String PARENT_CATEGORY_PROMPT_WITH_ADD      ="Enter parent category id(0 to add new parent category):";
	public static String PARENT_CATEGORY_PROMPT     ="Enter parent category id:";

	public static String PRODUCT_ID_PROMPT ="Enter product id to place order :";

	public static String UPDATE_OPTIONS="Only phone, name and password can be updated!!";
	public static String SELECT_USER="Select the user id:";
	public static String SELECT_PRODUCT="Select the product id:";
	public static String SELECT_CATEGORY_WITH_ADD="Select the category id(0 to add new category):";
	public static String SELECT_CATEGORY="Select the category id:";
	public static String SELECT_ORDER="Select the order id:";
	public static String SELECT_SUB_CATEGORY_WITH_ADD="Select the sub  category id(0 to add new category):";
	public static String SELECT_SUB_CATEGORY="Select the sub category id:";

	public static String ORDER_SUCCESS="Order placed successfully!";
	public static String ORDER_FAIL="Presently unable process order!!";
	public static String ORDER_ACCEPTED="order accepted!!";	

	public static String ORDERS_FORMAT="%5s %35s %10s days %13s";
	public static String CATEGORIES_FORMAT="%6s %13s";
	public static String PRODUCTS_FORMAT="%5s %15s %18s %18s %12s";
	public static String USERS_FORMAT="%5s %15s %13s %20s %10s";
	public static String ORDERS_HEADER=String.format("%5s %25s %25s %10s", "ORDERID","ORDER_DATE","DELIVERY_DATE","User");
	public static String CATEGORIES_HEADER=String.format("%8s %15s", "CATEGORY_ID","CATEGORY_NAME");
	public static String PRODUCTS_HEADER=String.format("%10s %15s %20s %18s %8s", "PRODUCT_ID","PRODUCT_NAME","CATEGORY","AVAILABLE_UNITS","PRICE");
	public static String USERS_HEADER=String.format("%5s %15s %12s %18s %10s", "USER_ID","USER_NAME","EMAIL","PHONE","TYPE");

	public static String SEPARATOR="-------------------------------------------------------------------------";

	public static String SUCCESS_ALERT="operation successfully completed!";
	public static String SELECT_CHOICE="select your option ->";

}
