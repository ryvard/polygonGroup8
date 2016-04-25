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
        <h1>UPS! Der skete en fejl</h1>

        <%
            if (request.getAttribute("dataError") != null)
            {
        %>
        <h2><%=request.getAttribute("ReportError")%></h2>
        <%
            }
            if (request.getAttribute("numberFormat") != null)
            {
        %>
        <h2><%=request.getAttribute("numberFormat")%></h2>
        <%
            }
            if (request.getAttribute("fail") != null)
            {
        %>
        <h2><%=request.getAttribute("fail")%></h2>
        <%
            }
        %>

        <FORM><INPUT Type="button" VALUE="Tilbage" onClick="history.go(-1);
                return true;"></FORM>
    </body>
</html>
