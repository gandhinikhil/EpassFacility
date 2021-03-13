
package ePass;
import static ePass.dbConnectDAO.connect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registerApproval extends HttpServlet {
   Connection conn=connect();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registerApproval</title>");            
            out.println("</head>");
            out.println("<body>");
  try
{  
PreparedStatement ps=conn.prepareStatement("insert into t_register values(?,?,?,?,?,?,?)");
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
pw.println("<body>");
String t_name=request.getParameter("name");
String t_email=request.getParameter("email");
String t_pass=request.getParameter("pass");
String t_clg=request.getParameter("clg");
String t_phn=request.getParameter("phn");
String t_branch=request.getParameter("branch");
String t_sec=request.getParameter("sec");


ps.setString(1,t_name);
ps.setString(2,t_email);
ps.setString(3,t_pass);
ps.setString(4,t_clg);
ps.setString(5,t_phn);
ps.setString(6,t_branch);
ps.setString(7,t_sec);
int ans=ps.executeUpdate();
                 
System.out.println("Record inserted"+ans);
 out.println("<h1>Record inserted</h1>");
              
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
    }
}

