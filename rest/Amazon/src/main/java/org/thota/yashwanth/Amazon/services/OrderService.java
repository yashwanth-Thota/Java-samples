package org.thota.yashwanth.Amazon.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.thota.yashwanth.Amazon.models.order;

@Path("/orders")
public class OrderService {
	@GET
		public order getOrder(){
			return new order();
		}
}
