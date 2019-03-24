package org.tondo.minimal.jstl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet  extends HttpServlet{
	
	private static int counter = 0;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HomeServlet");
		counter++;
		
		req.setAttribute("fullname", "Anton " + counter);
		System.out.println("HomeServlet " + req.getAttribute("fullname"));
		req.getRequestDispatcher("uvod.jsp").forward(req, resp);
	}
}
