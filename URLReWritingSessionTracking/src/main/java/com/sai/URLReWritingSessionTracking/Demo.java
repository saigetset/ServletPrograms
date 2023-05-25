package com.sai.URLReWritingSessionTracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/demo")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String college =  request.getParameter("college");
		String branch = request.getParameter("branch");
		System.out.println(college);
		System.out.println(branch);
		HttpSession session = request.getSession(false);
		session.setAttribute("college", college);
		session.setAttribute("branch", branch);
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:brown;'>Enter Student details</h1>");
		out.println("<form method='GET' action='" + response.encodeURL("./reg") + "'>");
		out.println("<table>");
		out.println("<tr><th>City</th><td><input type='text' name='city'/></td></tr>");
		out.println("<tr><th>ZIP Code</th><td><input type='text' name='zip'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='next page'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
