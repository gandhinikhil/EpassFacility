
<%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login try</title>
    </head>
    <body>
        <%! public java.lang.Boolean validate(String username, String password) {
        boolean t =false;
         try{
              Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epassdb",
            "root", "admin");
             
            PreparedStatement ps =con.prepareStatement
                                ("select * from student_registered where name=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            t = rs.next();

         }catch(Exception e)
         {
             e.printStackTrace();
         }
         return t;
    }

   
    public java.lang.Boolean validateadm(String username, String password) {
        boolean s =false;
         try{
              Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epassdb",
            "root", "admin");
            PreparedStatement ps =con.prepareStatement
                                ("select * from student_registered where name=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            s = rs.next();

         }catch(Exception e)
         {
             e.printStackTrace();
         }
         return s;

    } %>
    <%  
            String username=request.getParameter("enroll");
            String password=request.getParameter("pass"); 
            String radio=request.getParameter("checkbox");
             if(radio.equals("s")){
             
             Boolean t = validate(username,password);
             if(t)
             {
                    out.print(username);
                    out.print(password);
                    out.print(" username or password succes");
                   session.setAttribute("name",username);
                    response.sendRedirect("home.jsp");  
 
             }
             else
             {
                    out.print(username);
                    out.print(password);
                    out.print(" username or password error");
                    response.sendRedirect("Login.html");
 
             }
             
             
             }
             else
             if(radio.equals("t"))
             {
             Boolean s = validateadm(username,password);
             if(s)
             {
                    out.print(username);
                    out.print(password);
                    out.print(" username or password succes");
                    session.setAttribute("name",username);
                    response.sendRedirect("home.jsp");  

             }
             else
             {
                    out.print(username);
                    out.print(password);
                    out.print(" username or password error");
                    response.sendRedirect("Login.html");  

             }
             }
    %>
    </body>
</html>
