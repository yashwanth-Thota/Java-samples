package org.thota.yashwanth.Amazon.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.thota.yashwanth.Amazon.dataSource.UserServer;
import org.thota.yashwanth.Amazon.models.product;
import org.thota.yashwanth.Amazon.models.user;

@Path("/products")
public class ProductService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<product> getProducts(){
		return new UserServer().getProducts();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public product addProduct(){
		product p=new product();
		p.setProduct_id(1);
		p.setCategory_id(1);
		p.setProduct_description("available now");
		p.setProduct_price(125);
		p.setUser_id(1);
		p.setUnits(20);
		p.setPayment_mode(1);
		return p;
	}
}
