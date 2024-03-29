package org.tondo.minimal.mvc.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class RequestInterceptor implements WebRequestInterceptor{

	@Override
	public void preHandle(WebRequest request) throws Exception {
		System.out.println("WebRequestInterceptor preHandle: " + this.getClass().getCanonicalName() + " \"" + request.getContextPath() + "\"");
		
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		System.out.println("WebRequestInterceptor postHandle: " + this.getClass().getCanonicalName() + " \"" + request.getContextPath() + "\"");
		
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
