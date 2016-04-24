<%-- 
    Document   : CreateReport
    Created on : 04-04-2016, 12:28:39
    Author     : Lasse
--%>

<%@page import="businesslogic.Floor"%>
<%@page import="businesslogic.Condition"%>
<%@page import="java.util.ArrayList"%>
<%@page import="businesslogic.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opret rapport</title>
        <link rel="stylesheet" href="basicStyle.css">
        <link rel="stylesheet" href="createReportStyle.css"
        
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

    <%
        if (request.getParameter("do_this") != null && request.getParameter("do_this").equals("Gem rapport")) {
            getServletContext().getRequestDispatcher("/Servlet").forward(request, response);
        }
    %>
    <form action="CreateReport.jsp" method="GET">
        <input type="hidden" name="buildingID" value="<%=session.getAttribute("ID")%>"/>
        <table style="margin-left:10px;">
            <tr>
                <td>Rapport ID: <%=session.getAttribute("newRepID")%></td>
                

            </tr>
        </table>
        <h1>Bygningsgennemgang</h1>
        <table align="center" >
            <tr>
                <td>Navn på bygning</td>
                <td><input type="text" name="buildningName" readonly="readonly"
                           value="<%=request.getParameter("buildingName") == null ? session.getAttribute("bName") : request.getParameter("buildingName")%>"/></td>
                <td>Dato</td>
                <td><input type="text" name="date" placeholder="(dd-mm-yy)"
                                       value="<%=request.getParameter("date") == null ? "" : request.getParameter("date")%>"</td>
            </tr>
            <tr>
                <td>Adresse</td>
                <td><input type="text" name="adress" readonly="readonly"
                           value="<%=request.getParameter("adress") == null ? session.getAttribute("bStreet") : request.getParameter("adress")%>"></td>
            
            
                <td>vej nr.</td>
                <td><input type="text" name="streetNumb" readonly="readonly"
                           value="<%=request.getParameter("streetNumb") == null ? session.getAttribute("bStreetNumb") : request.getParameter("streetNumb")%>" </td>
            </tr>

            <tr>
                <td>By</td>
                <td> <input type="text" name="city" readonly="readonly"
                            value="<%=request.getParameter("city") == null ? session.getAttribute("bCity") : request.getParameter("city")%>"/></td>
            
                <td>Post nr.</td>
                <td> <input type="text" name="zip" readonly="readonly"
                            value="<%=request.getParameter("zip") == null ? session.getAttribute("bZip") : request.getParameter("zip")%>"/></td>
            </tr>
            <td style="padding-top: 20px;" align="right">Indsæt billede af bygning udefra</td>
                <td style="padding-top: 20px;"><input type="file"/></td>
                <td style="padding-top: 20px;"><input type="checkbox" name="roofPicture" value="ON" /></td>
            
                </table>      
            <table>
       <tr>
        <td colspan="6"><h2>Generel information om bygningen</h2></td>
        </tr>
            <tr>
                <td>Byggeår:</td>
                <td><input type="text" name="buildYear" readonly="readonly"
                           value="<%=request.getParameter("buildYear") == null ? session.getAttribute("bYearOfConst") : request.getParameter("buildYear")%>"/></td>
            </tr>
            <tr>
                <td>Totale bygnings-areal i m²:</td>
                <td><input type="text" name="squareMeter" readonly="readonly"
                           value="<%=request.getParameter("squareMeter") == null ? session.getAttribute("bSquareMeter") : request.getParameter("squareMeter")%>"/></td>
            </tr>
            <tr>
                <td>Hvad bruges bygningen til <br> / hvad har bygningen <br> været brugt til</td>
                <td><input type="text" name="bUse" readonly="readonly" style="width: 100px;"
                           value="<%=request.getParameter("bUse") == null ? session.getAttribute("bUse") : request.getParameter("bUse")%>"/></td>
                          
            </tr>
            
                           
                <tr>
        <td style="padding: 20px;" colspan="6"><h2>Gennemgang af bygning udvendig</h2></td>
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
                           value="<%=request.getParameter("outerwalls") == null ? "" : request.getParameter("outerwalls")%>"/></td>
                <td align="right">Billede</td>
                <td><input type="file"/></td>
                <td><input type="checkbox" name="outerwallsPicture" value="ON" /></td>
            </tr>
            
            <tr>
                
        <td style="padding: 20px;" colspan="6"><h2>Gennemgang af bygning indvendig</h2></td>
        </tr>
        <%
            int pages = request.getParameter("addRoom") == null ? 1 : Integer.parseInt(request.getParameter("addRoom"));

            for (int i = 0; i < pages; i++) {
        %>
        
                <tr>
                    <td>Vælg lokale</td>
                </tr>
                <tr>
                    <td>Etage:</td>
                    <td>
                        <select name="<%="floor" + i%>"
                                value="<%=request.getParameter("floor" + i) == null ? "" : request.getParameter("floor" + i)%>">
                            <%
                                ArrayList<Floor> floorList = (ArrayList<Floor>) session.getAttribute("floorList");
                                for (Floor f : floorList) {
                            %>
                            <option value="<%=f.getFloorID()%>"><%=f.getFloor()%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Lokale nr.:</td>
                    <td><input type="number" name="<%="room" + i%>" style="width: 50px;"
                               value="<%=request.getParameter("room" + i) == null ? "" : request.getParameter("room" + i)%>" /></td>
                </tr>
                <tr>
                    
                
                <td colspan="6"><h2>Skade og reparation</h2></td>
                </tr>
                <tr>
                    <td>Har der været skade i lokalet?</td>
                    <td><select name="<%="damageInRoom" + i%>" 
                                value="<%=request.getParameter("damageInRoom" + i) == null ? "" : request.getParameter("damageInRoom" + i)%>"/>
                <option>Nej</option>
                <option>Ja</option>
                </select></td>
                </tr>
                <tr>
                    <td colspan="6">Hvis ja udfyld venligst felterne nedenfor</td>
                </tr>
                <tr>
                    <td>Hvornår</td>
                    <td><input type="text" name="<%="when" + i%>" style="width: 200px;"
                               value="<%=request.getParameter("when" + i) == null ? "" : request.getParameter("when" + i)%>" /></td>
                </tr>
                <tr>
                    <td>Hvor</td>
                    <td colspan="5"><input type="text" name="<%="where" + i%>" style="width: 400px;"
                               value="<%=request.getParameter("where" + i) == null ? "" : request.getParameter("where" + i)%>" /></td>
                </tr>
                <tr>
                    <td>Hvad er der sket</td>
                    <td colspan="5"><input type="text" name="<%="what" + i%>" style="width: 400px;"
                               value="<%=request.getParameter("what" + i) == null ? "" : request.getParameter("what" + i)%>" /></td>
                </tr>
                <tr>
                    <td>Hvad er repareret</td>
                    <td colspan="5"><input type="text" name="<%="repaired" + i%>"style="width: 400px;"
                               value="<%=request.getParameter("repaired" + i) == null ? "" : request.getParameter("repaired" + i)%>" /></td>
                </tr>
                <tr>
                    <td>Skade</td>
                    
                    

                    <td colspan="5"><input type="radio" name="<%="damage" + i%>" value="Fugt" />Fugt<br>
                        <input type="radio" name="<%="damage" + i%>" value="Raad og svamp" />Råd og svamp<br>
                        <input type="radio" name="<%="damage" + i%>" value="Skimmel" />Skimmel<br>
                        <input type="radio" name="<%="damage" + i%>" value="Brand" />Brand<br>

                        Anden skade:
                        <input type="text" name="<%="otherDamage" + i%>" style="width: 250px;"
                               value="<%=request.getParameter("otherDamage" + i) == null ? "" : request.getParameter("otherDamage" + i)%>" />
                    </td>
                </tr>
           
                <tr>
                    <td colspan="6"><h2>Gennemgang af...</h2></td>
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
                    <td><input type="text" name="<%="otherPart1" + i%>" placeholder="Andet:"
                               value="<%=request.getParameter("otherPart1" + i) == null ? "" : request.getParameter("otherPart1" + i)%>"/></td>
                    <td><input type="text" name="<%="otherNote1" + i%>" style="width: 400px;"
                               value="<%=request.getParameter("otherNote1" + i) == null ? "" : request.getParameter("otherNote1" + i)%>"/></td>
                </tr>
                <tr>
                    <td><input type="text" name="<%="otherPart2" + i%>" placeholder="Andet:"
                               value="<%=request.getParameter("otherPart2" + i) == null ? "" : request.getParameter("otherPart2" + i)%>"/></td>
                    <td><input type="text" name="<%="otherNote2" + i%>" style="width: 400px;"
                               value="<%=request.getParameter("otherNote2" + i) == null ? "" : request.getParameter("otherNote2" + i)%>"/></td>
                </tr>
                    
                
                <tr>
                    <td colspan="6"><h2>Fugtscanning</h2></td>
                </tr>
                <tr>
                    <td>Er der foretaget fugtscanning</td>
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
                </tr>
                <tr>
                    <td>Målepunkt</td>
                    <td><input type="text" name="<%="measurePoint" + i%>" style="width: 100px"
                               value="<%=request.getParameter("measurePoint" + i) == null ? "" : request.getParameter("measurePoint" + i)%>"/></td>
                </tr>
               
                
                <tr>
                    <td colspan="6"><h2>Konklusion</h2></td>
                </tr>
                <tr>
                    <td>Anbefaling</td>
                    <td colspan="5"><input type="text" name="<%="recommendation" + i%>" 
                               value="<%=request.getParameter("recommendation" + i) == null ? "" : request.getParameter("recommendation" + i)%>"/></td>
                </tr>
            
        
        <%
            }
        %>

        <input type="hidden" name="addRoom" value="<%=pages + 1%>"/>
        <td><input type="submit"  name="do_this" value="Tilføj lokale" /></td>
        
        </table>
        <table>
        <tr>
            <td colspan="6" style="padding: 20px;">Bygningsgennemgangen er foretaget af 
            <input type="text" name="eFirstName" placeholder="Fornavn"
                   value="<%=request.getParameter("eFirstName") == null ? "" : request.getParameter("eFirstName")%>"/>
            <input type="text" name="eLastName" placeholder="Efternavn"
                   value="<%=request.getParameter("eLastName") == null ? "" : request.getParameter("eLastName")%>"/>
            , Polygon<br>
            i samarbejde med 
            <input type="text" name="cpFirstName" placeholder="Fornavn"
                   value="<%=request.getParameter("cpFirstName") == null ? session.getAttribute("cpFirstName") : request.getParameter("cpFirstName")%>"/>
            <input type="text" name="CPLastName" placeholder="Efternavn"
                   value="<%=request.getParameter("cpLastName") == null ? session.getAttribute("cpLastName") : request.getParameter("cpLastName")%>"/>
            (bygningsansvarlig).</td>
        </tr>
        </table>
        <table align="center" style="margin-bottom: 10px;">
        <td><h2>Bygningen er kategoriseret som</h2></td>
        
            <tr>
                <th style="text-align: center; border: 1px solid #58585a; width:auto ;">Tilstand</th>
                <th style="text-align: center; border: 1px solid #58585a">Beskrivelse af bygningen</th>
                <th style="text-align: center; border: 1px solid #58585a">Funktion af bygningen</th>
                <th style="text-align: center; border: 1px solid #58585a; width:25px;">Tilstandsgrad</th>
            </tr> 


            <%
                Controller cntr = new Controller();
                ArrayList<Condition> conditions = cntr.getConditions();
                int i = 0;
                for (Condition c : conditions) {
            %>
            <tr>

                <td style="text-align: center; border: 1px solid #58585a;"><%="Tilstandsgrad " + c.getCondition()%></td>
                <td style="text-align: center; border: 1px solid #58585a;"><%=c.getDescription()%></td>
                <td style="text-align: center; border: 1px solid #58585a;"><%=c.getFunction()%></td>
                <td style="text-align: center; border: 1px solid #58585a;"><input type="radio" name="condition" value="<%=i%>"/></td>
            </tr>
            <%
                    i++;
                }
            %>
        </table>
        
        <table style="margin-top: 0px; padding-left: 535px; padding-right: 535px; margin-bottom: 10px;">
            <tr>
                <td><input type="submit" name="do_this" value="Gem rapport"></td>
            </tr>
        </table>
        <p style="font-size: 70%; margin-left: 60px; margin-right: 60px; text-align: justify; margin-bottom: 50px;">
            Denne rapport og bygningsgennegang er lavet for at klarlægge umiddelbare
            visuelle problemstillinger. Vores formål er at sikre, at  
            bygningens anvendelse kan opretholdes. Vi udbedre ikke skader som en del af bygningesgennemgangen/rapporten. Gennemgangen  
            af bygningen indeholder ikke fugtmålinger af hele bygningen, men vi kan foretage fugtscanninger enkelte steder i bygningen, hvis vi  
            finder det nødvendigt. Hvis vi finder kritiske områder i bygningen vil vi fremlægge anbefalinger angående yderligere tiltag så som  
            yderligere undersøgelser, reparationer eller bygningsopdateringer. 
            Bemærk at vi skal have adgang til hele bygningen for at kunne udføre fuld gennemgang (dette inkluderer adgang til tag, tagrum,  
            kælder, krybekælder eller andre aflukkede områder). Denne bygningesgennemgang er ikke-destruktiv. Hvis der skal laves destruktive  
            indgreb, skal dette først godkendes af de bygningsansvarlige. Destruktive indgreb er ikke en del af denne rapport eller 
            bygningsgennemgang.
            Den bygningsansvarlige skal udlevere plantegning over bygningen inden bygningsgennemgangen kan foretages.
        </p>
        
    </form>
</body>
</html>
