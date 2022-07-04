package org.tondo.minimal.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.ConversionServiceExposingInterceptor;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.tondo.minimal.mvc.data.InfoData;
import org.tondo.minimal.mvc.data.conversion.InfoFormatter;
import org.tondo.minimal.mvc.interceptor.ModelInterceptor;
import org.tondo.minimal.mvc.interceptor.NothingInterceptor;
import org.tondo.minimal.mvc.interceptor.RequestInterceptor;

// configuration annotation needed to be this setting loaded
@Configuration
public class MvcConfig  implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry ) {
		
		//registry.enableContentNegotiation( new MappingJackson2JsonView());
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// Static resource must be registered as redirect controller,
		registry.addRedirectViewController("/", "/res/index.html");
		
		
		// this will be processed by ViewResolver without redirect 
		// ViewRrsolver determine suffix and prefix for view
		// We have the controller with "/sample" mapping returning the same view,
		// but now it won't be executed
		registry.addViewController("/sp").setViewName("samplePage");
		// NOTES: SimpleUrlHandlerMapping is created for ViewControllers
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/res/**") // request to all subfolder of /res/
			.addResourceLocations("/static/")	// will be searched relative in /static/ folder (webapp/static/..)
			// Cache-Control: max-age=0
			.setCachePeriod(0) // sends http headers which prevents caching, for development stages
			.resourceChain(true) // automatically, create CachingResourceResolver
		//	.addResolver(new EncodedResourceResolver())
			;
		
		VersionResourceResolver vesionResolver = new VersionResourceResolver().addContentVersionStrategy("/**");
		
		registry.addResourceHandler("/css/**") // request to all subfolder of /res/
			.addResourceLocations("/static/css/")
			.setCachePeriod(0)
			.resourceChain(false)
			.addResolver(vesionResolver);
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// for all requsts
		registry.addInterceptor(new NothingInterceptor());
		// only for request matching the pattern
		registry.addInterceptor(new ModelInterceptor()).addPathPatterns("/sample");
		
		registry.addWebRequestInterceptor(new RequestInterceptor()).addPathPatterns("/sp");
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatterForFieldType(InfoData.class, new InfoFormatter("cf"));
	}
}
