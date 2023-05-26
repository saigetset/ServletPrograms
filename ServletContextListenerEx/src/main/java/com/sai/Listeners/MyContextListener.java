package com.sai.Listeners;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
	public static int count=0;
    public MyContextListener() {
    	System.out.println("MyContextListener.MyContextListener()");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	count--;
    	System.out.println("count is"+count);
    	System.out.println("MyContextListener.contextDestroyed()");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	count++;//will become one while initialization
    	System.out.println("MyContextListener.contextInitialized()::"+count);
    }
	
}
