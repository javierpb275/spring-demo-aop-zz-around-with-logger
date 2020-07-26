package com.javi.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javi.aopdemo.dao.AccountDAO;
import com.javi.aopdemo.dao.MembershipDAO;
import com.javi.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	public static Logger myLogger =
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService= 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\nMy fortune is: " + data);
			
		myLogger.info("Finished");//we are gonna print the data to that logger output string that 's the on that spring framework is using to keep things in order and synchronized
					
		// close the context
		context.close();
		
	}

}
