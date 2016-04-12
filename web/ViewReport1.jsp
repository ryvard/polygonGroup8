<%-- 
    Document   : ViewReport1
    Created on : 12-04-2016, 11:57:51
    Author     : Lasse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Indsæt Rapport ID</title>
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
        <h1>Indtast rapport ID</h1>
        <form action="Servlet" method="GET">
            Rapport ID: 
            <input type='number' name='repID'/>
            <input type="hidden" name="do_this" value="viewReport">
            <input type="submit" value="OK" />
        </form>
    </body>
</html>

