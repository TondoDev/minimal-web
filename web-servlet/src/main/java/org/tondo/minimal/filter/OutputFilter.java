package org.tondo.minimal.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class OutputFilter  implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		PrintWriter output = response.getWriter();
		System.out.println("== doFilter Output before");
		output.append("<p><font color=\"red\">Prepended by filter!</font></p>");
		chain.doFilter(request, response);
		output.append("<p><font color=\"blue\">Appended by filter!</font></p>");
		System.out.println("== doFilter Output after");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}

