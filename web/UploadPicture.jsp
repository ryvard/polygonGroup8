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

    </head>
    <body>
        <form action="Servlet" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <td align="right">Vælg en plantegning</td>
                    <td><input type="file" name="picture" accept="image/png, image/x-png, image/gif, image/jpeg, image/jpg"/></td>
                    <input type="hidden" name="do_this" value="uploadPicture">
                    <td><input type="submit" value="Gem plantegning"></td>
                </tr>
                
                    
        </form>
    </body>
</html>
