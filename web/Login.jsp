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
        <link rel="stylesheet" href="basicStyle.css">
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
       
    <h1>Login</h1>
        <form action="Servlet" method="POST">
            <table align="center">
                
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
                <% if(request.getAttribute("LoginError") != null) { %>
                <tr>
                    <td colspan="2" style="color:red;"><%= request.getAttribute("LoginError") %></td>
                </tr>
                <% }%>
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
