import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;


@WebServlet(urlPatterns="/test",loadOnStartup = 10)
public class ThirdServlet extends GenericServlet{
    @Override
    public void service(ServletRequest request,ServletResponse response)throws IOException,ServletException{
        PrintWriter pw = response.getWriter();
        pw.println("<html><head><title>ThirdServlet</title></head>");
        pw.println("<body>");
        pw.println("<h1 style='color:blue'>Created Using GenericServlet</h1>");
        pw.println("</body></html>");
    }
}
