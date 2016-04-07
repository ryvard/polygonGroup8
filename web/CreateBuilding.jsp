<%-- 
    Document   : createbuilding
    Created on : 30-03-2016, 13:47:34
    Author     : emmablomsterberg
--%>

<%@page import="Domain.ContactPerson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logic.Controller"%>
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
        <br>
        <div>Udfyld venligst felterne nedenfor for at oprette en kontaktperson, hvis dette ikke er allerede gjort</div>
        <form action="Servlet" method="GET">
            <input type="hidden" name="do_this" value="createContactPerson">
        <table cellpadding="3">
                <tr>
                    <td colspan="2" style="font-weight: bold;">Kontaktperson information:</td>
                </tr>
                <tr>
                    <td>Fornavn:</td>
                    
                    <td><input type="text" name="cpFirstName"</td>
                    <td>Efternavn:</td>
                    <td><input type="text" name="cpLastName"</td>
                </tr>
                <tr>
                    <td>Tel/mobil:</td>
                    <td><input type="text" name="cpPhone"</td>
                    <td>E-mail:</td>
                    <td><input type="text" name="cpEmail"</td>
                </tr>
            </table>
            <input type="submit" value="Opret kontaktperson">
            </form>
        <br>
        <table>
            <tr>
                <td>Du har nu oprettet en kontaktperson. Dit kontakpersonnummer er:</td>
                <td></td>
        </tr>
        </table>
        <div>Udfyld venligst felterne nedenfor for at oprette din bygning.</div>
        <form action="Servlet" method="POST">
            <input type="hidden" name="do_this" value="createBuilding">
            <table cellpadding="3">
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
                    <td>By:</td>
                    <td><input type="text" name="city" style="width: 80px;"></td>
                </tr>
                <tr>
                    <td>Byggeår:</td>
                    <td><input type="text" name="yearOfConst"</td>
                </tr>
                <tr>
                    <td>Bygningsareal:</td>
                    <td><input type="text" name="squareM"></td>    
                </tr>
                <tr>
                    <td>Billede:</td>
                    <td><input type=image name="picture"></td>
                </tr>
                <tr>
                    <td>Hvad bruges bygning til? / <br> Hvad har bygningen været brugt til?:</td>
                    <td><input type="text" name="buildingUse"</td>
                </tr>
                <td>Dit kunde id:</td>
                <td><input type="text" name="custID"</td>
            </table>
            <input type="submit" value="Opret bygning">
        </form>
    </body>
</html>
