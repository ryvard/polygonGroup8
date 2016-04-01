<%-- 
    Document   : createbuilding
    Created on : 30-03-2016, 13:47:34
    Author     : emmablomsterberg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opret bygning</title>
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
        <h1>Opret din bygning</h1>
        <div>Udfyld venligst felterne nedenfor for at oprette din bygning.</div>
        <br>
        <form action="Servlet" method="POST">
            <input type="hidden" name="do_this" value="createBuilding">
            <table width="100%">
                <tr>
                    <td>Bygningsnavn:</td>
                    <td><input type="text" name="buildingName"></td>
                </tr>
                <tr>
                    <td>Adresse:</td>
                    <td><input type="text" name="street"></td>
                    <td>Husnummer:</td>
                    <td><input type="text" name="streetNo" style="width:40px;"></td>
                </tr>
                <tr>
                    <td>Postnr:</td>
                    <td><input type="text" name="zipcode" style="width: 40px;"></td>
                    <td align="right">By:</td>
                    <td><input type="text" name="city"></td>
                </tr>
                <tr>
                    <td>Byggeår:</td>
                    <td><input type="text" name="yearOfConst"</td>
                </tr>
                <tr>
                    <td>Bygningsareal:</td>
                    <td><input type="text" name="squareM"</td>
                    
                </tr>
                <tr>
                    <td>Billede:</td>
                    <td><input type=image name="picture"></td>
                </tr>
                <tr>
                    <td>Hvad bruges bygning til? / Hvad har bygningen været brugt til?:</td>
                    <td><input type="text" name="buildingUse"</td>
                </tr>
                <td>Dit kunde id:</td>
                <td><input type="text" name="custID"</td>
            </table>
            <input type="submit" value="Opret bygning">
        </form>
    </body>
</html>
