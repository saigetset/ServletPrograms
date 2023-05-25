package com.sai.CookieSessionTracking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =  request.getParameter("name");
		String age = request.getParameter("age");
		Cookie c1 = new Cookie("name",name);
		Cookie c2 = new Cookie("age",age);
		response.addCookie(c1);
		response.addCookie(c2);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./demo.html");
		requestDispatcher.forward(request, response);
	}

}
