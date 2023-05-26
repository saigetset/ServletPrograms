package com.sai.CustomizedResponses;

import java.io.PrintWriter;

public class CustomizedPrintWriter extends PrintWriter {
	
	PrintWriter out;

	public CustomizedPrintWriter(PrintWriter out) {
		super(out);
		this.out=out;
	}
	
	

	@Override
	public void println(String data) {
		if(!data.startsWith("<")) {
			StringBuffer s=new StringBuffer(data);
			out.println(s.reverse());
		}
		else {
			out.println(data);
		}
	}
}
