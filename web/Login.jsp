<%-- 
    Document   : Login
    Created on : 18-04-2016, 10:12:53
    Author     : emmablomsterberg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            
            body {
                font-family: helvetica;
                font-size: 75%;
                color:#63686c;
            }
            
            table {
                
                padding: 10px;
                background-color: #f4f4f5;
                border-radius: 15px;
            }
            
            ul {
                list-style-type: none;
                display: block;
                margin: 0;
                padding: 0;
                width: 100%;
                background-color: #3d99ec;
                overflow: hidden;
                border-style: solid;
                border: whitesmoke;
            }
          
            li a {
                color:whitesmoke; 
                font-size: 15px;
                font-weight: lighter;
                text-decoration:none;
                float:right;
                padding: 20px;
                background-color: #3d99ec;
                display:block;
                border-width:1px 1px 1px 0;
                border-style: solid;
                border: whitesmoke;
                
            }
            
            li a:hover {
                background-color: #c3e0f9;
                
            }
            
            
            
        </style>
    </head>
    <body>
        <ul>
            <li><a href="http://www.polygon.dk/">Polygon</a></li>
            <li><a href="Login.jsp"> Polygon login side</a></li>
        </ul>
        <img src="images.png" alt="Polygon" style="width: 200px; padding-left: 20px;">
 
        <form action="Servlet" method="POST">
            <table align="center">
                <tr>
                    <td style="text-align: center; font-size: 150%;" colspan="2">Login</td>
                </tr>
                <br>
                <tr>
                    <td>Brugernavn</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Kode</td>
                    <td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="do_this" value="login"</td>
                    <td><input type="submit" value="Login"</td>
                </tr>
            </table>
        </form>
    </body>
</html>
