
package ePass;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class dbConnectDAO {
  
    public static Connection connect()
    {
        Connection conn=null;
        try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/epassdb","root", "admin");
            
        }    catch(Exception ex)
             {
                 System.out.println("Error in DAO");
                 ex.printStackTrace();
        
              }
       return conn;
       
    }
         
}