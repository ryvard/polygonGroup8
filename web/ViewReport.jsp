<%-- 
    Document   : ViewReport
    Created on : 05-04-2016, 13:52:09
    Author     : emmablomsterberg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opret rapport</title>
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

        </style>
    </head>
    <body>
        <form>
            <table>
                <tr>
                    <td align="left"><input type="text" name="reportNumber" title="Rapport nr.:" style="color:#888;" 
                                            value="Rapport nr.:" onfocus="inputFocus(this)" onblur="inputBlur(this)"> </td>
                </tr>
            </table>

            <table>
                <td></td>
                <td><h1>Bygningsgennemgang</h1></td>

                <tr>
                    
                    <td>Navn på bygning</td>
                    <td><input type="text" name="buildningName" readonly="readonly"
                               value="<%=session.getAttribute("rBName")%>"/></td>
                    <td>Dato</td>
                    <td> <input type="text" name="date" value="<%=session.getAttribute("rDate")%>"</td>
                </tr>

                <tr>
                    <td>Adresse</td>
                    <td><input type="text" name="adress" readonly="readonly"
                               value="<%=session.getAttribute("rStreet")%>"></td>
                </tr>
                <tr>
                    <td>vej nr.</td>
                    <td><input type="text" name="streetNumb" readonly="readonly"
                               value="<%=session.getAttribute("rStreetNumb")%>" </td>
                </tr>

                <tr>
                    <td>By</td>
                    <td> <input type="text" name="city" readonly="readonly"
                                value="<%=session.getAttribute("rCity")%>"/></td>
                </tr>
                <tr>
                    <td>Post nr.</td>
                    <td> <input type="text" name="zip" readonly="readonly"
                                value="<%=session.getAttribute("rZip")%>"/></td>
                </tr>


            </table>
            <br> 

            <table>
                <div style="width:500px;height:100px;border:1px solid #000;">(Indsæt billede af bygning udefra)</div>
                <br>
                <tr>
                <div>Generel information om bygningen</div>
                <br> 
                <td>Byggeår</td>
                </tr>
                <tr>
                    <td><input type="text" name="buildYear" readonly="readonly"
                               value="<%=session.getAttribute("rBuildyear")%>"/></td>
                </tr>


                <tr>
                    <td>Etage</td>
                </tr>
                <tr>
                    <td><input type="number" name="qty" value="1" min="-10" max="50"</td>
                    <td>Etage-areal i m²</td>
                    <td><input type="text" name="floorSquareMeter" value=""/></td>
                </tr>

                <tr>
                    <td>Totale bygnings-areal i m²</td>
                </tr>
                <tr>
                    <td><input type="text" name="squareMeter" readonly="readonly"
                               value="<%=request.getParameter("squareMeter")==null?session.getAttribute("bSquareMeter"):request.getParameter("squareMeter")%>"/></td>
                </tr>

                <tr>
                    <td>Hvad bruges bygningen til / hvad har bygningen været brugt til</td>
                </tr>

                <tr>
                    <td><input type="text" name="bUse" readonly="readonly" style="width: 300px;"
                               value="<%=request.getParameter("bUse")==null?session.getAttribute("bUse"):request.getParameter("bUse")%>"/></td>
                </tr>
            </table>

            <table>
                <tr>
                <br>
                <div>Gennemgang af bygning udvendig</div>
                <br>
                </tr>

                <tr>
                    <td>Tag</td>
                    <td><input type="text" name="roof" style="width: 300px;"
                               value="<%=request.getParameter("roof")==null?"":request.getParameter("roof")%>"/></td>
                    <td align="right">Billede</td>
                    <td><input type="checkbox" name="roofPicture" value="ON" /></td>
                </tr>

                <tr>
                    <td>Ydervægge</td>
                    <td><input type="text" name="outerwalls" style="width: 300px;"
                               <%=request.getParameter("outerwalls")==null?"":request.getParameter("outerwalls")%>/></td>
                    <td align="right">Billede</td>
                    <td><input type="checkbox" name="outerwallsPicture" value="ON" /></td>
                </tr>
            </table>

            <%
                int pages = request.getParameter("addRoom")==null?1:Integer.parseInt(request.getParameter("addRoom"));
                
                for (int i = 0; i < pages; i++)
                {
            %>
            <table>
                <div>Lokale</div>
                <input type="text" name="<%="room"+i%>" value="<%=request.getParameter("room"+i)==null?"":request.getParameter("room"+i)%>" />
            </table>
            <%
                    }
            %>
             
            <input type="hidden" name="addRoom" value="<%=pages+1%>"/>
            <input type="submit"  name="do_this" value="Tilføj lokale" />
            
            <br>
                <div>Konklusion</div>
                <br>

                <table style="border: 1px solid black; border-collapse: collapse;">

                    <tr>
                        <th style="text-align: left; border: 1px solid black">Lokale</th>
                        <th style="text-align: left; border: 1px solid black">Anbefaling</th>	
                    </tr>

                    <tr>
                        <td><input style="width: 75px;" type="number" name="conclusionRoom1"></td>
                        <td><input style="width: 400px;"type="text" name="recommendation1"></td>		
                    </tr>

                    <tr>
                        <td><input style="width: 75px;" type="number" name="conclusionRoom2"></td>
                        <td><input style="width: 400px;"type="text" name="recommendation2"></td>
                    </tr>

                    <tr>
                        <td><input style="width: 75px;" type="number" name="conclusionRoom3"></td>
                        <td><input style="width: 400px;"type="text" name="recommendation3"></td>
                    </tr>

                    <tr>
                        <td><input style="width: 75px;" type="number" name="conclusionRoom4"></td>
                        <td><input style="width: 400px;"type="text" name="recommendation4"></td>
                    </tr>

                    <tr>
                        <td><input style="width: 75px;" type="number" name="conclusionRoom5"></td>
                        <td><input style="width: 400px;"type="text" name="recommendation5"></td>
                    </tr>

                    <tr>
                        <td><input style="width: 75px;" type="number" name="conclusionRoom6"></td>
                        <td><input style="width: 400px;"type="text" name="recommendation6"></td>
                    </tr>

                    <tr>
                        <td><input style="width: 75px;" type="number" name="conclusionRoom7"></td>
                        <td><input style="width: 400px;"type="text" name="recommendation7"></td>
                    </tr>

                    <tr>
                        <td><input style="width: 75px;" type="number" name="conclusionRoom8"></td>
                        <td><input style="width: 400px;"type="text" name="recommendation8"></td>
                    </tr>
                </table>

                <table>
                    <br>
                    <tr>
                        <td>Bygningsgennemgangen er foretaget af</td>
                        <td><input type="text" name="reviewedBy"></td>
                        <td>, Polygon</td>
                    </tr>
                    <tr>
                        <td>i samarbejde med</td>
                        <td><input type="text" name="collaboration"></td>
                        <td> (bygningsansvarlig).</td>
                    </tr>
                </table>

                <br>

                <div>Bygningen er kategoriseret som</div>

                <table style="border: 1px solid black; border-collapse: collapse;">
                    <br>
                    <tr>
                        <th style="text-align: left; border: 1px solid black">Tilstand</th>
                        <th style="text-align: left; border: 1px solid black">Beskrivelse af bygningen</th>
                        <th style="text-align: left; border: 1px solid black">Funktion af bygningen</th>
                        <th style="text-align: left; border: 1px solid black">Tilstandsgrad</th>
                    </tr>

                    <tr>
                        <td><input style="width: 105px; font-weight: bold "type="text" value="Tilstandsgrad 0" 
                                   readonly="readonly"</td>
                        <td><input style="width: 205px;"type="text" value="Bygningsdelen er ny og som bygget"></td>
                        <td><input style="width: 185px;" type="text" value="Funktionen er som beskrevet"></td>
                        <td><input type="checkbox" name="condition" value="0" style="width: 100px;"></td>
                    </tr>

                    <tr>
                        <td><input style="width: 105px; font-weight: bold " type="text" value="Tilstandsgrad 1" 
                                   readonly="readonly"</td>
                        <td><input style="width: 205px;"type="text" value=""></td>
                        <td><input style="width: 185px;" type="text" value=""></td>
                        <td><input type="checkbox" name="condition" value="1" style="width: 100px;"></td>
                    </tr>

                    <tr>
                        <td><input style="width: 105px; font-weight: bold " type="text" value="Tilstandsgrad 2" 
                                   readonly="readonly"</td>
                        <td><input style="width: 205px;"type="text" value=""></td>
                        <td><input style="width: 185px;" type="text" value=""></td>
                        <td><input type="checkbox" name="condition" value="2" style="width: 100px;"></td>
                    </tr>

                    <tr>
                        <td><input style="width: 105px; font-weight: bold " type="text" value="Tilstandsgrad 3" 
                                   readonly="readonly"</td>
                        <td><input style="width: 205px;"type="text" value=""></td>
                        <td><input style="width: 185px;" type="text" value=""></td>
                        <td><input type="checkbox" name="condition" value="3" style="width: 100px;"></td>
                    </tr>
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


                <input type="submit" name="do_this" value="Gem rapport">
                </form>
                </body>
                </html>