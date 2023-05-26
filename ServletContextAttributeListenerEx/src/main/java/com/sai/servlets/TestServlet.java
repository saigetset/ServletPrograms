package com.sai.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		context.setAttribute("sai", "java");
		context.setAttribute("siva", "python");
		context.setAttribute("hari", "c++");
		context.setAttribute("vamsi", "brainf**k");
		context.removeAttribute("hari");
		context.setAttribute("sai","mojo");
		
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:brown'>Hola!</h1>");
	}

}
