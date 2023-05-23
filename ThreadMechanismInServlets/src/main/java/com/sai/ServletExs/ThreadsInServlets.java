package com.sai.ServletExs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class ThreadsInServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:brown'>Servlet Object address is: "+this.hashCode());
		out.println("<h1 style='color:brown'>Request Object address is: "+request.hashCode());
		out.println("<h1 style='color:brown'>Response Object address is: "+response.hashCode());
		out.println("<h1 style='color:brown'>Request Thread Object address is: "+Thread.currentThread().hashCode());
	}

}
