package com.sai.ServletExs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHeaderContents
 */
@WebServlet("/test")
public class RequestHeaderContents extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String>  headerNames = request.getHeaderNames();
		PrintWriter out = response.getWriter();
		out.println("<html><center><body style='bgcolor: white;color: brown'><table border='1'>");
		while(headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			out.println("<tr><td>");
			out.println(headerName);
			out.println("</td><td>");
			out.println(headerValue+"</td></tr>");
		}
		out.println("</table></body></center></html>");
	}

}
