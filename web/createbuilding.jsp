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
        <title>JOpret bygning</title>
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
            <input type="hidden" name="do_this" value="create">
            <table>
                <tr>
                    <td>Adresse:</td>
                    <td><input type="text" name="street"></td>
                    <td>Husnummer:</td>
                    <td><input type="text" name="streetNo"></td>
                </tr>
                <tr>
                    <td>Postnr:</td>
                    <td><input type="text" name="zipcode"></td>
                    <td align="right">By:</td>
                    <td><input type="text" name="city"></td>
                </tr>
                <tr>
                    <td>Tilstand:</td>
                    <td><input type="text" name="condition"></td>
                </tr>
            </table>
            <input type="submit" value="Opret bygning">
        </form>
    </body>
</html>
