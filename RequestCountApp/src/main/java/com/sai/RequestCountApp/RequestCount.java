package com.sai.RequestCountApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/count")
public class RequestCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		ServletContext context = getServletContext();
		Integer count = (Integer) context.getAttribute("count");
		
		if(count == null) {
			count=1;
		}
		else {
			count++;
		}
		context.setAttribute("count", count);
		PrintWriter out = response.getWriter();
		out.println("<h1  style:'color=brown'>The Request Count is: "+count+"</h1>");
	}

}
