package org.tondo.minimal.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormProcessor extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("received Params: ");
		System.out.println("Name: " + req.getParameter("name"));
		System.out.println("Surname: " + req.getParameter("surname"));
		
		req.setAttribute("fullname", req.getParameter("name") + "_" + req.getParameter("surname"));
		req.getRequestDispatcher("display.jsp").forward(req, resp);
	}

}
