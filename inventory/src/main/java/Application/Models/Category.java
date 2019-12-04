package Application.Models;

//Category Model
//parentCategory to Store the root category ny default every category is root category


public class Category  {
	private int catgeoryId;
	private String categoryName;
	private int parentCategory=0;
	public Category() {}
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	public int getCatgeoryId() {
		return catgeoryId;
	}
	public void setCatgeoryId(int catgeoryId) {
		this.catgeoryId = catgeoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(int parentCategory) {
		this.parentCategory = parentCategory;
	}	
}
