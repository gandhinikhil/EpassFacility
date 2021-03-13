
package ePass;
import static ePass.dbConnectDAO.connect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
 Connection conn=connect();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");          
           try
{  
String u_enroll=request.getParameter("enroll");
String u_pass=request.getParameter("pass");
    System.out.println(u_enroll);
    System.out.println(u_pass);
Statement st=conn.createStatement();  
ResultSet rs=st.executeQuery("select s_enroll,s_pass from s_register"); 

int count=0;
 while(rs.next())
 {     
  String s_en=rs.getString("s_enroll");
  String s_pa=rs.getString("s_pass");
     System.out.println(s_en);
     System.out.println(s_pa);
    
    
 if((u_enroll.equalsIgnoreCase(s_en)) && (u_pass.equalsIgnoreCase(s_pa)))  
    {
 out.println("<h1>Record inserted</h1>");
 count=1;
 break;
 }

 }
 
    if(count==0)
 out.println("<h1>Record Cannot be inserted because u entered wrong enroll or password.</h1>");
 }

catch(SQLException ex)
{ System.out.println("sorry problem with database");
System.out.println(ex.getMessage());
}
finally
{ if(conn!=null) 
try
     { conn.close();
       System.out.println("Connection sucessfully closed");
       }
catch(SQLException ex)
{ System.out.println("sorry problem with database");
System.out.println(ex.getMessage());
}

}     

            out.println("</body>");
            out.println("</html>");
        }
    



    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
