package com.sai.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/test")
public class Filter1 implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String mail = request.getParameter("mail");
		String mobile = request.getParameter("mobile");
		
		String idErrorMsg="",nameErrorMsg="",ageErrorMsg="",mailErrorMsg="",mobileErrorMsg="";
		boolean flag=true;
		
		if(id == null || id.equals("")) {
			idErrorMsg = "Employee ID is required!";
			flag=false;
		}else if(!id.startsWith("17FE1A")) {
			idErrorMsg = "Employee ID should start with 17FE1A";
			flag=false;
		}
		
		if(name == null || name.equals("")) {
			nameErrorMsg = "Employee Name is required!";
			flag=false;
		}else if(name.length()>15) {
			nameErrorMsg = "Employee Name should have <= 15 characters";
		}
		
		if(age == null || age.equals("")) {
			ageErrorMsg = "Employee Age is required!";
			flag=false;
		}else if(Integer.parseInt(age)<20) {
			ageErrorMsg = "Employee Age must be >=20";
			flag=false;
		}
		
		if(mail == null || mail.equals("")) {
			mailErrorMsg = "Employee Mail is required!";
			flag=false;
		}else if(!mail.endsWith("@gmail.com")) {
			mailErrorMsg = "Employee mail should end with @gmail.com";
			flag=false;
		}
		
		if(mobile == null || mobile.equals("")) {
			mobileErrorMsg = "Employee Mobile number is required!";
			flag=false;
		}else if(!mobile.startsWith("+1")) {
			mobileErrorMsg = "Employee Mobile Number should start with +1";
			flag=false;
		}
		
		
		///////////////////////////////////////////////////////////
		if(flag == true)
			chain.doFilter(request, response);
		else {
			PrintWriter out = response.getWriter();
			out.println("<html><body><center><form method='GET' action='./test'>");
			out.println("<h1 style='color:brown'>Enter the Employee details</h1>");
			out.println("<table><tr><td>ID</td><td><input type='text' name='id' /></td><td><font color='red' size='5'>"+idErrorMsg+"</td></tr>");
			out.println("<tr><td>Name</td><td><input type='text' name='name' /></td><td><font color='red' size='5'>"+nameErrorMsg+"</td></tr>");
			out.println("<tr><td>Age</td><td><input type='text' name='age' /></td><td><font color='red' size='5'>"+ageErrorMsg+"</td></tr>");
			out.println("<tr><td>MailID</td><td><input type='text' name='mail' /><td><font color='red' size='5'>"+mailErrorMsg+"</td></td></tr>");
			out.println("<tr><td>Mobile</td><td><input type='text' name='mobile' /></td><td><font color='red' size='5'>"+mobileErrorMsg+"</td></tr>");
			out.println("<tr><td></td><td><input type='submit' value='submit' /></td></tr>");
			out.println("</table>");
			out.println("</form></center></body></html>");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
