
package ePass;

import static ePass.dbConnectDAO.connect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showrequestPass extends HttpServlet {
 Connection conn=connect();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
         out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet showrequestPass</title>");            
            out.println("</head>");
            out.println("<body>");
              Statement st=conn.createStatement();
          ResultSet rs=st.executeQuery("Select fname,lname,enroll,year,sem,time,reason from req_pass");
         
         while(rs.next())
            {
            String fname=rs.getString(1);
            String lname=rs.getString(2);
            String enroll=rs.getString(3);
            String year=rs.getString(4);
            String sem=rs.getString(5);
            String time=rs.getString(6);
            String reason=rs.getString(7);          
                              
            out.println(fname);
            out.println(lname);
            out.println(enroll);
            out.println(year);
            out.println(sem);
            out.println(time);
            }
        }
                
                   catch(SQLException se)
                   {
                       System.out.println("error in sql");
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
