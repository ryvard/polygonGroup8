<%-- 
    Document   : ReportError
    Created on : 14-04-2016, 13:15:52
    Author     : miaryvard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ups prøv igen!!</h1>
        <h2>report: <%=request.getAttribute("ReportError")%></h2>
        <h2>number: <%=request.getAttribute("Number")%></h2>
        <h2>fail: <%=request.getAttribute("fail")%></h2>
        
        <FORM><INPUT Type="button" VALUE="Tilbage" onClick="history.go(-1);return true;"></FORM>
    </body>
</html>
