package com.sai.CustomizedReq;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomizedRequest extends HttpServletRequestWrapper{

	public CustomizedRequest(HttpServletRequest request) {
		super(request);
	}
	

	@Override
	public String getParameter(String name) {
		String value=super.getParameter(name);
		if(value.equalsIgnoreCase("java"))
			value = "python";
		return value;
	}

}
