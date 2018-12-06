<%-- 
    Document   : searchSociety
    Created on : Dec 1, 2016, 4:48:21 PM
    Author     : Pinnacle Infotech 7
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
        <form style="margin-top: 40px" action="societyServlet" method="post">
          Society Name     :-<input type="text" name="societyname"/><br/><br/>
          <input type="submit" name="action" value="Search">
          
        </form>
       <%
      try
      {
      ResultSet rs =(ResultSet)session.getAttribute("Result"); 
      

      %>
      <form action="societyServlet" method="post">
         <TABLE BORDER="1">
        <TR>
            <th></th>
            <TH>Society Id</TH>
            <TH>Society Name</TH>
            <TH>Society Address</TH>
            <TH>Registration No</TH>
            <TH>No of Building </TH>
            <TH>Society Area </TH>
            <TH>Ammenities Id </TH>
            <TH>Country Id </TH>
            <TH>State Id </TH>
            <TH>City Id </TH>
            
        </TR>
        
        <% while(rs.next()){ %>
        <tr>
        <td> <input type="checkbox" name="check" value=" "></td>
        <td> <input type="text" name="societyid"value="<%=rs.getString(1) %>"></td>
        <td><input type="text" name="societyname"value="<%=rs.getString(2) %>"></td>
        <td><input type="text" name="societyaddress" value="<%=rs.getString(3) %>"></td>
        <td><input type="text" name="regno" value="<%=rs.getString(4) %>"></td>
        <td><input type="text" name="nobuilding" value="<%=rs.getString(5) %>"></td>
        <td><input type="text" name="societyarea" value="<%=rs.getString(6) %>"></td>
        <td><input type="text" name="ammenitiesid" value="<%=rs.getString(7) %>"></td>
        <td><input type="text" name="countryid" value="<%=rs.getString(8) %>"></td>
        <td><input type="text" name="stateid" value="<%=rs.getString(9) %>"></td>
        <td><input type="text" name="cityid" value="<%=rs.getString(10) %>"></td>
        
        
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
