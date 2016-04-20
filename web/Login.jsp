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
        <title>Login</title>
        <style>
            
            body {
                margin: 0;
                font-family: helvetica; 
                font-size: 75%;
                color:#63686c;
                padding-top: 200px;
               
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
            
            
        </style>
    </head>
    <body>
        
        <ul1>
            
            <li><a href="http://www.polygon.dk/">Polygon</a></li>
            <li><a href="Login.jsp"> Polygon login side</a></li>
        </ul1>
    
    <ul2>
        <li2 style="float:left;"> <img src="images.png" alt="Polygon" style="width: 200px; padding-left: 20px;"></li2>
        <li2 style="float:right; padding-right: 30px;"> <img src="logo-sunde-bygninger-property.png" alt="SundeBygninger" style="width: 200px; padding-left: 20px;"></li2>
    </ul2>
       
 
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
    <div>Kontakt os</div>
    <br>
    <br>
    <div style="font-weight: normal">
        Rypevang 5, DK-3450 Allerød, Danmark 
    <br>
        48140555
    <br>
        info@polygon.dk www.polygon.dk
    </div>
    </body>
</html>
