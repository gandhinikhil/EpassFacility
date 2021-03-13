<%@page import="ePass.dbConnectDAO"%>
<%@ page import = "java.sql.*"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="homestyle.css" rel="stylesheet">
<%     
            String name1=(String)session.getAttribute("name");       
            Connection conn = dbConnectDAO.connect();            
            Statement st = conn.createStatement();    
            ResultSet rs; 
            PreparedStatement ps=  conn.prepareStatement("Select * from student_registered where name=?");
           
            ps.setString(1, name1);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
            %>
          
<div class="topnav">
  <a class="active" href="#home">Lakshmi Narain College of Technology</a>
  <a href="#news">ID<br><%=rs.getString("id") %></a>
      <a href="#contact">Departement <br><%=rs.getString("department")%></a>
  <a href="#about"><%=rs.getString("name") %></a>
</div>

<div style="padding-left:16px">

</div>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="home.html">Dashboard</a>
  <a href="#">Your Profile</a>
  <a href="#">Logout</a>
  <a href="contact.html">Contact</a>
</div>

<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open</span>

<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>
  
<p class="one"> <a href="requestPass.html" style="text-decoration: none;">Request Gate pass</a></p>
<p class="two"><a href="approved.html" style="text-decoration: none;">Approved Gate Pass</a></p>
<p class="three"><a href="rejected.html" style="text-decoration: none;">Rejected Gate pass</a></p>
<p class="four"><a href="pending.html" style="text-decoration: none;">Pending Gate pass</a></p>

 
</body>
</html> 
<%
}
%>