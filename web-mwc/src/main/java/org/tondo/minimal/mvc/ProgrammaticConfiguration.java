package org.tondo.minimal.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
// this is needed for instantiation of MVC components, hoverer DispatcherServlet is registered and request can reach it.
// MVC components are instantiated in WebMvcConfigurationSupport, 
@EnableWebMvc
public class ProgrammaticConfiguration {
	
	public ProgrammaticConfiguration() {
			System.out.println("Programmatioc configuration");
	}
	
	@Bean
	public String message() {
		return "hallo";
	}
	

	// actual rendering is done by Tomcant JSP servlet, where views resolved by this
	// view resolver, are forwarded. Be careful with mapping of DispatcherServlet to '/*' pattern,
	// because this overrides all default servlets provided by container.
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    //bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/view/");
	    bean.setSuffix(".jsp");
	    return bean;
	}	

}
