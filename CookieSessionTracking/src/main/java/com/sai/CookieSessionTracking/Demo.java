package com.sai.CookieSessionTracking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String college =  request.getParameter("college");
		String branch = request.getParameter("branch");
		Cookie c3 = new Cookie("college",college);
		Cookie c4 = new Cookie("branch",branch);
		response.addCookie(c3);
		response.addCookie(c4);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./register.html");
		requestDispatcher.forward(request, response);
	}

}
