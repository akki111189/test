<%-- 
    Document   : searchBuilding
    Created on : Dec 5, 2016, 8:42:53 PM
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
        <form style="margin-top: 40px" action="buildingServlet" method="post">
          Building Name     :-<input type="text" name="buildingname"/><br/><br/>
          <input type="submit" name="action" value="Search">
          
        </form>
       <%
      try
      {
      ResultSet rs =(ResultSet)session.getAttribute("Result"); 
      

      %>
      <form action="buildingServlet" method="post">
         <TABLE BORDER="1">
        <TR>
            <th></th>
            <TH>Building Id</TH>
            <TH>Building Name</TH>
            <TH>Max no Room</TH>
            <TH>Parking Type</TH>
            <TH>No of Building </TH>
            <TH>Society Id </TH>
                 
        </TR>
        
        <% while(rs.next()){ %>
        <tr>
        <td> <input type="checkbox" name="check" value=" "></td>
        <td> <input type="text" name="buildingid"value="<%=rs.getString(1) %>"></td>
        <td><input type="text" name="buildingname"value="<%=rs.getString(2) %>"></td>
        <td><input type="text" name="maxroom" value="<%=rs.getString(3) %>"></td>
        <td><input type="text" name="parkingtype" value="<%=rs.getString(4) %>"></td>
        <td><input type="text" name="nobuilding" value="<%=rs.getString(5) %>"></td>
        <td><input type="text" name="societyid" value="<%=rs.getString(6) %>"></td>
              
        
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
