package com.sai.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sai.Listeners.MyRequestListener;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("Servlet .class file is loaded");
	}
	
	public TestServlet() {
		System.out.println("Servlet got instantiated");
	}
	
	@Override
	public void init() throws ServletException{
		System.out.println("Servlet got initialized");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:brown'>Welcome to Servlet</h1>");
		out.println("<h1 style='color:brown'>The number of hits for this application: "+MyRequestListener.count+"</h1>");
		System.in.read();
	}

}
