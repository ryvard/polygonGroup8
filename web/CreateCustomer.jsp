
<%-- 
    Document   : CreateCustomer
    Created on : 31-03-2016, 10:15:20
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
        <h1>Opret kunde</h1>
        <div>Udfyld venligst felterne nedenfor for at oprette dig som kunde.</div>
        <br>
        <form action="Servlet" method="POST">
            <input type="hidden" name="do_this" value="createCustomer">
            <table>
                <tr>
                    <td>Kunde type:</td>
                </tr>
                <tr>
                <td><select name="checkbox">
                    <option value="Boligforening">Boligforening</option>
                    <option value="Kommune">Kommune</option>
                </select></td>
                <td>Adresse:</td>
                <td><input type="text" name="streetName"></td>
                </tr>
                <tr>
                    <td>Husnummer:</td>
                    <td><input type="text" name="streetNo" style="width:40px;"></td>
                    <td>Postnr.:</td>
                    <td><input type="text" name="zipcode" style="width: 40px;"></td>
                    <td align="right">By:</td>
                    <td><input type="text" name="city"></td>
                </tr>
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
