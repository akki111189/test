<%-- 
    Document   : society
    Created on : Dec 1, 2016, 2:02:10 PM
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
        <form action="societyServlet" method="post">
            Society Id     :-<input type="text" name="societyid"/><br/><br/>
            Society Name   :-<input type="text" name="societyname"/><br/><br/>
            Society Address:-<input type="text" name="societyaddress"/><br/><br/>
            Registration No:-<input type="text" name="regno"/><br/><br/>
            No of Building :-<input type="text" name="nobuilding"/><br/><br/>
            Society Area   :-<input type="text" name="societyarea"/><br/><br/>
            Ammenities Id  :-<input type="text" name="ammenitiesid"/><br/><br/>
            Country Id     :-<input type="text" name="countryid"/><br/><br/>
            State Id       :-<input type="text" name="stateid"/><br/><br/>
            City Id        :-<input type="text" name="cityid"/><br/><br/>
            <input type="submit" name="action" value="Submit"> 
            <a href="searchSociety.jsp">Search</a>
             
        </form>
    </body>
</html>
