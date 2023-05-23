package com.sai.ServletEXs;

import java.io.IOException;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class SendingImageAsAResponse extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		File f = new File("D:\\AdvJavaPrograms\\ServletApps\\SendingImageAsAResponseUsingServlet\\src\\main\\java\\com\\sai\\ServletEXs\\mypic.jpeg");
		FileInputStream fis = new FileInputStream(f);
		ServletOutputStream sos = response.getOutputStream();
		byte[] b = new byte[(int) f.length()];
		fis.read(b);
		sos.write(b);
		sos.flush();
		sos.close();
		fis.close();
	}

}
