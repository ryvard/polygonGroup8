<%-- 
    Document   : CreateReport
    Created on : 04-04-2016, 12:28:39
    Author     : Lasse
--%>

<%@page import="Domain.Condition"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logic.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- hej hej -->
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
            td
            {
                width: 125px;
            }
            h2
            {
                font-size: small;
                color: #000;
            }


        </style>
    </head>
    <body>
        <%
            if (request.getParameter("do_this") != null && request.getParameter("do_this").equals("Gem rapport"))
            {
                getServletContext().getRequestDispatcher("/Servlet").forward(request, response);
            }
        %>
        <form action="CreateReport.jsp" method="GET">
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
                               value="<%=request.getParameter("buildingName") == null ? session.getAttribute("bName") : request.getParameter("buildingName")%>"/></td>
                    <td>Dato</td>
                    <td> <input type="text" name="date" value="<%=request.getParameter("date") == null ? "" : request.getParameter("date")%>"</td>
                </tr>

                <tr>
                    <td>Adresse</td>
                    <td><input type="text" name="adress" readonly="readonly"
                               value="<%=request.getParameter("adress") == null ? session.getAttribute("bStreet") : request.getParameter("adress")%>"></td>
                </tr>
                <tr>
                    <td>vej nr.</td>
                    <td><input type="text" name="streetNumb" readonly="readonly"
                               value="<%=request.getParameter("streetNumb") == null ? session.getAttribute("bStreetNumb") : request.getParameter("streetNumb")%>" </td>
                </tr>

                <tr>
                    <td>By</td>
                    <td> <input type="text" name="city" readonly="readonly"
                                value="<%=request.getParameter("city") == null ? session.getAttribute("bCity") : request.getParameter("city")%>"/></td>
                </tr>
                <tr>
                    <td>Post nr.</td>
                    <td> <input type="text" name="zip" readonly="readonly"
                                value="<%=request.getParameter("zip") == null ? session.getAttribute("bZip") : request.getParameter("zip")%>"/></td>
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
                               value="<%=request.getParameter("buildYear") == null ? session.getAttribute("bYearOfConst") : request.getParameter("buildYear")%>"/></td>
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
                               value="<%=request.getParameter("squareMeter") == null ? session.getAttribute("bSquareMeter") : request.getParameter("squareMeter")%>"/></td>
                </tr>

                <tr>
                    <td>Hvad bruges bygningen til / hvad har bygningen været brugt til</td>
                </tr>

                <tr>
                    <td><input type="text" name="bUse" readonly="readonly" style="width: 300px;"
                               value="<%=request.getParameter("bUse") == null ? session.getAttribute("bUse") : request.getParameter("bUse")%>"/></td>
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
                               value="<%=request.getParameter("roof") == null ? "" : request.getParameter("roof")%>"/></td>
                    <td align="right">Billede</td>
                    <td><input type="file"/></td>
                    <td><input type="checkbox" name="roofPicture" value="ON" /></td>
                    
                </tr>

                <tr>
                    <td>Ydervægge</td>
                    <td><input type="text" name="outerwalls" style="width: 300px;"
                               <%=request.getParameter("outerwalls") == null ? "" : request.getParameter("outerwalls")%>/></td>
                    <td align="right">Billede</td>
                    <td><input type="file"/></td>
                    
                    <td><input type="checkbox" name="outerwallsPicture" value="ON" /></td>
                    
                </tr>
            </table>

            <%
                int pages = request.getParameter("addRoom") == null ? 1 : Integer.parseInt(request.getParameter("addRoom"));

                for (int i = 0; i < pages; i++)
                {
            %>
            <br>
            <div  style="width:800px;height:1000px;border:1px solid #000; margin-left: 10px">
                <br>
                <table cellpadding="5">
                    <tr>
                        <td><h2>Lokale nr.<h2></td>
                                    <td><input type="number" name="<%="room" + i%>" style="width: 50px;"
                                               value="<%=request.getParameter("room" + i) == null ? "" : request.getParameter("room" + i)%>" /></td>
                                    </tr>
                                    </table>
                                    <br>
                                    <table cellpadding="5">
                                        <tr><td colspan="2"><h2>Skade og reperation</h2></td></tr>
                                        <tr>
                                            <td>Har der været skade i lokalet?</td>
                                            <td><select name="<%="damageInRoom" + i%>" 
                                                        value="<%=request.getParameter("damageInRoom" + i) == null ? "" : request.getParameter("damageInRoom" + i)%>"/>
                                        <option>Nej</option>
                                        <option>Ja</option>
                                        </select></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">Hvis ja udfyld venligst felterne nedenfor</td>
                                        </tr>
                                        <tr>
                                            <td>Hvornår</td>
                                            <td><input type="text" name="<%="when" + i%>" style="width: 200px;"
                                                       value="<%=request.getParameter("when" + i) == null ? "" : request.getParameter("when" + i)%>" /></td>
                                        </tr>
                                        <tr>
                                            <td>Hvor</td>
                                            <td><input type="text" name="<%="where" + i%>" style="width: 400px;"
                                                       value="<%=request.getParameter("where" + i) == null ? "" : request.getParameter("where" + i)%>" /></td>
                                        </tr>
                                        <tr>
                                            <td>Hvad er der sket</td>
                                            <td><input type="text" name="<%="what" + i%>" style="width: 400px;"
                                                       value="<%=request.getParameter("what" + i) == null ? "" : request.getParameter("what" + i)%>" /></td>
                                        </tr>
                                        <tr>
                                            <td>Hvad er repereret</td>
                                            <td><input type="text" name="<%="repaired" + i%>"style="width: 400px;"
                                                       value="<%=request.getParameter("repaired" + i) == null ? "" : request.getParameter("repaired" + i)%>" /></td>
                                        </tr>
                                        <tr>
                                            <td>Skade</td>
                                            <td><input type="checkbox" name="<%="damage" + i%>" value="moist" />Fugt<br>
                                                <input type="checkbox" name="<%="damage" + i%>" value="rotAndMold" />Råd og svamp<br>
                                                <input type="checkbox" name="<%="damage" + i%>" value="mold" />Skimmel<br>
                                                <input type="checkbox" name="<%="damage" + i%>" value="fire" />Brand<br>

                                                Anden skade:
                                                <input type="text" name="<%="otherDamage" + i%>" style="width: 250px;"
                                                       value="<%=request.getParameter("otherDamage" + i) == null ? "" : request.getParameter("otherDamage" + i)%>" />
                                            </td>
                                        </tr>
                                    </table>
                                    <br><br>
                                    <table cellpadding="5">
                                        <tr>
                                            <td colspan="2"><h2>Gennemgang af...</h2></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td style="text-align: center">Bemærkning</td>
                                            <td style="text-align: center">Billede</td>
                                        </tr>
                                        <tr>
                                            <td>Vægge</td>
                                            <td><input type="text" name="<%="wallNote" + i%>" style="width: 400px;"
                                                       value="<%=request.getParameter("wallNote" + i) == null ? "" : request.getParameter("wallNote" + i)%>"/></td>
                                        </tr>
                                        <tr>
                                            <td>Loft</td>
                                            <td><input type="text" name="<%="ceilingNote" + i%>" style="width: 400px;"
                                                       value="<%=request.getParameter("ceilingNote" + i) == null ? "" : request.getParameter("ceilingNote" + i)%>"/></td>
                                        </tr>
                                        <tr>
                                            <td>Gulv</td>
                                            <td><input type="text" name="<%="floorNote" + i%>" style="width: 400px;"
                                                       value="<%=request.getParameter("floorNote" + i) == null ? "" : request.getParameter("floorNote" + i)%>"/></td>
                                        </tr>
                                        <tr>
                                            <td>Vinduer</td>
                                            <td><input type="text" name="<%="windowNote" + i%>" style="width: 400px;"
                                                       value="<%=request.getParameter("windowNote" + i) == null ? "" : request.getParameter("windowNote" + i)%>"/></td>
                                        </tr>
                                        <tr>
                                            <td>Døre</td>
                                            <td><input type="text" name="<%="doorNote" + i%>" style="width: 400px;"
                                                       value="<%=request.getParameter("doorNote" + i) == null ? "" : request.getParameter("doorNote" + i)%>"/></td>
                                        </tr>
                                        <tr>
                                            <td><input type="text" name="<%="otherPart1" + i%>" style="color:#888;"
                                                       value="<%=request.getParameter("otherPart1" + i) == null ? "Andet:" : request.getParameter("otherPart1" + i)%>"
                                                       onfocus="inputFocus(this)" onblur="inputBlur(this)"/></td>
                                            <td><input type="text" name="<%="otherNote1" + i%>" style="width: 400px;"
                                                       value="<%=request.getParameter("otherNote1" + i) == null ? "" : request.getParameter("otherNote1" + i)%>"/></td>
                                        </tr>
                                        <tr>
                                            <td><input type="text" name="<%="otherPart2" + i%>" style="color:#888;"
                                                       value="<%=request.getParameter("otherPart2" + i) == null ? "Andet:" : request.getParameter("otherPart2" + i)%>"
                                                       onfocus="inputFocus(this)" onblur="inputBlur(this)"/></td>
                                            <td><input type="text" name="<%="otherNote2" + i%>" style="width: 400px;"
                                                       value="<%=request.getParameter("otherNote2" + i) == null ? "" : request.getParameter("otherNote2" + i)%>"/></td>
                                        </tr>
                                    </table>
                                    <br><br>
                                    <table cellpadding="5">
                                        <tr>
                                            <td colspan="2"><h2>Fugtscanning</h2></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">Er der foretaget fugtscanning</td>
                                            <td><select name="<%="moistScanCompletet" + i%>"/>
                                        <option>Nej</option>
                                        <option>Ja</option>
                                        </select>
                                        </td>
                                        </tr>
                                        <tr>
                                            <td>Fugtscaning</td>
                                            <td><input type="text" name="<%="moistScan" + i%>" style="width: 100px"
                                                       value="<%=request.getParameter("moistScan" + i) == null ? "" : request.getParameter("moistScan" + i)%>"/></td>
                                            <td>Målepunkt</td>
                                            <td><input type="text" name="<%="measurePoint" + i%>" style="width: 100px"
                                                       value="<%=request.getParameter("measurePoint" + i) == null ? "" : request.getParameter("measurePoint" + i)%>"/></td>
                                        </tr>
                                    </table>
                                    <br><br>
                                    <table cellpadding="5">
                                        <tr>
                                            <td colspan="2"><h2>Konklusion</h2></td>
                                        </tr>
                                        <tr>
                                            <td>Anbefaling</td>
                                            <td><input type="text" name="<%="recommendation" + i%>" style="width: 400px;"
                                                       value="<%=request.getParameter("recommendation" + i) == null ? "" : request.getParameter("recommendation" + i)%>"/></td>
                                        </tr>
                                    </table>
                                    </div>
                                    <br>
                                    <%
                                        }
                                    %>

                                    <input type="hidden" name="addRoom" value="<%=pages + 1%>"/>
                                    <input type="submit"  name="do_this" value="Tilføj lokale" />

                                    <br><br>

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
                                    <table style="border: 1px solid black; border-collapse: collapse;">
                                        <tr>
                                            <th style="text-align: left; border: 1px solid black">Tilstand</th>
                                            <th style="text-align: left; border: 1px solid black">Beskrivelse af bygningen</th>
                                            <th style="text-align: left; border: 1px solid black">Funktion af bygningen</th>
                                            <th style="text-align: left; border: 1px solid black">Tilstandsgrad</th>
                                        </tr>
                                    <%
                                        Controller cntr = new Controller();
                                        ArrayList<Condition> conditions = cntr.getConditions();
                                        int i = 0;
                                        for (Condition c : conditions)
                                        {
                                    %>
                                        <tr>
                                            
                                            <td><%=c.getCondition()%></td>
                                            <td><%=c.getDescription()%></td>
                                            <td><%=c.getFunction()%></td>
                                            <td><input type="radio" name="condition" value="<%=i%>"/></td>
                                        </tr>
                                    <%
                                            i++;
                                        }
                                    %>
                                    </table>


                                    <br>

                                    <div>Bygningen er kategoriseret som</div>

                                    <table ">
                                        <br>
                                        <tr>
                                            
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

                                    <p style="font-size: 70%;">
                                        Denne rapport og bygningsgennegang er lavet for at klarlægge umiddelbare
                                        visuelle problemstillinger. Vores formål er at sikre, at <br> 
                                        bygningens anvendelse kan opretholdes. Vi udbedre ikke skader som en del af bygningesgennemgangen/rapporten. Gennemgangen <br> 
                                        af bygningen indeholder ikke fugtmålinger af hele bygningen, men vi kan foretage fugtscanninger enkelte steder i bygningen, hvis vi <br> 
                                        finder det nødvendigt. Hvis vi finder kritiske områder i bygningen vil vi fremlægge anbefalinger angående yderligere tiltag så som <br> 
                                        yderligere undersøgelser, reparationer eller bygningsopdateringer. <br><br>
                                        Bemærk at vi skal have adgang til hele bygningen for at kunne udføre fuld gennemgang (dette inkluderer adgang til tag, tagrum, <br> 
                                        kælder, krybekælder eller andre aflukkede områder). Denne bygningesgennemgang er ikke-destruktiv. Hvis der skal laves destruktive <br> 
                                        indgreb, skal dette først godkendes af de bygningsansvarlige. Destruktive indgreb er ikke en del af denne rapport eller <br> 
                                        bygningsgennemgang.<br><br>
                                        Den bygningsansvarlige skal udlevere plantegning over bygningen inden bygningsgennemgangen kan foretages.
                                    </p>
                                    <input type="submit" name="do_this" value="Gem rapport">
                                    </form>
                                    </body>
                                    </html>
