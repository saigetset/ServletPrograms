package com.sai.HttpSessionTracking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/reg")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city =  request.getParameter("city");
		String zip = request.getParameter("zip");
		HttpSession session = request.getSession();
		session.setAttribute("city", city);
		session.setAttribute("zip", zip);

		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<center><h1 style='color:brown'> Student Details</h1>");
		out.println("<table border='1'>");
		
		/* out.println("<tr><td>Name : </td><td>"+session.getAttribute("name")+
		 * "</td></tr>");
		 * out.println("<tr><td>Age : </td><td>"+session.getAttribute("age")+
		 * "</td></tr>");
		 * out.println("<tr><td>College : </td><td>"+session.getAttribute("college")+
		 * "</td></tr>");
		 * out.println("<tr><td>Branch : </td><td>"+session.getAttribute("branch")+
		 * "</td></tr>");
		 * out.println("<tr><td>City : </td><td>"+session.getAttribute("city")+
		 * "</td></tr>");
		 * out.println("<tr><td>ZIP Code : </td><td>"+session.getAttribute("zip")+
		 * "</td></tr>");
		 */
		Enumeration<String> names = session.getAttributeNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String value = (String) session.getAttribute(name);
			out.println("<tr><td>"+name+"</td><td>"+value+"</td></tr>");
		}
		
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");		
		out.println("</html>");
	}

}
