<%-- 
    Document   : roomOwner
    Created on : Dec 6, 2016, 10:29:53 PM
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
        <form action="roomOwnerServlet" method="post">
            Room Id     :-<input type="text" name="roomid"/><br/><br/>
            Room No   :-<input type="text" name="roomno"/><br/><br/>
            Room Type:-<input type="text" name="roomtype"/><br/><br/>
            Room Area:-<input type="text" name="roomarea"/><br/><br/>
            Registration No :-<input type="text" name="regno"/><br/><br/>
            Property Tax No :-<input type="text" name="propertytaxno"/><br/><br/>
            Owner Name  :-<input type="text" name="ownername"/><br/><br/>
            Age    :-<input type="text" name="age"/><br/><br/>
            Gender :-<input type="radio" id="gender" name="gender" value="male"/>Male  
              	     <input type="radio" id="gender" name="gender" value="female"/>Female<br/><br/>
	    Email   :-<input type="text" name="email"/><br/><br/>
            Mobile  :-<input type="text" name="mobile"/><br/><br/>
            Owner Share Certi No :-<input type="text" name="certino"/><br/><br/>
            No Family Member  :-<input type="text" name="nofamilymember"/><br/><br/>
            Parking Type :-<input type="text" name="parkingtyp"/><br/><br/>
            Occupation Id  :-<input type="text" name="occupationid"/><br/><br/>
 	    Payment Id  :-<input type="text" name="paymentid"/><br/><br/>
 	    Society Id  :-<input type="text" name="societyid"/><br/><br/>
 	    Building Id  :-<input type="text" name="buildingid"/><br/><br/>
            <input type="submit" name="action" value="Submit"> 
            <a href="searchOwner.jsp">Search</a>
             
        </form>
    </body>
</html>
