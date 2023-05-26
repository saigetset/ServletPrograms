package com.sai.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("Servlet .class loaded");
	}
	public TestServlet() {
		System.out.println("TestServlet.TestServlet()");
	}
	
	@Override
	public void init() {
		System.out.println("TestServlet.init()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("sai", "python");
		request.setAttribute("hari", "java");
		request.setAttribute("siva", "c++");
		request.setAttribute("vamsi", "mojo");
		request.removeAttribute("vamsi");
		request.setAttribute("siva","c");
		
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:brown'>hello</h1>");
	}

}
