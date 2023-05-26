package com.sai.Listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestAttributeListenerEx implements ServletRequestAttributeListener {

    public RequestAttributeListenerEx() {
    	System.out.println("RequestAttributeListenerEx.RequestAttributeListenerEx()");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	System.out.println("RequestAttributeListenerEx.attributeRemoved()::"+srae.getName()+"removed");
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	System.out.println("RequestAttributeListenerEx.attributeAdded()::"+srae.getName()+"added");
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	
    	System.out.println("RequestAttributeListenerEx.attributeReplaced() ::"+srae.getName()+"replaced");
    }
	
}
