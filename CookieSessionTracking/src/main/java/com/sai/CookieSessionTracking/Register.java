package com.sai.CookieSessionTracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city =  request.getParameter("city");
		String zip = request.getParameter("zip");
		Cookie[] cookies = request.getCookies();
		String name = cookies[0].getValue();
		String age = cookies[1].getValue();
		String college = cookies[2].getValue();
		String branch = cookies[3].getValue();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<center><h1 style='color:brown'> Student Details</h1>");
		out.println("<table border='1'>");
		
		  out.println("<tr><td>Name : </td><td>"+name+"</td></tr>");
		  out.println("<tr><td>Age : </td><td>"+age+"</td></tr>");
		  out.println("<tr><td>College : </td><td>"+college+"</td></tr>");
		  out.println("<tr><td>Branch : </td><td>"+branch+"</td></tr>");
		  out.println("<tr><td>City : </td><td>"+city+"</td></tr>");
		  out.println("<tr><td>ZIP Code : </td><td>"+zip+"</td></tr>");
		 	
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");		
		out.println("</html>");
	}

}
