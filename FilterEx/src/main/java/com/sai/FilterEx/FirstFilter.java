package com.sai.FilterEx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/test")
public class FirstFilter implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter initialized");
	}
   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:brown'>This is before filtering</h1>");
		chain.doFilter(request, response);
		out.println("<h1 style='color:brown'>This is after filtering</h1>");
	}

	public void destroy() {
		
	}

}
