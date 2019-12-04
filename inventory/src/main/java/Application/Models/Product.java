package Application.Models;

//Product Model


public class Product {
	private int productId;
	private int unitsAvailable;
	private String productName;
	private long productPrice;
	private String productDescription;
	private int categoryId;
	private int userId=0;
	private String src="./demo.jpeg";
	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId=userId;
	}
	public int getUnitsAvailable() {
		return unitsAvailable;
	}
	public void setUnitsAvailable(int unitsAvailable) {
		this.unitsAvailable = unitsAvailable;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
