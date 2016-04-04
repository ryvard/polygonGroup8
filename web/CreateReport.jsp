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
        <h1>Bygningsgennemgang</h1>
        <div></div>
        <br>
        <form action="Servlet" method="POST">
            <input type="hidden" name="do_this" value="createReport">
            <table>

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

            <table>
                <div style="width:500px;height:100px;border:1px solid #000;">(Indsæt billede af bygning udefra)</div>

                <tr>
                <h4>Generel information om bygningen</h4>
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
                    <h4>Gennemgang af bygning udvendig</h4>
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
            <input type="submit" value="Opret kunde">
        </form>
    </body>
</html>