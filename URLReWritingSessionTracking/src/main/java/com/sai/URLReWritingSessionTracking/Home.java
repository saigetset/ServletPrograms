package com.sai.URLReWritingSessionTracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =  request.getParameter("name");
		String age = request.getParameter("age");
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("age", age);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:brown;'>Enter Student details</h1>");
		out.println("<form method='POST' action='" + response.encodeURL("./demo") + "'>");
		out.println("<table>");
		out.println("<tr><th>College</th><td><input type='text' name='college'/></td></tr>");
		out.println("<tr><th>Branch</th><td><input type='text' name='branch'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='next page'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
