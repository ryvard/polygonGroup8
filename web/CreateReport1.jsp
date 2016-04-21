<%-- 
    Document   : CreateReport1
    Created on : 11-04-2016, 10:12:10
    Author     : miaryvard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Indsæt bygnings ID</title>
        <link rel="stylesheet" href="basicStyle.css"
    </head>
    <body>

        <ul1> 
        <li><a href="http://www.polygon.dk/">Polygon</a></li>
        <li><a href="Login.jsp"> Polygon login side</a></li>
        <li><a href="BuildingList.jsp">Se bygninger</a></li>
        <li><a href="CreateBuilding.jsp">Opret din bygning</a></li>
        <li><a href="CreateReport1.jsp">Opret rapport</a></li>
        <li><a href="ViewReport.jsp">Se rapport</a></li>
    </ul1>

    <ul2>
        <li2 style="float:left;"> <img src="images.png" alt="Polygon" style="width: 200px; padding-left: 20px;"></li2>
        <li2 style="float:right; padding-right: 30px;"> <img src="logo-sunde-bygninger-property.png" alt="SundeBygninger" style="width: 200px; padding-left: 20px;"></li2>
    </ul2>
        <h1>Indtast BygningsID</h1>
        <table align="center">
        <form action="Servlet" method="GET">
            <td>Bygnings-ID:</td> 
            <td><input type='number' name='buildingID'></td>

            <input type="hidden" name="do_this" value="createReport_BuildingID">
            <td><input type="submit" value="OK"></td>
        </form>
            </table>
    </body>
</html>
