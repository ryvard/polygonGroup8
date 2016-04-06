<%-- 
    Document   : CreateReport
    Created on : 04-04-2016, 12:28:39
    Author     : Lasse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opret kunde</title>
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
        <form action="Servlet" method="GET">
            <table>
                <tr>
                    <td align="left"><input type="text" name="reportNumber" title="Rapport nr.:" style="color:#888;" 
                                            value="Rapport nr.:" onfocus="inputFocus(this)" onblur="inputBlur(this)"> </td>
                </tr>
            </table>

            <table>
                <td></td>
                <td><h1>Bygningsgennemgang</h1></td>


                <input type="hidden" name="do_this" value="createReport">

                <tr>
                    <td>Navn på bygning</td>
                    <td><input type="text" name="buildningName"></td>
                    <td>Dato</td>
                    <td> <input type="text" name="date"</td>
                </tr>

                <tr>
                    <td>Adresse</td>
                    <td><input type="text" name="adress"></td>
                </tr>

                <tr>
                    <td>Postnr./By</td>
                    <td> <input type="text" name="zipCity"</td>
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
                    <td><input type="text" name="buildYear"</td>
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
                    <td><input type="text" name="squareMeter" value="" readonly="readonly"></td>
                </tr>
                
                <tr>
                    <td>Hvad bruges bygningen til / hvad har bygningen været brugt til</td>
                </tr>

                <tr>
                    <td><input type="text" name="buildingUseability" style="width: 300px;"></td>
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
                    <td><input type="text" name="roof" style="width: 300px;"></td>
                    <td align="right">Billede</td>
                    <td><input type="checkbox" name="roofPicture" value="ON" /></td>
                </tr>

                <tr>
                    <td>Ydervægge</td>
                    <td><input type="text" name="outerwalls" style="width: 300px;"></td>
                    <td align="right">Billede</td>
                    <td><input type="checkbox" name="outerwallsPicture" value="ON" /></td>
                </tr>
            </table>

            <br>
            <div>Konklusion</div>
            <br>

            <table style="border: 1px solid black; border-collapse: collapse;">

                <tr>
                    <th style="text-align: left; border: 1px solid black">Lokale</th>
                    <th style="text-align: left; border: 1px solid black">Anbefaling</th>	
                </tr>

                <tr>
                    <td><input style="width: 75px;" type="text" name="conclusionRoom1"></td>
                    <td><input style="width: 400px;"type="text" name="recommendation1"></td>		
                </tr>

                <tr>
                    <td><input style="width: 75px;" type="text" name="conclusionRoom2"></td>
                    <td><input style="width: 400px;"type="text" name="recommendation2"></td>
                </tr>

                <tr>
                    <td><input style="width: 75px;" type="text" name="conclusionRoom3"></td>
                    <td><input style="width: 400px;"type="text" name="recommendation3"></td>
                </tr>

                <tr>
                    <td><input style="width: 75px;" type="text" name="conclusionRoom4"></td>
                    <td><input style="width: 400px;"type="text" name="recommendation4"></td>
                </tr>

                <tr>
                    <td><input style="width: 75px;" type="text" name="conclusionRoom5"></td>
                    <td><input style="width: 400px;"type="text" name="recommendation5"></td>
                </tr>

                <tr>
                    <td><input style="width: 75px;" type="text" name="conclusionRoom6"></td>
                    <td><input style="width: 400px;"type="text" name="recommendation6"></td>
                </tr>

                <tr>
                    <td><input style="width: 75px;" type="text" name="conclusionRoom7"></td>
                    <td><input style="width: 400px;"type="text" name="recommendation7"></td>
                </tr>

                <tr>
                    <td><input style="width: 75px;" type="text" name="conclusionRoom8"></td>
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


            <input type="submit" value="Gem rapport">
        </form>
    </body>
</html>