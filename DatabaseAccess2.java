import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DatabaseAccess2 extends HttpServlet{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{

final String JDBC_DRIVER="com.mysql.jdbc.Driver";
final String  DB_URL="jdbc:mysql://localhost:3306/TEST";

final String USER="root";
final String PASS="ssn";

Connection conn=null;
Statement stmt=null;

res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String title="Database Result";
try{
 Class.forName("com.mysql.jdbc.Driver");
conn=DriverManager.getConnection(DB_URL,USER,PASS);
stmt=conn.createStatement();
String sql;
sql="SELECT* FROM forties";
ResultSet rs=stmt.executeQuery(sql); 
while(rs.next())
{
String name=rs.getString("name");
String address=rs.getString("address");
String ph1=rs.getString("ph1");
String ph2=rs.getString("ph2");
pw.println("name:"+name+"<br>");
pw.println("Address:"+address+"<br>");
pw.println("ph1:"+ph1+"<br>");
pw.println("ph2:"+ph2+"<br>");
}
rs.close();
stmt.close();
conn.close();
}catch(SQLException se){
se.printStackTrace();
}catch(Exception e){
e.printStackTrace();
}finally{
try{
if(stmt!=null)
stmt.close();
}catch(SQLException se2){
}
try{
if(conn!=null)
conn.close();
}catch(SQLException se){
se.printStackTrace();
}
}//finally
}
}
