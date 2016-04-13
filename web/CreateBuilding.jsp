<%-- 
    Document   : createbuilding
    Created on : 30-03-2016, 13:47:34
    Author     : emmablomsterberg
--%>

<%@page import="Domain.ContactPerson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logic.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opret bygning</title>
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
        
        <h1>Opret din bygning</h1>
        <br>
        <div>Udfyld venligst felterne nedenfor for at oprette en kontaktperson, hvis dette ikke er allerede gjort</div>
        <form action="Servlet" method="GET">
            
            <input type="hidden" name="do_this" value="createContactPerson">

        <table cellpadding="3">
                <tr>
                    <td colspan="2" style="font-weight: bold;">Kontaktperson information:</td>
                </tr>
                <tr>
                    <td>Fornavn:</td>
                    
                    <td><input type="text" name="cpFirstName"</td>
                    <td>Efternavn:</td>
                    <td><input type="text" name="cpLastName"</td>
                </tr>
                
                <tr>
                    <td>Tel/mobil:</td>
                    <td><input type="text" name="cpPhone"</td>
                    <td>E-mail:</td>
                    <td><input type="text" name="cpEmail"</td>
                </tr>
                
            </table>
            <input type="submit" value="Opret kontaktperson">
            </form>
        <br>
        <table>
            <tr>
                <td>Du har nu oprettet en kontaktperson. Dit kontakpersonnummer er:</td>
                <td style="font-weight: bold"><%= request.getAttribute("cpID")==null?" ":request.getAttribute("cpID") %></td>
        </tr>
        </table> 
        <br>
        <div>Udfyld venligst felterne nedenfor for at oprette din bygning.</div>
        <form action="CreateBuilding.jsp" method="GET">              
            <%
            if(request.getParameter("do_this")!=null&&request.getParameter("do_this").equals("createBuilding"))
            {
                getServletContext().getRequestDispatcher("/Servlet").forward(request, response);
            }
            %>
           
           
            <table cellpadding="3">
                <tr>
                    <td>Bygningsnavn:</td>
                    <td><input type="text" name="buildingName" value="<%=request.getParameter("buildingName")==null?"":request.getParameter("buildingName")%>"></td>
                </tr>
                <tr>
                    <td>Adresse:</td>
                    <td><input type="text" name="street" value="<%=request.getParameter("street")==null?"":request.getParameter("street")%>"></td>
                    <td>Husnummer:</td>
                    <td><input type="text" name="streetNo" value="<%=request.getParameter("streetNo")==null?"":request.getParameter("streetNo")%>" style="width:40px;"></td>
                </tr>
                <tr>
                    <td>Postnr:</td>
                    <td><input type="text" name="zipcode" value="<%=request.getParameter("zipcode")==null?"":request.getParameter("zipcode")%>" style="width: 40px;"></td>
                    <td>By:</td>
                    <td><input type="text" name="city" value="<%=request.getParameter("city")==null?"":request.getParameter("city")%>" style="width: 80px;"></td>
                </tr>
                <tr>
                    <td>Byggeår:</td>
                    <td><input type="text" name="yearOfConst" value="<%=request.getParameter("yearOfConst")==null?"":request.getParameter("yearOfConst")%>"</td>
                </tr>
            </table>
               <%
                int floor = request.getParameter("addFloor")==null?1:Integer.parseInt(request.getParameter("addFloor"));
                
                for (int i = 0; i < floor; i++)
                {
            %>
            <table cellpadding="3">
                <tr>
                    <td>Etage</td>
                    <td><input type="number" name="<%="floor"+i%>" value="<%=request.getParameter("floor"+i)==null?"":request.getParameter("floor"+i)%>" min="-10" max="50" </td>
                    </tr>
                    <td colspan="2"><input type="text" name="<%="squareM"+i%>" value="<%=request.getParameter("squareM"+i)==null?"":request.getParameter("squareM"+i)%>" /></td>
                
            </table>
            <%
                    }
            %>
             
            <input type="hidden" name="addFloor" value="<%=floor+1%>"/>
            <input type="submit"  name="do_this" value="Tilføj etage" />
            
            <table cellpadding="3">
                    <td>Bygningsareal:</td>
                    <td><input type="text" name="squareM" value="<%=request.getParameter("squareM")==null?"":request.getParameter("squareM")%>"></td>    
                </tr>
                <tr>
                    <td>Billede:</td>
                    <td><input type=image name="picture"></td>
                </tr>
                <tr>
                    <td>Hvad bruges bygning til? / <br> Hvad har bygningen været brugt til?:</td>
                    <td><input type="text" name="buildingUse" value="<%=request.getParameter("buildingUse")==null?"":request.getParameter("buildingUse")%>"</td>
                </tr>
                <tr>
                <td>Dit kunde id:</td>
                <td><input type="text" name="custID" value="<%=request.getParameter("custID")==null?"":request.getParameter("custID")%>"</td>
                </tr>
                <tr>
                    <td>Dit kontaktperson id:</td>
                    <td><input type="text" name="CPID" value="<%=request.getParameter("CPID")==null?"":request.getParameter("CPID")%>"</td>
                </tr>
            </table>
             <input type="hidden" name="do_this" value="createBuilding">
            <input type="submit" value="Opret bygning">
        </form>
    </body>
</html>
