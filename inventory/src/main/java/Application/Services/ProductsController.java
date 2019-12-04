package Application.Services;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Application.Models.Product;
import Application.Server.*;

@RestController
@RequestMapping("/products")
public class ProductsController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Product> getProducts(){
		return DBHelper.getProducts();
	} 
	@RequestMapping(value="",method=RequestMethod.GET)
	public List<Product> getProducts(@RequestParam("categoryId")int categoryId){
		return DBHelper.getProducts(categoryId);
	}
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public@ResponseBody Product getProduct(@RequestParam("productId")int productId) {
		return DBHelper.getProduct(productId);
	}
	@RequestMapping(value="",method=RequestMethod.POST)
	public String addProduct(@RequestBody Product product) {
		return DBHelper.addProduct(product);
	}
	public List<Product> getSellerProducts(@RequestParam("isSeller")boolean isSeller){
		return DBHelper.getSellerProducts();
	}
}
