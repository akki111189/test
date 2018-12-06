<%-- 
    Document   : building
    Created on : Dec 2, 2016, 3:27:40 PM
    Author     : Pinnacle Infotech 7
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
        <form action="buildingServlet" method="post">
            Building Id     :-<input type="text" name="buildingid"/><br/><br/>
            Building Name   :-<input type="text" name="buildingname"/><br/><br/>
            Max no Room:-<input type="text" name="maxroomno"/><br/><br/>
            Parking Type:-<input type="text" name="parkingtype"/><br/><br/>
            No of Building :-<input type="text" name="nobuilding"/><br/><br/>
            Society Id   :-<input type="text" name="societyid"/><br/><br/>
            <input type="submit" name="action" value="Submit"> 
            <a href="searchBuilding.jsp">Search</a>
             
        </form>
    </body>
</html>
