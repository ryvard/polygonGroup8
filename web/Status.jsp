<%-- 
    Document   : Status
    Created on : 01-05-2016, 23:49:23
    Author     : emmablomsterberg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="basicStyle.css">
    </head>
    <body>
        <ul1> 
        <li><a href="http://www.polygon.dk/">Polygon</a></li>
        <li><a href="Login.jsp"> Polygon login side</a></li>
        <li><a href="BuildingList.jsp">Se bygninger</a></li>
        <li><a href="CreateBuilding.jsp">Opret din bygning</a></li>
        <li><a href="CreateCustomer.jsp">Opret kunde</a></li>
        <li><a href="CreateReport1.jsp">Opret rapport</a></li>
        <li><a href="ViewReport1.jsp">Se rapport</a></li>
    </ul1>
    <ul2>
        <li2 style="float:left;"> <img src="images.png" alt="Polygon" style="width: 200px; padding-left: 20px;"></li2>
        <li2 style="float:right; padding-right: 30px;"> <img src="logo-sunde-bygninger-property.png" alt="SundeBygninger" style="width: 200px; padding-left: 20px;"></li2>
    </ul2>
    <table align="center">
        <tr>
            <td> <%= request.getAttribute("Result") %> </td>
        </tr>
        <%  if(request.getAttribute("DisplayCustID") != null) 
            {
        %>
        <tr>
            <td> <%= request.getAttribute("DisplayCustID") %></td>
        </tr>
        <% } %>
    <div style="font-weight: normal">
    Rypevang 5, DK-3450 Allerød, Danmark 
    <br>
    48140555
    <br>
    info@polygon.dk www.polygon.dk
</div>
    </body>
</html>
