<%-- 
    Document   : UploadPicture
    Created on : 14-04-2016, 10:57:35
    Author     : Lasse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="basicStyle.css">
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
        <form action="Servlet" method="POST" enctype="multipart/form-data">
            <table align="center">
                <tr>
                    <td align="right">Vælg en plantegning</td>
                    <td><input type="file" name="picture" accept="image/png, image/x-png, image/gif, image/jpeg, image/jpg"/></td>
                    <input type="hidden" name="do_this" value="uploadPicture">
                    <td><input type="submit" value="Gem plantegning"></td>
                </tr>
                
                    
        </form>
    </body>
</html>
