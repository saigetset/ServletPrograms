package com.sai.servlets;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body><center>");
		out.println("<h1 style='color:brown'>Employee details</h1>");
		out.println("<table><tr><td>ID</td><td>"+request.getParameter("id")+"</td></tr>");
		out.println("<tr><td>Name</td><td>"+request.getParameter("name")+"</td></tr>");
		out.println("<tr><td>Age</td><td>"+request.getParameter("age")+"</td></tr>");
		out.println("<tr><td>MailID</td><td>"+request.getParameter("mail")+"</td></td></tr>");
		out.println("<tr><td>Mobile</td><td>"+request.getParameter("mobile")+"</td></tr>");
		out.println("</table>");
		out.println("</form></center></body></html>");
	}

}
