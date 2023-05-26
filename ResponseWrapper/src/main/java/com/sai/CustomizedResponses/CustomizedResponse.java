package com.sai.CustomizedResponses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CustomizedResponse extends HttpServletResponseWrapper{

	public CustomizedResponse(ServletResponse response) {
		super((HttpServletResponse) response);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		PrintWriter out = super.getWriter();
		CustomizedPrintWriter writer = new CustomizedPrintWriter(out);
		return 	writer;
	}
}
