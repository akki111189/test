<%-- 
    Document   : ownerFamilyDetail
    Created on : Dec 7, 2016, 10:49:50 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%@ include file="home.jsp" %>  
        <form action="ownerFamilyDetailServlet" method="post">
            Family Member Id :-<input type="text" name="fmemberid"/><br/><br/>
            Member Name  :-<input type="text" name="membername"/><br/><br/>
            Member Age    :-<input type="text" name="memberage"/><br/><br/>
            Member Email   :-<input type="text" name="memberemail"/><br/><br/>
            Member Mobile  :-<input type="text" name="membermobile"/><br/><br/>
            Occupation Id  :-<input type="text" name="occupationid"/><br/><br/>
 	    <input type="submit" name="action" value="Submit"> 
           <a href="searchOwnerFamily.jsp">Search</a>
             
        </form>
    
    </body>
</html>
