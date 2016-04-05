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
        <form action="Servlet" method="POST">
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
                    <td>Bygningsareal i m²(hver etage tælles separat)</td>
                </tr>
                <tr>
                    <td><input type="text" name="squareMeter"></td>
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
                    <td><input style="width: 75px;" type="text" value=""></td>
                    <td><input style="width: 400px;"type="text" value=""></td>		
                </tr>
                
                <tr>
                    <td><input style="width: 75px;" type="text" value=""></td>
                    <td><input style="width: 400px;"type="text" value=""></td>
                </tr>

            </table>

            <input type="submit" value="Gem rapport">
        </form>
    </body>
</html>