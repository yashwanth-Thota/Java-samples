package Application.Services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Application.Models.Category;
import Application.Server.DBHelper;
@RestController
@RequestMapping("/categories")
public class CategoryController {

	@RequestMapping(value="",method=RequestMethod.POST)
	public String addCategory(@RequestBody Category category)
	{
		return DBHelper.addCategory(category);
	}
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String updateCategory(@RequestBody Category category) {
		return DBHelper.addCategory(category);
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Category> getCategories(){
		return DBHelper.getCategories();
	}
	@RequestMapping(value="/getSubCategories",method=RequestMethod.GET)
	public List<Category> getSubCategories(@RequestParam("categoryId")int categoryId){
		return DBHelper.getSubCategories(categoryId);
	}
	@RequestMapping(value="",method=RequestMethod.DELETE)
	public String deleteCategory(@RequestParam("categoryId")int categoryId) {
		return DBHelper.deleteCategory(categoryId);
	}
}
