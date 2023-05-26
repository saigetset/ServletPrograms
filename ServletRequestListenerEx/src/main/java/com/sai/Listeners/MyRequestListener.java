package com.sai.Listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener implements ServletRequestListener {
	public static int count=0;

    public MyRequestListener() {
    	System.out.println("Listener got instantiated");
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("Listener got destroyed");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	count++;
    	System.out.println("Request/Hit count: "+count);
    	System.out.println("Listener got initialized");
    }
	
}
