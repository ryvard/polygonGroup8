<%-- 
    Document   : ViewReport
    Created on : 05-04-2016, 13:52:09
    Author     : emmablomsterberg
--%>

<%@page import="businesslogic.MoistScan"%>
<%@page import="businesslogic.Condition"%>
<%@page import="businesslogic.Controller"%>
<%@page import="businesslogic.Damage"%>
<%@page import="businesslogic.Room"%>
<%@page import="businesslogic.ReviewOf"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vis rapport</title>
        <link rel="stylesheet" href="basicStyle.css">
        <link rel="stylesheet" href="createReportStyle.css">
    </head>
    <body>
    <ul1> 
        <li><a href="http://www.polygon.dk/">Polygon</a></li>
        <li><a href="Login.jsp"> Polygon login side</a></li>
        <li><a href="BuildingList.jsp">Se bygninger</a></li>
        <li><a href="CreateBuilding.jsp">Opret din bygning</a></li>
        <li><a href="CreateReport1.jsp">Opret rapport</a></li>
        <li><a href="ViewReport1.jsp">Se rapport</a></li>
    </ul1>

    <ul2>
        <li2 style="float:left;"> <img src="images.png" alt="Polygon" style="width: 200px; padding-left: 20px;"></li2>
        <li2 style="float:right; padding-right: 30px;"> <img src="logo-sunde-bygninger-property.png" alt="SundeBygninger" style="width: 200px; padding-left: 20px;"></li2>
    </ul2>
    <h1>Rapport</h1>
    <table style="margin-left: 20px;">
        <tr>
            <td>Rapport ID: <%=session.getAttribute("repID")%></td>
            <td>Dato: <%=session.getAttribute("rDate")%></td>
        </tr>
    </table>
    <h2>Bygnings gennemgang</h2>    
    <table>
        <tr>
            <td>
                Navn på bygning
            </td>
            <td>
                <%=session.getAttribute("rBName")%>
            </td>
        </tr>
        <tr>
            <td>Adresse</td>
            <td><%=session.getAttribute("rStreet")%></td>
            <td>Husnr.</td>
            <td><%=session.getAttribute("rStreetNumb")%></td>
        </tr>
        <tr>
            <td>Postnr.</td>
            <td><%=session.getAttribute("rZip")%></td> 
            <td>By</td>
            <td><%=session.getAttribute("rCity")%></td>
        </tr>
        <tr>
            <td colspan="4" style="padding-top: 25px;"><h2>General information om bygningen</h2></td>
        </tr>
        <tr>
            <td>Byggeår</td>
            <td><%=session.getAttribute("rBuildyear")%></td>
        </tr>
        <tr>
            <td>Bygningsareal i m2</td>
            <td><%=session.getAttribute("rSquareMeter")%></td>
        </tr>
        <tr>
            <td style="width:150px;">Hvad bruges bygningen til/ hvad har bygningen været brugt til?</td>
            <td><%=session.getAttribute("rUse")%></td>

        </tr>


        <tr>
            <td colspan="4" style="padding-top: 25px;"><h2>Bygning udvendig</h2></td>
        </tr>

        <%
            ArrayList<ReviewOf> outerReviewList = (ArrayList<ReviewOf>) session.getAttribute("outerReviewList");
            for (ReviewOf review : outerReviewList)
            {
        %>
        <tr>
            <td><%=review.getPart()%>:</td>
            <td><%=review.getNote()%></td>
        </tr>
        <%
            }
        %>

        <tr>
            <td colspan="4" style="padding-top: 25px;"><h2>Bygning indvendig</h2></td>
        </tr>
        </table>
        <%
            ArrayList<Room> roomList = (ArrayList<Room>) session.getAttribute("roomList");

            for (Room room : roomList)
            {
            System.out.println("room.getFloor()   " + room.getFloor());
        %>
        <table>
        <tr>
            
            <td>Etage: <%=room.getFloor()%> </td>
        </tr>
        <tr>
            <td>Rum: <%=room.getRoom()%></td>
        </tr>

        <tr>
            <td colspan="4" style="padding-top: 25px;"><h2>Skade og reperation</h2></td>
        </tr>
        <%
            ArrayList<Damage> damageList = (ArrayList<Damage>) session.getAttribute("damageList");

            for (Damage d : damageList)
            {

                System.out.println("d.getroom :" + d.getbRoom());

                if (room.getRoomID() == d.getbRoom())
                {
        %>

        <tr>
            <td>Skade i lokale:</td>
            <td><%=d.getDamageInRoom()%></td>
        </tr>
        <tr>
            <td>Hvornår:</td>
            <td><%=d.getWhen()%></td>
        </tr>
        <tr>
            <td>Hvor:</td>
            <td><%=d.getWhere()%></td>
        </tr>
        <tr>
            <td>Hvad:</td>
            <td><%=d.getWhat()%></td>
        </tr>
        <tr>
            <td>Hvad er repereret:</td>
            <td><%=d.getRepaired()%></td>
        </tr>
        <tr>
            <td>Skade type:</td>
            <td><%=d.getDamage()%></td>
        </tr>
        <tr>
            <td>Hvad:</td>
            <td><%=d.getOtherDamage()%></td>
        </tr>
        <%
                }
            }
        %>


        <tr>
            <td colspan="4" style="padding-top: 25px;"><h2>Gennemgang af..</h2></td>
        </tr>
        <%
            ArrayList<ReviewOf> reviewList = (ArrayList<ReviewOf>) session.getAttribute("reviewList");

            for (ReviewOf rev : reviewList)
            {
                if (room.getRoomID() == rev.getRoomID())
                {
        %>
        <tr>
            <td><%=rev.getPart()%></td>
            <td><%=rev.getNote()%></td>
        </tr>
        <%
                }
            }
        %>

        <tr>
            <td colspan="4" style="padding-top: 25px;"><h2>Fugtscanning</h2></td>
        </tr>
        <%
            ArrayList<MoistScan> msList = (ArrayList<MoistScan>) session.getAttribute("msList");

            for (MoistScan ms : msList)
            {
                if (room.getRoomID() == ms.getbRoom())
                {
        %>
        <tr>
            <td>Er der foretaget fugtscanning</td>
            <td><%=ms.getMsComplete()%></td>
        </tr>
        <tr>
            <td>Fugtscanning</td>
            <td><%=ms.getMoistScan()%></td>
        </tr>
        <tr>
            <td>Målepunkt</td>
            <td><%=ms.getMeasurePoint()%></td>
        </tr>
        
        <%
                }
            }
        %>
    
 </table>


    <%
        }
    %>

    <p align="center" style="padding-bottom: 25px;">Bygningsgennemgangen er foretaget af <b><%=session.getAttribute("rEmployeeFirst")%> <%=session.getAttribute("rEmployeeLast")%></b>, Polygon<br>
        i samarbejde med <b><%=session.getAttribute("rCpFirstName")%> <%=session.getAttribute("rCpLastName")%></b> (bygningsansvarlig).</p>

    <h2 style="padding-bottom: 25px;">Denne bygning er kategoriseret som tilstandsgrad: <%=session.getAttribute("condition")%></h2>
    <table padding="5">
        <tr>
            <th style="text-align: center; border: 1px solid #58585a; width: 150px;">Tilstand</th>
            <th style="text-align: center; border: 1px solid #58585a; width: 200px;">Beskrivelse af bygningen</th>
            <th style="text-align: center; border: 1px solid #58585a; width: 150px;">Funktion af bygningen</th>
        </tr> 


        <%
            Controller con = new Controller();
            ArrayList<Condition> conditions = con.getConditions();
            int i = 0;
            for (Condition c : conditions)
            {
        %>
        <tr>

            <td style="text-align: center; border: 1px solid #58585a;"><%="Tilstandsgrad " + c.getCondition()%></td>
            <td style="text-align: center; border: 1px solid #58585a;"><%=c.getDescription()%></td>
            <td style="text-align: center; border: 1px solid #58585a;"><%=c.getFunction()%></td>
        </tr>
        <%
                i++;
            }
        %>


    </table>
    <p style="font-size: 70%; margin-left: 165px; margin-right: 165px; text-align: justify; margin-bottom: 25px;">Denne rapport og bygningsgennegang er lavet for at klarlægge umiddelbare
        visuelle problemstillinger. Vores formål er at sikre, at bygningens anvendelse kan opretholdes. 
        Vi udbedre ikke skader som en del af bygningesgennemgangen/rapporten. Gennemgangen af bygningen
        indeholder ikke fugtmålinger af hele bygningen, men vi kan foretage fugtscanninger enkelte steder i 
        bygningen, hvis vi finder det nødvendigt. Hvis vi finder kritiske områder i bygningen vil vi 
        fremlægge anbefalinger angående yderligere tiltag så som yderligere undersøgelser, reparationer
        eller bygningsopdateringer.
        <br>
        <br>
        Bemærk at vi skal have adgang til hele bygningen for at kunne udføre fuld gennemgang (dette inkluderer
        adgang til tag, tagrum, kælder, krybekælder eller andre aflukkede områder). Denne bygningesgennemgang
        er ikke-destruktiv. Hvis der skal laves destruktive indgreb, skal dette først godkendes af de 
        bygningsansvarlige. Destruktive indgreb er ikke en del af denne rapport eller bygningsgennemgang.
        <br>
        <br>
        Den bygningsansvarlige skal udlevere plantegning over bygningen inden bygningsgennemgangen kan foretages.</p>
    <div style="font-weight: normal">
        Rypevang 5, DK-3450 Allerød, Danmark 
        <br>
        48140555
        <br>
        info@polygon.dk www.polygon.dk
    </div>
</body>
</html>