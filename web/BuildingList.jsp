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
        <style>
            h1 {

                text-align: center;
            }

            div {

                font-size: 75%;
            }

            body {

                font-family: verdana;
            }

            table {
                font-size: 75%;
            }
        </style>
    </head>
    <body>
        <h1>Liste over alle bygninger</h1>

        <table border="1">
            <tbody>
                <tr>
                    <td><b>BuildingID</b></td>
                    <td><b>Navn på bygning</b></td>
                    <td><b>Adresse</b></td>
                    <td><b>Husnummer</b></td>
                    <td><b>postnr</b></td>
                    <td><b>by</b></td>
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
            <form action="/ShowImageServlet" method="POST">
                <input type="hidden" name="buildingID" value="<%=b.getBuildingID()%>"/>
                <td><input type="submit" name="do_this" value="Show Picture"></td>
            </form>
        </tr>
        <%
            }
        %>

    </tbody>
</body>
</table>
</body>
</html>
