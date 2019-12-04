package com.yashwanth.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AttributeProvider extends javax.servlet.http.HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		req.setAttribute("level", req.getParameter("attr")+" from request");
		getServletConfig().getServletContext().setAttribute("level", req.getParameter("attr")+" from context");
		PrintWriter out=resp.getWriter();
		out.println("<a href='/Servlet-samples/requestConsumer'>SEND ME TO REQUEST CONSUMER</a><br/><br/>");
		out.println("<a href='/Servlet-samples/contextConsumer'>SEND ME TO CONTEXT CONSUMER</a>");
		out.close();
	}
}