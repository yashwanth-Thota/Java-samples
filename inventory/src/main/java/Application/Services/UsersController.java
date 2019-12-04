package Application.Services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Application.Models.*;
import Application.Server.DBHelper;
@RestController
@RequestMapping("/users")
public class UsersController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<User> getUsers() {
		return DBHelper.getUsers();
	}
	@RequestMapping(value="",method=RequestMethod.GET)
	public @ResponseBody User getUser(@RequestParam("id")int id) {
		return DBHelper.getUser(id);
	}
	@RequestMapping(value="",method=RequestMethod.POST)
	public String addUser( @RequestBody User user ) {
		return DBHelper.addUser(user);
	}
	@RequestMapping(value="",method=RequestMethod.DELETE)
	public String deleteUser(@RequestParam("userId")int userId) {
		return DBHelper.deleteUser(userId);
	}
	@RequestMapping("*/error")
	public String error() {
		return "NO RECORDS!!!";
	}
}
