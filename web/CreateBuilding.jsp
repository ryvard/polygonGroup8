<%-- 
    Document   : createbuilding
    Created on : 30-03-2016, 13:47:34
    Author     : emmablomsterberg
--%>

<%@page import="businesslogic.ContactPerson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="businesslogic.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opret bygning</title>
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
        
        <h1>Opret din bygning</h1>
        <br>
        
        <form action="Servlet" method="GET">
            
            <input type="hidden" name="do_this" value="createContactPerson">
               
        <table align="center" cellpadding="3" style="margin-bottom: 200px;">
            <tr>
                <td colspan="4" style="text-align: center; padding-bottom: 20px;">Udfyld venligst felterne nedenfor for at oprette en kontaktperson, hvis dette ikke er allerede gjort</td>
            </tr>
                <tr>
                    <td colspan="2" style="font-weight: bold;">Kontaktperson information:</td>
                </tr>
                <tr>
                    <td>Fornavn:</td>
                    <td><input style="width: 100px;" type="text" name="cpFirstName"</td>
                    <td>Efternavn:</td>
                    <td><input style="width: 100px;" type="text" name="cpLastName"</td>
                </tr>
                
                <tr>
                    <td>Tel/mobil:</td>
                    <td><input style="width: 100px;" type="text" name="cpPhone"</td>
                    <td>E-mail:</td>
                    <td><input style="width: 100px;" type="text" name="cpEmail"</td>
                </tr>
                
                <tr>
                    <td colspan="4"><input type="submit" value="Opret kontaktperson"></td>
            </tr>
            </form>
        <br>
       
        <% if(session.getAttribute("cpID") != null) { %>
            <tr>
                <td colspan="3" style="padding-top: 20px; font-weight: bold;">Du har nu oprettet en kontaktperson. Dit kontakpersonnummer er:</td>
                <td style="font-weight: bold; padding-top: 20px;"><%= session.getAttribute("cpID")==null?"":session.getAttribute("cpID")%></td>
        </tr>
        <% } %> 
        <tr>
            <td colspan="4" style="text-align: center; padding: 20px;">Udfyld venligst felterne nedenfor for at oprette din bygning.</td>
        </tr>
        <form action="CreateBuilding.jsp" method="GET">              
            <%
            if(request.getParameter("do_this")!=null&&request.getParameter("do_this").equals("createBuilding"))
            {
                getServletContext().getRequestDispatcher("/Servlet").forward(request, response);
            }
            %>
            
                <tr>
                    <td>Bygningsnavn:</td>
                    <td><input style="width: 100px;" type="text" name="buildingName" value="<%=request.getParameter("buildingName")==null?"":request.getParameter("buildingName")%>"></td>
                </tr>
                <tr>
                    <td>Adresse:</td>
                    <td><input style="width: 100px;" type="text" name="street" value="<%=request.getParameter("street")==null?"":request.getParameter("street")%>"></td>
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
                    <td><input type="text" name="yearOfConst" value="<%=request.getParameter("yearOfConst")==null?"":request.getParameter("yearOfConst")%>" style="width: 40px;"</td>
                </tr>
          
               <%
                int floor = request.getParameter("addFloor")==null?1:Integer.parseInt(request.getParameter("addFloor"));
                
                for (int i = 0; i < floor; i++)
                {
                    
            %>
           
                <tr>
                    <td>Etage</td>
                    <td><input type="number" name="<%="floor"+i%>" value="<%=request.getParameter("floor"+i)==null?"":request.getParameter("floor"+i)%>" min="-10" max="50" style="width: 30px;" </td>
                </tr>
                <tr>
                    <td>Areal i m2:</td>
                    <td colspan="2"><input type="text" name="<%="squareM"+i%>" value="<%=request.getParameter("squareM"+i)==null?"":request.getParameter("squareM"+i)%>" style="width:50px;"/></td>
                </tr>
          
            <%
                    }
            %>
            <tr> 
            <input type="hidden" name="addFloor" value="<%=floor+1%>"/>
            <td style="padding-left: 0;"><input type="submit"  name="do_this" value="Tilføj etage" /></td>
            </tr>
            
            <tr>
                    <td>Bygningsareal:</td>
                    <td><input type="text" name="squareMTotal" value="<%=request.getParameter("squareM")==null?"":request.getParameter("squareM")%>" style="width: 50px;"></td>    
                </tr>
                <tr>
                    <td>Billede:</td>
                    <td><input type=image name="picture"></td>
                </tr>
                <tr>
                    <td colspan="2">Hvad bruges bygning til? / <br> Hvad har bygningen været brugt til?:</td>
                    <td colspan="2"><input type="text" name="buildingUse" value="<%=request.getParameter("buildingUse")==null?"":request.getParameter("buildingUse")%>" style="width: 100px;"</td>
                </tr>
                <tr>
                <td>Dit kunde id:</td>
                <td><input type="text" name="custID" value="<%=request.getParameter("custID")==null?"":request.getParameter("custID")%>" style="width: 100px;"</td>
                </tr>
                <tr>
                    <td>Dit kontaktperson id:</td>
                    <td><input type="text" name="CPID" value="<%=request.getParameter("CPID")==null?"":request.getParameter("CPID")%>" style="width: 100px;"</td>
                </tr>
      
             <input type="hidden" name="do_this" value="createBuilding">
             <td colspan="4" style="padding: 20px; text-align: center;"><input type="submit" value="Opret bygning"></td>
        </form>
                <div style="font-weight: normal">
        Rypevang 5, DK-3450 Allerød, Danmark 
        <br>
        48140555
        <br>
        info@polygon.dk www.polygon.dk
    </div>
    </body>
</html>
