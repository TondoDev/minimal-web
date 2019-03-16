package org.tondo.minimal.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("== Init SimpleFilter");
		System.out.println("== firstFilterParam " + filterConfig.getInitParameter("firstFilterParam"));
		System.out.println("== secondFilterParam " + filterConfig.getInitParameter("secondFilterParam"));
		
	}
	
	@Override
	public void destroy() {
		System.out.println("== Destroy SimpleFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("== doFilter SimpleFilter before");
		chain.doFilter(request, response);
		System.out.println("== doFilter SimpleFilter after");
	}

}
