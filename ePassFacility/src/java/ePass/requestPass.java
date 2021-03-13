
package ePass;

import static ePass.dbConnectDAO.connect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class requestPass extends HttpServlet {
  Connection conn=connect();
 RequestDispatcher rd=null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet requestPass</title>");            
            out.println("</head>");
            out.println("<body>");
            
  try
{  
PreparedStatement ps=conn.prepareStatement("Insert into req_pass values(?,?,?)");
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
pw.println("<body>");
String a_date=request.getParameter("a_date");
String time=request.getParameter("time");
String reason=request.getParameter("reason");
String enroll=request.getParameter("enroll");

ps.setString(1,a_date);
ps.setString(2,time);
ps.setString(3,reason);

    System.out.println(a_date);
    System.out.println(time);
    System.out.println(reason);
    System.out.println(enroll);
    
//PreparedStatement ps2=conn.prepareStatement("select s_enroll from s_register");
PreparedStatement ps3=conn.prepareStatement("Insert into req_pass(name,id,department,email,contact) select s_name,s_enroll,s_branch,s_email,s_phn from s_register where s_enroll='3'");


int ans=ps.executeUpdate();
 ans=ps3.executeUpdate();
                 
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

}     out.println("</body>");
      out.println("</html>");
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
