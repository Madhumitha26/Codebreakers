import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Display extends HttpServlet{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
 res.setContentType("text/html");
PrintWriter pw=res.getWriter();
pw.println("<body background='women3.jpg'><a href='location.html'>Click to enter location</a></body>");
}
}