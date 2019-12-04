package org.thota.yashwanth.Amazon.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.thota.yashwanth.Amazon.dataSource.UserServer;
import org.thota.yashwanth.Amazon.models.user;

@Path("/users")
public class UserService {
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public user getUser(@PathParam("id") int id){
		UserServer u=new UserServer();
		return u.getUser(id);
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public user addUser(user u){
		return new UserServer().addUser(u);
	}
	
}
