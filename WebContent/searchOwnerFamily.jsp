<%-- 
    Document   : searchOwnerFamily
    Created on : Dec 7, 2016, 11:25:42 PM
    Author     : user
--%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <%@ include file="home.jsp" %>  
        <form style="margin-top: 40px" action="ownerFamilyDetailServlet" method="post">
          Member Name  :-<input type="text" name="membername"/><br/><br/>
          <input type="submit" name="action" value="Search">
          
        </form>
       <%
      try
      {
      ResultSet rs =(ResultSet)session.getAttribute("Result"); 
      

      %>
      <form action="ownerFamilyDetailServlet" method="post">
         <TABLE BORDER="1">
        <TR>
            <th></th>
            <TH>Family Member Id</TH>
            <TH>Member Name</TH>
            <TH>member Age</TH>
            <TH>Member Email</TH>
            <TH>Member Mobile </TH>
            <TH>Occupation Id</TH>
            
        </TR>
        
        <% while(rs.next()){ %>
        <tr>
        <td> <input type="checkbox" name="check" value=" "></td>
        <td> <input type="text" name="fmemberid"value="<%=rs.getString(1) %>"></td>
        <td><input type="text" name="membername"value="<%=rs.getString(2) %>"></td>
        <td><input type="text" name="memberage" value="<%=rs.getString(3) %>"></td>
        <td><input type="text" name="memberemail" value="<%=rs.getString(4) %>"></td>
        <td><input type="text" name="membermobile" value="<%=rs.getString(5) %>"></td>
        <td><input type="text" name="occupationid" value="<%=rs.getString(6) %>"></td>
        
        <% }
      }
        catch(Exception e)
        {
        System.out.println(e);
        }
        %>
    </TABLE>    
    <input type="submit" name="action" value="Update">
    <input type="submit" name="action" value="Delete">
</form> 

    </body>
</html>
