
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
            body {

                margin: 0;
                font-family: helvetica; 
                font-size: 75%;
                color:#58585a;
                padding-top: 145px;

            }
            

            table {

                padding: 25px;
                background-color: #f3f3f3;
                border-radius: 10px;
            }

            ul1 {
                position: fixed;
                top: 0;
                width: 100%;
                list-style-type: none;
                display: block;
                margin: 0;
                padding: 0;
                width: 100%;
                background-color: #00a0de;
                overflow: hidden;
                border-style: solid;
                border: whitesmoke;
            }

            ul2 {
                position: fixed;
                top: 55px;
                width: 100%;
                list-style-type: none;
                display: block;
                margin: 0;
                padding: 0;
                width: 100%;
                background-color: white;
                overflow: hidden;
                border-style: solid;
                border: whitesmoke;

            }

            li2 {
                background-color: white;
                display: block;
            }

            li a {
                color: #ffffff; 
                font-size: 15px;
                font-weight: lighter;
                text-decoration:none;
                float:right;
                padding: 15px;
                background-color: #00a0de;
                display:block;
                border-width:1px 1px 1px 0;
                border-style: solid;
                border: whitesmoke;

            }

            li a:hover {
                background-color: #c3e0f9;

            }

            div {
                padding: 30px;
                font-weight: bold;
                float: right;
                color: whitesmoke;
                position: fixed;
                bottom: 0;
                width: 100%;
                background-color: #00a0de;

            }
            h1 {

                text-align: center;
            }






        </style>
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
    <h1>Opret kunde</h1>
    <p style="text-align: center">Udfyld venligst felterne nedenfor for at oprette dig som kunde.</p>
    <br>
    <form action="Servlet" method="POST">
        <input type="hidden" name="do_this" value="createCustomer">
        <table align="center">
            <tr>
                <td>Kunde navn:</td>
                <td><input type="text" name="custName" style="width:100px;"></td>
            </tr>

            <tr>
                <td>Kunde type:</td>
                <td><select name="customerType">
                        <option value="Boligforening">Boligforening</option>
                        <option value="Kommune">Kommune</option></select></td>
            </tr>
            <tr>
                <td>Adresse:</td>
                <td><input type="text" name="streetName" style="width:100px;"></td>

                <td style="padding-left: 10px;">Husnr:</td>
                <td><input type="text" name="streetNo" style="width:30px;"></td>
            <tr>
                <td>Postnr.:</td>
                <td><input type="text" name="zipcode" style="width: 40px;"></td>
                <td align="right">By:</td>
                <td><input type="text" name="city" style="width: 60px;"></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td colspan="6" style="text-align: center"><input style="color: #58585a;" type="submit" value="Opret kunde"></td>
            </tr>
        </table>
    </form>
    <div style="font-weight: normal">
        Rypevang 5, DK-3450 Allerød, Danmark 
        <br>
        48140555
        <br>
        info@polygon.dk www.polygon.dk
    </div>
</body>
</html>
