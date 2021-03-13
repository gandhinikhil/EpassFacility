<%@ page errorPage= "setdatarequesgpass.jsp"%>
<%@ page import = "java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set detail in DB</title>
    </head>
    <body>
        <%
            Connection con = null;
            try
            {
               
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epassdb",
            "root", "admin");
            Statement st = con.createStatement();
            ResultSet rs; 
            PreparedStatement ps=  con.prepareStatement("Insert into epass(date_pass_approve,reason_for_pass ) values(?,?)");
            String a_date=request.getParameter("a_date");
            String time=request.getParameter("time");
            String reason=request.getParameter("reason");
            String enroll=request.getParameter("enroll");
            System.out.println(a_date);
            System.out.println(time);
            System.out.println(reason);
            System.out.println(enroll);
            ps.setString(1,a_date);
            ps.setString(2,reason);
             ps.executeUpdate();
            System.out.println(a_date);
            System.out.println(time);
            System.out.println(reason);
            System.out.println(enroll);
            PreparedStatement ps1=  con.prepareStatement("Insert into epass(name,id,departmemt,email,contact) select name,id,department,emailaddress,contact from student_registered where id=?");
           ps1.setString(1, enroll);
           ps1.executeUpdate();
          
            
    }
           catch(SQLException ex)
         { 
           System.out.println("sorry problem with database");
          System.out.println(ex.getMessage());
          }
         finally
         {
        if(con!=null) 
        
        try
        { 
        con.close();
        System.out.println("Connection sucessfully closed");
        }
        catch(SQLException ex)
        { 
        System.out.println("sorry problem with database");
        System.out.println(ex.getMessage());
   
        }

        }
        
        
    

                      
    
    
%>
    </body>
</html>
