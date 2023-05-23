import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;


@WebServlet(urlPatterns="/test",loadOnStartup = 10)
public class FourthServlet extends GenericServlet{
    @Override
    public void service(ServletRequest request,ServletResponse response)throws IOException,ServletException{
        System.out.println(request.getParameter("name"));
        PrintWriter pw = response.getWriter();
        pw.println("<html><head><title>FourthServlet</title></head>");
        pw.println("<body>");
        pw.println("<h1 style='color:blue'>Created Using GenericServlet</h1>");
        pw.println("</body></html>");
    }
}
