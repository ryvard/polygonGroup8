 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package client;

import businesslogic.Building;
import businesslogic.Conclusion;
import businesslogic.ContactPerson;
import businesslogic.Floor;
import businesslogic.Report;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import businesslogic.Controller;
import businesslogic.Customer;
import businesslogic.Damage;
import businesslogic.Employee;
import businesslogic.MoistScan;
import businesslogic.DatasourceLayerException;
import businesslogic.ReviewOf;
import businesslogic.Room;
import datasource.DM_Image;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author emmablomsterberg
 */
@MultipartConfig
@WebServlet()//name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //Hej Lasse
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(true);
            Controller con = new Controller();
            DM_Image imageMapper = new DM_Image();

            String do_this = request.getParameter("do_this");

            switch (do_this)
            {
                case "uploadPicture":
                    Part filePart = request.getPart("picture");
                    
                    long size = filePart.getSize();
                    System.out.println("Test case");
                    InputStream is = filePart.getInputStream();
                    try {
                    //Image img = ImageIO.read(fileContent);
                    imageMapper.uploadPicture(is, size, con.getBuildingFromID(Integer.parseInt(session.getAttribute("buildingDBID").toString())));
                    //imageMapper.uploadPicture(is, size);
                    } catch(DatasourceLayerException ex) {
                        System.out.println("Upload picture " + ex);
                    }
                    break;

                case "createBuilding":
                    try
                    {
                        String buildingName = request.getParameter("buildingName");

//                    String inputFloor = request.getParameter("floor0");
//                    String inputSqm = request.getParameter("squareM0");
//                    System.out.println("TEST: "+inputFloor+" sqm:"+inputSqm);
                        String street = request.getParameter("street");
                        String streetNo = request.getParameter("streetNo");
                        System.out.println("før zipcode");
                        int zipcode = Integer.parseInt(request.getParameter("zipcode"));
                        System.out.println("efter zipcode");
                        String city = request.getParameter("city");
                        int yearOfCon = Integer.parseInt(request.getParameter("yearOfConst"));
                        double squareMTotal = Double.parseDouble(request.getParameter("squareMTotal"));
                        String buildingUse = request.getParameter("buildingUse");
                        int custID = Integer.parseInt(request.getParameter("custID"));
                        int CPID = Integer.parseInt(request.getParameter("CPID"));
                       
                        
                        

                        ArrayList<Floor> arrayFloor = new ArrayList();
                        System.out.println("før addfloor");
                        int numberFloors = Integer.parseInt(request.getParameter("addFloor")) - 1;
                        System.out.println("før for loop");
                        for (int i = 0; i < numberFloors; i++)
                        {

                            int floor = Integer.parseInt(request.getParameter("floor" + i));
                            double squareM = Double.parseDouble(request.getParameter("squareM" + i));
                            System.out.println("floorTEST" + floor);
                            System.out.println("squareMTEST" + squareM);
                            Floor f = new Floor(floor, squareM);

                            arrayFloor.add(f);
                            System.out.println("arrayFloor size" + arrayFloor.size());
                        }

                        System.out.println("efter for loop");

// int CPID = ????  First Name, lastname, phone og mail
                        //con.createBuilding(buildingName, street, streetNo, city, zipcode, yearOfCon, squareMTotal, buildingUse, custID, CPID);
                        Building b = new Building(buildingName, street, streetNo, city, zipcode, yearOfCon, squareMTotal, buildingUse);
                        // hejhej
                        con.createBuilding(b, arrayFloor, custID, CPID);
                        
                        
                        session.setAttribute("buildingDBID", con.getBuildingIDFromDB(buildingName, street));
                        System.out.println("Skal til at request.part");
//                        Part filePart = request.getPart("picture");
//                        long size = filePart.getSize();
//                        System.out.println("Har fået fat i billedet!");
//                        InputStream ins = filePart.getInputStream();
//                        imageMapper.uploadPicture(ins, size);
                        //con.createFloor(arrayFloor, con.getBuildingIDFromDB(buildingName, street));
                        System.out.println("efter metodekald");
                        session.setAttribute("BuildingDBID", con.getBuildingIDFromDB(buildingName, street));
                        System.out.println("servlet");
                        getServletContext().getRequestDispatcher("/UploadPicture.jsp").forward(request, response);
                    } catch (DatasourceLayerException ex)
                    {
                        //gør noget her
                        System.out.println("********** create building failed *************");
                    }
                    break;

                case "createCustomer":
                    try
                    {
                        String name = request.getParameter("custName");
                        String type = request.getParameter("customerType");
                        String streetNameCust = request.getParameter("streetName");
                        String streetNoCust = request.getParameter("streetNo");
                        int zipcodeCust = Integer.parseInt(request.getParameter("zipcode"));
                        

                        con.createCustomer(name, type, streetNameCust, streetNoCust, zipcodeCust);

                        System.out.println("%%%%%%€##€##€€€€€ dsf servlet");
                    } catch (DatasourceLayerException ex)
                    {
                        //Gør noget her
                        System.out.println("***** Create customer FAILED ********");
                    }
                    break;

                case "createReport_BuildingID":
                    try
                    {
                        int newRepID = con.getNewRepID();
                        session.setAttribute("newRepID", newRepID);

                        int ID = Integer.parseInt(request.getParameter("buildingID"));
                        session.setAttribute("ID", ID);
                        
                        String bName = con.getBuildingFromID(ID).getBuildingName();
                        session.setAttribute("bName", bName);

                        String bStreet = con.getBuildingFromID(ID).getStreetName();
                        session.setAttribute("bStreet", bStreet);

                        String bStreetNumb = con.getBuildingFromID(ID).getStreetNumb();
                        session.setAttribute("bStreetNumb", bStreetNumb);

                        String bCity = con.getBuildingFromID(ID).getCity();
                        session.setAttribute("bCity", bCity);

                        int bZip = con.getBuildingFromID(ID).getZipcode();
                        session.setAttribute("bZip", bZip);

                        int bYearOfConst = con.getBuildingFromID(ID).getYearOfConst();
                        session.setAttribute("bYearOfConst", bYearOfConst);

                        double bSquareMeter = con.getBuildingFromID(ID).getSquareMeters();
                        session.setAttribute("bSquareMeter", bSquareMeter);

                        String bUse = con.getBuildingFromID(ID).getBuildingUse();
                        session.setAttribute("bUse", bUse);

                        String bcpFirstName = con.getBuildingFromID(ID).getCp().getCPFirstName();
                        session.setAttribute("cpFirstName", bcpFirstName);
                        String bcpLastName = con.getBuildingFromID(ID).getCp().getCPLastName();
                        session.setAttribute("cpLastName", bcpLastName);

                        ArrayList<Floor> floorList = con.getFloors(ID);
                        session.setAttribute("floorList", floorList);

                        forward(request, response, "/CreateReport.jsp");

                    } catch (DatasourceLayerException ex)
                    {
                        request.setAttribute("dataError", "Forkert bygnings-ID");
                        getServletContext().getRequestDispatcher("/CreateReport1.jsp").forward(request, response);
                    }

                    break;

                case "Gem rapport":
                    try
                    {
                        String fail = "";
                        // Report data
                        int rBuildingID = Integer.parseInt(request.getParameter("buildingID"));
                        String rDate = request.getParameter("date");

                        if (rDate.isEmpty())
                        {
                            fail += "* Dato er tom<br>";
                        }

                        int rCondition = Integer.parseInt(request.getParameter("condition"));
                        Report report = new Report(rDate, rCondition);

                        //Review of building outside
                        ArrayList<ReviewOf> outerReviews = new ArrayList();
                        String rRoof = request.getParameter("roof");
                        String rOuterWall = request.getParameter("outerwalls");

                        if (rRoof.isEmpty() || rOuterWall.isEmpty())
                        {
                            fail += "* Udvendig gennemgang er ikke udfyldt korrekt<br>";
                        }

                        ReviewOf roof = new ReviewOf("Tag", rRoof);
                        ReviewOf outerWalls = new ReviewOf("Yder vægge", rOuterWall);
                        outerReviews.add(roof);
                        outerReviews.add(outerWalls);

                        //Employee 
                        String eFirstName = request.getParameter("eFirstName");
                        String eLastName = request.getParameter("eLastName");

                        if (eFirstName.isEmpty() || eLastName.isEmpty())
                        {
                            fail += "* Udfyld venligst hvem der har foretaget bygningsgennemgangen<br>";
                        }

                        Employee employee = new Employee(eFirstName, eLastName);

                        //Room pages
                        ArrayList<Room> roomList = new ArrayList();
                        ArrayList<Damage> damageList = new ArrayList();
                        ArrayList<ReviewOf> reviewList = new ArrayList();
                        ArrayList<MoistScan> msList = new ArrayList();
                        ArrayList<Conclusion> conclusionList = new ArrayList();

                        int roomPages = Integer.parseInt(request.getParameter("addRoom")) - 1;

                        for (int i = 0; i < roomPages; i++)
                        {
                            int bFloor = Integer.parseInt(request.getParameter("floor" + i));

                            if (request.getParameter("room" + i).isEmpty())
                            {
                                fail += "* Lokalets nummer er ikke angivet på lokale-side: " + (i + 1) + "<br>";
                                request.setAttribute("fail", fail);
                                getServletContext().getRequestDispatcher("/ReportError.jsp").forward(request, response);
                            }

                            int bRoom = Integer.parseInt(request.getParameter("room" + i));
                            Room room = new Room(bFloor, bRoom);
                            roomList.add(room);

                            // save in Damage table
                            String damageInRoom = request.getParameter("damageInRoom" + i);
                            String when = request.getParameter("when" + i);
                            String where = request.getParameter("where" + i);
                            String what = request.getParameter("what" + i);
                            String repaired = request.getParameter("repaired" + i);
                            String damage = null;
                            if(request.getParameter("damage" + i) != null)
                                damage = request.getParameter("damage" + i);
                            else if(request.getParameter("damage" + i) == null && damageInRoom == "Ja")
                            {
                                fail += "Damage";
                                request.setAttribute("fail", fail);
                                getServletContext().getRequestDispatcher("/ReportError.jsp").forward(request, response);
                            }
                            
                            String otherDamage = request.getParameter("otherDamage" + i);

                            if (when.isEmpty() || where.isEmpty() || what.isEmpty() || repaired.isEmpty())
                            {
                                fail += "* Felter under skade og reperationer er ikke udfylt korrekt (<i>udfyld venligts alle felterne</i>)";
                            }
                            Damage rDamage;

                            if (otherDamage.isEmpty())
                            {
                                rDamage = new Damage(bRoom, bFloor, damageInRoom, when, where, what, repaired, damage);
                            } else
                            {
                                rDamage = new Damage(bRoom, bFloor, damageInRoom, when, where, what, repaired, damage, otherDamage);
                            }

                            damageList.add(rDamage);

                            // save in ReviewOf table
                            String wallPart = "Vægge";
                            String wallNote = request.getParameter("wallNote" + i);
                            ReviewOf rWall = new ReviewOf(bRoom, bFloor, wallPart, wallNote);
                            reviewList.add(rWall);

                            String ceilingPart = "Loft";
                            String ceilingNote = request.getParameter("ceilingNote" + i);
                            ReviewOf rCeiling = new ReviewOf(bRoom, bFloor, ceilingPart, ceilingNote);
                            reviewList.add(rCeiling);

                            String floorPart = "Gulv";
                            String floorNote = request.getParameter("floorNote" + i);
                            ReviewOf rFloor = new ReviewOf(bRoom, bFloor, floorPart, floorNote);
                            reviewList.add(rFloor);

                            String windowPart = "Vinduer";
                            String windowNote = request.getParameter("windowNote" + i);
                            ReviewOf rWindow = new ReviewOf(bRoom, bFloor, windowPart, windowNote);
                            reviewList.add(rWindow);

                            String doorPart = "Døre";
                            String doorNote = request.getParameter("doorNote" + i);
                            ReviewOf rDoor = new ReviewOf(bRoom, bFloor, doorPart, doorNote);
                            reviewList.add(rDoor);

                            if (wallNote.isEmpty() || ceilingNote.isEmpty() || floorNote.isEmpty() || windowNote.isEmpty() || doorNote.isEmpty())
                            {
                                fail = "Felterne under 'Gennemgang af...' er ikke udfyldt korrekt<br>";
                            }

                            String otherPart1 = request.getParameter("otherPart1" + i);
                            String otherNote1 = request.getParameter("otherNote1" + i);
                            if (!otherPart1.isEmpty() || !otherNote1.isEmpty())
                            {
                                if(otherPart1.isEmpty() || otherNote1.isEmpty())
                                    fail = "Du skal både angive en bygningsdel og bemærkning under gennemgang af lokale-side "+(i+1)+"<br>";
                                else
                                {
                                ReviewOf rOther1 = new ReviewOf(bRoom, bFloor, otherPart1, otherNote1);
                                reviewList.add(rOther1);
                                }
                            }

                            String otherPart2 = request.getParameter("otherPart2" + i);
                            String otherNote2 = request.getParameter("otherNote2" + i);
                            if (!otherPart2.isEmpty() || !otherNote2.isEmpty())
                            {
                                if(otherPart2.isEmpty() || otherNote2.isEmpty())
                                fail = "\"Du skal både angive en bygningsdel og bemærkning under gennemgang af lokale-side \"+(i+1)+\"<br>\";";   
                                else
                                {
                                ReviewOf rOther2 = new ReviewOf(bRoom, bFloor, otherPart2, otherNote2);
                                reviewList.add(rOther2);}
                            }

                            // save in MoistScan table
                            String msComplete = request.getParameter("moistScanCompletet" + i);
                            String moistScan = request.getParameter("moistScan" + i);
                            String measurePoint = request.getParameter("measurePoint" + i);
                            
                            if(msComplete == "Ja" && moistScan.isEmpty() || msComplete == "Ja" && measurePoint.isEmpty())
                                fail = "Fugt scanning er udført, udfyld venligst en note og målepunkt";
                            
                            MoistScan ms = new MoistScan(bRoom, bFloor, msComplete, moistScan, measurePoint);
                            msList.add(ms);

                            // save in Conclusion table
                            String recommendation = request.getParameter("recommendation" + i);
                            if(recommendation.isEmpty())
                                fail = "Tilføj venligst en anbefaling til lokale-side: "+(i+1)+"<br>";
                            Conclusion conclusion = new Conclusion(bRoom, bFloor, recommendation);
                            conclusionList.add(conclusion);

                        }

                        if (!fail.isEmpty())
                        {
                            request.setAttribute("fail", fail);
                            getServletContext().getRequestDispatcher("/ReportError.jsp").forward(request, response);

                        }
                        con.createReport(rBuildingID, report, outerReviews, employee, roomList, damageList, reviewList, msList, conclusionList);

                        getServletContext().getRequestDispatcher("/index.html").forward(request, response);

                    } catch (NullPointerException ex)
                    {
                        request.setAttribute("Number", "Tjek om du har glemt at krydse af i en af check-boksene");
                        getServletContext().getRequestDispatcher("/ReportError.jsp").forward(request, response);
                    } catch (DatasourceLayerException ex)
                    {
                        request.setAttribute("dataError", "Der skete en fejl, da vi forsøgte at gemme rapporten - <i>"+ex+"</i>");
                        getServletContext().getRequestDispatcher("/ReportError.jsp").forward(request, response);

                    } catch (NumberFormatException ex)
                    {
                        request.setAttribute("numberFormat", "Tjek om du har udfyldt alle felter korrekt");
                        getServletContext().getRequestDispatcher("/ReportError.jsp").forward(request, response);
                    }
                    break;

                case "viewReport":

                    try
                    {
                        System.out.println("servlet hej");
                        int repID = Integer.parseInt(request.getParameter("repID"));

                        session.setAttribute("repID", repID);
                        System.out.println("repID: " + repID);

                        String rDate = con.viewReport(repID).getDate();
                        session.setAttribute("rDate", rDate);

                        //---------
                        String rBName = con.viewReport(repID).getBuilding().getBuildingName();
                        session.setAttribute("rBName", rBName);

                        String rStreet = con.viewReport(repID).getBuilding().getStreetName();
                        session.setAttribute("rStreet", rStreet);

                        String rStreetNumb = con.viewReport(repID).getBuilding().getStreetNumb();
                        session.setAttribute("rStreetNumb", rStreetNumb);

                        String rCity = con.viewReport(repID).getBuilding().getCity();
                        session.setAttribute("rCity", rCity);

                        int rZip = con.viewReport(repID).getBuilding().getZipcode();
                        session.setAttribute("rZip", rZip);

                        int rBuildyear = con.viewReport(repID).getBuilding().getYearOfConst();
                        session.setAttribute("rBuildyear", rBuildyear);

                        double rSquareMeter = con.viewReport(repID).getBuilding().getSquareMeters();
                        session.setAttribute("rSquareMeter", rSquareMeter);

                        String rUse = con.viewReport(repID).getBuilding().getBuildingUse();
                        session.setAttribute("rUse", rUse);
                        //---
                        ArrayList<ReviewOf> outerReviewList = con.viewReport(repID).getOuterReviews();
                        session.setAttribute("outerReviewList", outerReviewList);
                        System.out.println("or" + outerReviewList.size());

                        ArrayList<Room> roomList = con.viewReport(repID).getRoomList();
                        session.setAttribute("roomList", roomList);
                        System.out.println("roomList: " + roomList.size());

                        ArrayList<Damage> damageList = con.viewReport(repID).getDamageList();
                        session.setAttribute("damageList", damageList);

                        ArrayList<ReviewOf> reviewList = con.viewReport(repID).getReviewList();
                        session.setAttribute("reviewList", reviewList);

                        ArrayList<MoistScan> msList = con.viewReport(repID).getMsList();
                        session.setAttribute("msList", msList);

                        //------
                        String rEmployeeFirst = con.viewReport(repID).getEmployee().getFirstName();
                        session.setAttribute("rEmployeeFirst", rEmployeeFirst);

                        String rEmployeeLast = con.viewReport(repID).getEmployee().getLastName();
                        session.setAttribute("rEmployeeLast", rEmployeeLast);

                        String rCpFirstName = con.viewReport(repID).getBuilding().getCp().getCPFirstName();
                        session.setAttribute("rCpFirstName", rCpFirstName);

                        String rCpLastName = con.viewReport(repID).getBuilding().getCp().getCPLastName();
                        session.setAttribute("rCpLastName", rCpLastName);
//                     
                        int condition = con.viewReport(repID).getCondition();
                        session.setAttribute("condition", condition);

                        forward(request, response, "/ViewReport.jsp");

                    } catch (DatasourceLayerException ex)
                    {
                        Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    /*
                    

                     

                     String rRoof
                     = //Metodekald her
                     session.setAttribute("rRoof", rRoof);

                     String rOuterwalls
                     = //Metodekald her
                     session.setAttribute("rOuterwalls", rOuterwalls);

                    
                     String rTilstandsgrad
                     = //Metodekald her
                     session.setAttribute("rTilstandsgrad", rTilstandsgrad);
                     */
                    //Hvordan gør vi med flere lokaler?
                    //Hvordan gør vi med konklusioner og anbefalinger?
                    break;

                case "createContactPerson":
                    try
                    {
                        String cpFirstName = request.getParameter("cpFirstName");
                        String cpLastName = request.getParameter("cpLastName");
                        String cpEmail = request.getParameter("cpEmail");
                        String cpPhone = request.getParameter("cpPhone");
                        int cpID = con.createContactPerson(cpFirstName, cpLastName, cpEmail, cpPhone);
                        session.setAttribute("cpID", cpID);
                        con.createContactPersonInfo(cpFirstName, cpLastName, cpEmail, cpPhone);
                        forward(request, response, "/CreateBuilding.jsp");
                    } catch (DatasourceLayerException ex)
                    {
                        //Gør noget her
                        System.out.println("********* create cp FAILED ***********");
                    }
                    break;

                case "login":
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    boolean login;
                    try {
                    login = con.login(username, password);
                    if (login)
                    {

                        forward(request, response, "/CreateBuilding.jsp");
                    } 
                    } catch (DatasourceLayerException ex) {
                        String fejlmeddelse = "Forkert brugernavn eller kode!!";
                        request.setAttribute("Login2", fejlmeddelse);
                        forward(request, response, "/Login.jsp");
                    }
                    
                    break;

//                case "Upload Picture":
//                    Part filePart = request.getPart("picture");
//                    long size = filePart.getSize();
//                    System.out.println("Test case");
//                    InputStream ins = filePart.getInputStream();
//                    //Image img = ImageIO.read(fileContent);
//                    imageMapper.uploadPicture(ins, size);
//                    break;
//                case "Show Pictures":
//                    try
//                    {
//                        int buildingID = Integer.parseInt(request.getParameter("buildingID"));
//                        InputStream is = imageMapper.getImageAsStream(buildingID);
//
//                    } catch (Exception ex)
//                    {
//                        ex.printStackTrace();
//                    }
//                    break;
//                case "Upload Picture":
//                    Part filePart = request.getPart("picture");
//                    long size = filePart.getSize();
//                    System.out.println("Test case");
//                    InputStream ins = filePart.getInputStream();
//                    //Image img = ImageIO.read(fileContent);
//                    imageMapper.uploadPicture(ins, size);
//                    break;
//                case "Show Pictures":
//                    try
//                    {
//                        int buildingID = Integer.parseInt(request.getParameter("buildingID"));
//                        InputStream is = imageMapper.getImageAsStream(buildingID);
//
//                    } catch (Exception ex)
//                    {
//                        ex.printStackTrace();
//                    }
//                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

    private void forward(HttpServletRequest req, HttpServletResponse res, String path) throws IOException, ServletException
    {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(path);
        rd.forward(req, res);
    }
}
