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
        <h1>Indtast bygningsID</h1>
        <form action="Servlet" method="GET">
            Bygnings-ID: 
            <input type='number' name='buildingID'/>
            <input type="hidden" name="do_this" value="createBuilding_BuildingID">
            <input type="submit" value="OK" />
        </form>
    </body>
</html>
