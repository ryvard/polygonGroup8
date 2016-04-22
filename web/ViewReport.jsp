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
        <style>
            h1 {

                text-align: center;
            }

            div {

                font-size: 75%;
                font-weight: bold; 
            }

            body {

                font-family: verdana;
            }

            table {
                font-size: 75%;
            }
            td
            {
                width: 200px;
            }
            div {
                width: 300px;
                padding: 25px;
                border: 10px solid navy;
                margin: 25px;
            }

        </style>
    </head>
    <body>
        <h1>hejhej</h1>
        <table border="1">
            <tr>
                <td>Rapport ID: <%=session.getAttribute("repID")%></td>
                <td>Dato: <%=session.getAttribute("rDate")%></td>
            </tr>
        </table>
        <h2>Bygnings gennemgang</h2>    
        <table border="1">
            <tr>
                <td>
                    <b>navn på bygning</b>
                </td>
                <td>
                    <%=session.getAttribute("rBName")%>
                </td>
            </tr>
            <tr>
                <td><b>Adresse</b></td>
                <td><%=session.getAttribute("rStreet")%></td>
                <td><%=session.getAttribute("rStreetNumb")%></td>
            </tr>
            <tr>
                <td><b>Postnr./By</b></td>
                <td><%=session.getAttribute("rZip")%></td> 
                <td><%=session.getAttribute("rCity")%></td>
            </tr>
        </table>
        <h2>General information om bygningen</h2>
        <table border="1">
            <tr>
                <td><b>Byggeår</b></td>
                <td><%=session.getAttribute("rBuildYear")%></td>
            </tr>
            <tr>
                <td><b>Bygningsareal i m2</b></td>
                <td><%=session.getAttribute("rSquareMeter")%></td>
            </tr>
            <tr>
                <td><b>Hvad bruges bygningen til/ hvad har bygningen været brugt til?</b></td>
                <td><%=session.getAttribute("rUse")%></td>

            </tr>
        </table >


        <h2>Bygning udvendig</h2>
        <table Border="1">
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
        </table>

        <h2>Bygning indvendig</h2>

        <%
            System.out.println("hejehjehej");
            ArrayList<Room> roomList = (ArrayList<Room>) session.getAttribute("roomList");
            System.out.println("JSP roomlist" + roomList.size() + "room:" + roomList.get(0).getRoom());
            for (Room room : roomList)
            {
        %>
        <div>
            <p>Floor: <%=room.getFloor()%> Room: <%=room.getRoom()%></p>
            <br>
            <h2>Skade og reperation</h2>
            <table border="1">
                <%
                    ArrayList<Damage> damageList = (ArrayList<Damage>) session.getAttribute("damageList");
                    System.out.println("damge size: " + damageList.size());
                    System.out.println("room.getroom :" + room.getRoom() + "room.getroomid" + room.getRoomID());
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
            </table>
            
            <br>
            <h2>Gennemgang af..</h2>
            <table border="1">
                <%
                    ArrayList<ReviewOf> reviewList = (ArrayList<ReviewOf>) session.getAttribute("reviewList");
                    
                    
                    for (ReviewOf rev : reviewList)
                    {
                        if (room.getRoomID() == rev.getRoomID())
                        {
                %>
                <tr>
                    <td><b><%=rev.getPart()%></b></td>
                    <td><%=rev.getNote()%></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
            <br>
            <h2>Fugtscanning</h2>
            <table border="1">
                <%
                    ArrayList<MoistScan> msList = (ArrayList<MoistScan>) session.getAttribute("msList");
                    
                    
                    for (MoistScan ms : msList)
                    {
                        if (room.getRoomID() == ms.getbRoom())
                        {
                %>
                <tr>
                    <td><b>Er der foretaget fugtscanning</b></td>
                    <td><%=ms.getMsComplete()%></td>
                </tr>
                <tr>
                    <td><b>Fugtscanning</b></td>
                    <td><%=ms.getMoistScan()%></td>
                </tr>
                <tr>
                    <td><b>Målepunkt</b></td>
                    <td><%=ms.getMeasurePoint()%></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
            <br>
            
        </div>
        <%
            }
        %>
        <br>
        <p>Bygningsgennemgangen er foretaget af <b><%=session.getAttribute("rEmployeeFirst")%> <%=session.getAttribute("rEmployeeLast")%></b>, Polygon<br>
            i samarbejde med <b><%=session.getAttribute("rCpFirstName")%> <%=session.getAttribute("rCpLastName")%></b>(bygningsansvarlig).</p>

        <h2>Denne bygning er kategoriseret som tilstandsgrad: <%=session.getAttribute("condition")%></h2>
        <table style="border: 1px solid black; " padding="5">
            <tr>
                <th style="text-align: center; border: 1px solid black; width:100px ;">Tilstand</th>
                <th style="text-align: center; border: 1px solid black; width:250px ; ">Beskrivelse af bygningen</th>
                <th style="text-align: center; border: 1px solid black; width:250px ;">Funktion af bygningen</th>
            </tr> 


            <%
                Controller con = new Controller();
                ArrayList<Condition> conditions = con.getConditions();
                int i = 0;
                for (Condition c : conditions)
                {
            %>
            <tr>

                <td style="text-align: center;"><%="Tilstandsgrad " + c.getCondition()%></td>
                <td><%=c.getDescription()%></td>
                <td><%=c.getFunction()%></td>
            </tr>
            <%
                    i++;
                }
            %>


        </table>
        <p style="font-size: 70%;">Denne rapport og bygningsgennegang er lavet for at klarlægge umiddelbare
            visuelle problemstillinger. Vores formål er at sikre, at <br> bygningens anvendelse kan opretholdes. 
            Vi udbedre ikke skader som en del af bygningesgennemgangen/rapporten. Gennemgangen <br> af bygningen
            indeholder ikke fugtmålinger af hele bygningen, men vi kan foretage fugtscanninger enkelte steder i 
            bygningen, hvis vi <br> finder det nødvendigt. Hvis vi finder kritiske områder i bygningen vil vi 
            fremlægge anbefalinger angående yderligere tiltag så som <br> yderligere undersøgelser, reparationer
            eller bygningsopdateringer.
            <br>
            <br>
            Bemærk at vi skal have adgang til hele bygningen for at kunne udføre fuld gennemgang (dette inkluderer
            adgang til tag, tagrum, <br> kælder, krybekælder eller andre aflukkede områder). Denne bygningesgennemgang
            er ikke-destruktiv. Hvis der skal laves destruktive <br> indgreb, skal dette først godkendes af de 
            bygningsansvarlige. Destruktive indgreb er ikke en del af denne rapport eller <br> bygningsgennemgang.
            <br>
            <br>
            Den bygningsansvarlige skal udlevere plantegning over bygningen inden bygningsgennemgangen kan foretages.</p>



    </body>
</html>