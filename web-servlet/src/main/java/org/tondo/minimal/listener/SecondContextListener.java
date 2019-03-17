package org.tondo.minimal.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SecondContextListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("SecondContextListener: destroy" );
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("SecondContextListener: init" );
	}

}
