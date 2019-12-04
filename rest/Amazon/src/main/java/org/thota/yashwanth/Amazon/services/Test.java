package org.thota.yashwanth.Amazon.services;

import org.thota.yashwanth.Amazon.dataSource.UserServer;

public class Test {
	public static void main(String [] a){
		UserServer u=new UserServer();
		System.out.println(u.getUser(2)+"asdas");
	}
}