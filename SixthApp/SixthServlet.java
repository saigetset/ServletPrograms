import java.io.*;
import javax.servlet.http.*;
import javax.swing.text.html.HTML;
import javax.servlet.*;
import javax.servlet.annotation.*;


@WebServlet(urlPatterns="/test",loadOnStartup = 10)
public class SixthServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        System.out.println("Request Method Type: "+request.getMethod());
        PrintWriter out = response.getWriter();
        out.println("<html><body bgcolor: aquamarine text:brown>");
        out.println("<table>");
        out.println("<tr><td>Name: </td><td>");
        out.println(request.getParameter("name"));
        out.println("</td></tr>");
        out.println("<tr><td>Age: </td><td>");
        out.println(request.getParameter("age"));
        out.println("</td></tr>");
        out.println("<tr><td>City: </td><td>");
        out.println(request.getParameter("city"));
        out.println("</td></tr>");
        out.println("<tr><td>Courses: </td><td>");
        String[] courses = request.getParameterValues("courses");
        for(String i:courses){
            out.println(i);
        }
        out.println("</td></tr>");
        out.println("</table>");
        out.println("</body></html>");
        System.out.println("Name: "+request.getParameter("name"));
    }

    // @Override
    // public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
    //     System.out.println("Request Method Type: "+request.getMethod());
    //     PrintWriter out = response.getWriter();
    //     out.println("<html><body><h1 style=\"color: blue\">Post Method</h1></body></html>");
    //     System.out.println("Name: "+request.getParameter("name"));
    // }
}
