package com.sai.HttpSessionTracking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		HttpSession session = request.getSession();
		session.setAttribute("college", college);
		session.setAttribute("branch", branch);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./register.html");
		requestDispatcher.forward(request, response);
	}

}
