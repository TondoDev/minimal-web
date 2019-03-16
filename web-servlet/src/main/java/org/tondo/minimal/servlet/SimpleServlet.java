package org.tondo.minimal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		// values are accessible in servlet init() method called only once, before 
		// servlet is used for the first time
		System.out.println("== Init SimpleServlet");
		String contextParam = getServletContext().getInitParameter("contextParameter");
		String initParameter = getServletConfig().getInitParameter("initialParameter");
		System.out.println("== contextParam (\"contextParameter\"): " + contextParam);
		System.out.println("== initParam (\"initParameter\"): " + initParameter);
	}
	
	@Override
	public void destroy() {
		System.out.println("== Destroy SimpleServlet");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String contextParam = getServletContext().getInitParameter("contextParameter");
		String initParameter = getServletConfig().getInitParameter("initialParameter");
		
		String contextParamConfig = getServletConfig().getInitParameter("contextParameter");
		String initParameterContext = getServletContext().getInitParameter("initialParameter");
	
		PrintWriter writer = resp.getWriter();
		writer.append("<h1>Pure servlet output!</h1>");
		writer.append("<p>This is contextParam <b>" + contextParam + "</b> read from <i>ServletContext</i> " + 
				"and this is servlet init parameter <b>" + initParameter + "</b> read from <i>ServletConfig</i> </p>");
		
		writer.append("When read in opposite way: <p>This is contextParam <b>" + contextParamConfig + "</b> read from <i>getServletConfig</i> " + 
				"and this is servlet init parameter <b>" + initParameterContext + "</b> read from <i>getServletContext</i> </p>");
		writer.append("<p><a href=\"home.html\">Home</a></p>");
	}
}
