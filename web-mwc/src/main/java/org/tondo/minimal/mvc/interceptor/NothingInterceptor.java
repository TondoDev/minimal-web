package org.tondo.minimal.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class NothingInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("Interceptor preHandle: " + this.getClass().getCanonicalName() + " \"" + request.getRequestURI() + "\"");
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		System.out.println("Interceptor postHandle: " + this.getClass().getCanonicalName() + " \"" + request.getRequestURI() + "\"");
	}

}
