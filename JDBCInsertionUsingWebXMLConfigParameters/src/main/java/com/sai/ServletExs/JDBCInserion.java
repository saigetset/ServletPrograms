package com.sai.ServletExs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JDBCInserion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	
	@Override
	public void init() throws ServletException {
		System.out.println("Config object created and got the values from config object...\n\n");

		String url = getInitParameter("url");
		String username = getInitParameter("username");
		String password = getInitParameter("password");
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if(con!=null) {
				pstmt = con.prepareStatement("Insert into emp(name,age) values(?,?)");
				pstmt.setString(1,request.getParameter("name"));
				pstmt.setInt(2, Integer.parseInt(request.getParameter("age")));
				
				int val= pstmt.executeUpdate();
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				if(val == 1)
					out.println("<h1 style='color:red'>Insertion Successful</h1>");
				else
					out.println("<h1 style='color:red'>Insertion failed</h1>");
				out.println("</body></html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
