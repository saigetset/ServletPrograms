package com.sai.Listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextAttributeListener implements ServletContextAttributeListener {

    public MyContextAttributeListener() {
    	System.out.println("MyContextAttributeListener.MyContextAttributeListener()");
    }

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	System.out.println("MyContextAttributeListener.attributeAdded() ::"+scae.getName()+"added");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	System.out.println("MyContextAttributeListener.attributeRemoved()::"+scae.getName()+"removed");
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	System.out.println("MyContextAttributeListener.attributeReplaced()::"+scae.getName()+"replaced");
    }
	
}
