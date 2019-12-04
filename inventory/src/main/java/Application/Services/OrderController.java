package Application.Services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Application.Models.Order;
import Application.Server.DBHelper;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Order> getSellerOrders(@RequestParam("id")int id){
		return DBHelper.getSellerOrders(id);
	}
	@RequestMapping(value="",method=RequestMethod.GET)
	public List<Order> getOrders(@RequestParam("id")int id){
		return DBHelper.getOrders(id);
	}
	@RequestMapping(value="",method=RequestMethod.POST)
	public String makeOrder(@RequestBody Order order) {
		return DBHelper.makeOrder(order);
	}
	@RequestMapping(value="/sellOrder")
	public String sellOrder(@RequestParam("orderId") int orderId) {
		return DBHelper.sellOrder(orderId);
	}
}