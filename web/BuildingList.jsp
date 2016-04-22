<%-- 
    Document   : BuildingList
    Created on : 31-03-2016, 10:32:54
    Author     : miaryvard
--%>

<%@page import="businesslogic.Building"%>
<%@page import="java.util.ArrayList"%>
<%@page import="businesslogic.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste over bygninger</title>
        <link rel="stylesheet" href="basicStyle.css">
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
        <h1>Liste over alle bygninger</h1>

        <table align="center">
            <tbody>
                <tr>
                    <td><b>BuildingID</b></td>
                    <td><b>Navn på bygning</b></td>
                    <td><b>Adresse</b></td>
                    <td><b>Husnummer</b></td>
                    <td><b>Postnr</b></td>
                    <td><b>By</b></td>
                    <td><b>Byggeår</b></td>
                    <td><b>Bygningen bliver/har været brugt til</b></td>
                    <td><b>Kunde ID</b></td>
                    <td><b>Kontakt person ID</b></td>
                </tr>


                <%
                    Controller cntr = new Controller();
                    ArrayList<Building> buildings = cntr.getBuildingList();
                    for (Building b : buildings)
                    {
                %>
                <tr>
                    <td><%=b.getBuildingID()%></td>
                    <td><%=b.getBuildingName()%></td>
                    <td><%=b.getStreetName()%></td>
                    <td><%=b.getStreetNumb()%></td>
                    <td><%=b.getZipcode()%></td>
                    <td><%=b.getCity()%></td>
                    <td><%=b.getYearOfConst()%></td>
                    <td><%=b.getBuildingUse()%></td>
                    <td><%=b.getCustID()%></td>
                    <td><%=b.getCPID()%></td>
            <td><form action="Servlet" method="GET">
                <input type="hidden" name="buildingID" value="<%=b.getBuildingID()%>"/>
                <input type="submit" name="do_this" value="Show Pictures">
            </form></td>
        </tr>
        <%
            
            }
        %>

    </tbody>
    <div style="font-weight: normal">
        Rypevang 5, DK-3450 Allerød, Danmark 
        <br>
        48140555
        <br>
        info@polygon.dk www.polygon.dk
    </div>
</body>
</table>
</body>
</html>
