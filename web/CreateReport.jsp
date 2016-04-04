<%-- 
    Document   : CreateReport
    Created on : 04-04-2016, 12:28:39
    Author     : Lasse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opret kunde</title>
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
        <h1>Bygningsgennemgang</h1>
        <div></div>
        <br>
        <form action="Servlet" method="POST">
            <input type="hidden" name="do_this" value="createReport">
            <table>

                <tr>
                    <td>Navn på bygning</td>
                    <td><input type="text" name="buildningName"></td>
                    <td>Dato</td>
                    <td> <input type="text" name="date"</td>
                </tr>

                <tr>
                    <td>Adresse</td>
                    <td><input type="text" name="adress"></td>
                </tr>

                <tr>
                    <td>Postnr./By</td>
                    <td> <input type="text" name="zipCity"</td>
                </tr>

            </table>

            <table>
                <div style="width:500px;height:100px;border:1px solid #000;">This is a rectangle!</div>

                <tr>
                <h2>Generel information om bygningen</h2>
                <td>Byggeår</td>
                <td><input type="text" name="buildYear"</td>
                </tr>
                
                <tr>
                <td>Bygningsareal i m²</td>
                <td>(hver etage tælles separat)</td>
                <td><input type="text" name="squareMeter" style="width:80px;"></td>
                </tr>
                
                <td>Postnr.:</td>
                <td><input type="text" name="zipcode" style="width: 40px;"></td>
                <td align="right">By:</td>
                <td><input type="text" name="city"></td>

                <tr>
                    <td>Kontakt navn:</td>
                    <td><input type="text" name="contactName"></td>
                    <td>Telefon nr.:</td>
                    <td><input type="text" name="phone" ></td>
                    <td align="right">Email:</td>
                    <td><input type="text" name="mail"></td>
                </tr>

            </table>
            <input type="submit" value="Opret kunde">
        </form>
    </body>
</html>