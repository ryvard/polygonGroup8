<%-- 
    Document   : BuildingList
    Created on : 31-03-2016, 10:32:54
    Author     : miaryvard
--%>

<%@page import="Domain.Building"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logic.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste over bygninger</title>
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
        <h1>Liste over alle bygninger</h1>
        
        <table>
            <tbody>
                <tr>
                    <td><b>BuildingID</b></td>
                    <td><b>vej</b></td>
                    <td><b>nr.</b></td>
                    <td><b>post. nr.</b></td>
                    <td><b>tilstand</b></td>
                    <td><b>KundeID</b></td>
                </tr>

                <%
                    Controller con = new Controller();
                    //ArrayList<Building> buildings = con. Metoden der returnere listen
                    //for (Building b : buidings)
                    {
                %>
                <tr>
                    <%--
                    <td><%=top.getPlayer_name()%></td>
                    <td><%=top.getTeam_id()%></td>
                    <td><%=top.getGoals()%></td>
                    
                    <td><b>BuildingID</b></td>
                    <td><b>vej</b></td>
                    <td><b>nr.</b></td>
                    <td><b>post. nr.</b></td>
                    <td><b>tilstand</b></td>
                    <td><b>KundeID</b></td>
                    --%>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
