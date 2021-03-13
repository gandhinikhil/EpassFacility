
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

public class registerStudent extends HttpServlet {
     Connection conn=connect();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registerStudent</title>");            
            out.println("</head>");
            out.println("<body>");
            
           try
{  
PreparedStatement ps=conn.prepareStatement("insert into s_register values(?,?,?,?,?,?,?,?)");

response.setContentType("text/html");
PrintWriter pw=response.getWriter();
pw.println("<body>");
String s_name=request.getParameter("name");
String s_email=request.getParameter("email");
String s_pass=request.getParameter("pass");
String s_clg=request.getParameter("clg");
String s_phn=request.getParameter("phn");
String s_enroll=request.getParameter("enroll");
String s_branch=request.getParameter("branch");
String s_sec=request.getParameter("sec");

Statement stmt=conn.createStatement();  
ResultSet rs=stmt.executeQuery("select * from enroll"); 
int check=0;
 while(rs.next())
 {
     
  String enroll=rs.getString("enroll_no");
 if(enroll.equalsIgnoreCase(s_enroll))   
 {   
ps.setString(1,s_name);
ps.setString(2,s_email);
ps.setString(3,s_pass);
ps.setString(4,s_clg);
ps.setString(5,s_phn);
ps.setString(6,s_enroll);
ps.setString(7,s_branch);
ps.setString(8,s_sec);



int ans=ps.executeUpdate();             
System.out.println("Record inserted"+ans);
 out.println("<h1>Record inserted</h1>");
 check=1;
 break;
 }
 }
 if(check==0)
 out.println("<h1>Record Cannot be inserted please enter correct enroll no.</h1>");
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

