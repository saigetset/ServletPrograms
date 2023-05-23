import java.io.*;
import javax.servlet.http.*;
import javax.swing.text.html.HTML;
import javax.servlet.*;
import javax.servlet.annotation.*;


@WebServlet(urlPatterns="/test",loadOnStartup = 10)
public class FifthServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        System.out.println("Request Method Type: "+request.getMethod());
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1 style=\"color: blue\">Get Method</h1></body></html>");
        System.out.println("Name: "+request.getParameter("name"));
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        System.out.println("Request Method Type: "+request.getMethod());
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1 style=\"color: blue\">Post Method</h1></body></html>");
        System.out.println("Name: "+request.getParameter("name"));
    }
}
