package com.sai.DisplayServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public static Connection con=null;

	PreparedStatement pstmt=null;

	ResultSet rs;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		System.out.println("Config object created and got the values from config object...\n\n");

		String url = context.getInitParameter("url");
		String username = context.getInitParameter("username");
		String password = context.getInitParameter("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		try {
			con = DriverManager.getConnection(url, username, password);
			if (con != null) {
				System.out.println("Connection established succesfully....");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			pstmt = con.prepareStatement("Select * from emp where id=?");
			if(pstmt!=null)
				pstmt.setInt(1,Integer.parseInt(request.getParameter("id")));
			rs = pstmt.executeQuery();
			rs.next();
			if(rs!=null) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				PrintWriter out = response.getWriter();
				out.println("<html><body><center>");
				out.println("<h1 style='color:brown'>Using POST</h1>");
				out.println("<h2 style='color:brown'>The details are</h1>");
				out.println("<table border='1'><tr>");
				out.println("<td>id</td>");
				out.println("<td>name</td>");
				out.println("<td>age</td></tr>");
				out.println("<tr>");
				out.println("<td>"+id+"</td>");
				out.println("<td>"+name+"</td>");
				out.println("<td>"+age+"</td></tr></table");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
