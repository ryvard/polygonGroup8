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
import businesslogic.Damage;
import businesslogic.Employee;
import businesslogic.MoistScan;
import businesslogic.ReportErrorException;
import businesslogic.ReviewOf;
import businesslogic.Room;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author emmablomsterberg
 */
@WebServlet() //name = "Servlet", urlPatterns = {"/Servlet"}
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(true);
            Controller con = new Controller();

            String do_this = request.getParameter("do_this");

            switch (do_this)
            {

                case "createBuilding":
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
                    Building b = new Building(buildingName, street, streetNo, city, zipcode, yearOfCon, squareMTotal, buildingUse, custID, CPID);
                    con.createBuilding(b,arrayFloor);
                    
                    //con.createFloor(arrayFloor, con.getBuildingIDFromDB(buildingName, street));
                    System.out.println("efter metodekald");

                    System.out.println("servlet");
                    break;

                case "createCustomer":
                    String name = request.getParameter("custName");
                    String type = request.getParameter("customerType");
                    String streetNameCust = request.getParameter("streetName");
                    String streetNoCust = request.getParameter("streetNo");
                    int zipcodeCust = Integer.parseInt(request.getParameter("zipcode"));
                    String contactName = request.getParameter("contactName");
                    String phone = request.getParameter("phone");
                    String mail = request.getParameter("mail");

                    con.createCustomer(name, type, streetNameCust, streetNoCust, zipcodeCust, contactName, phone, mail);
                    System.out.println("%%%%%%€##€##€€€€€ dsf servlet");
                    break;

                case "createBuilding_BuildingID":
                    try{
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

                    /* RET DET HER 
                    //con.getBuildingFromID(ID).getCp().getCPFirstName();
                    
                    int bCPID = con.getBuildingFromID(ID).getCPID();

                    String bcpFirstName = con.getCPFromCPID(bCPID).getCPFirstName();
                    session.setAttribute("cpFirstName", bcpFirstName);

                    String bcpLastName = con.getCPFromCPID(bCPID).getCPLastName();
                    session.setAttribute("cpLastName", bcpLastName);
                    */
                    ArrayList<Floor> floorList = con.getFloors(ID);
                    session.setAttribute("floorList", floorList);
                    
                    
                    forward(request, response, "/CreateReport.jsp");
                    }catch(ReportErrorException ex)
                    {
                        request.setAttribute("ReportError", "Report: " + ex);
                        getServletContext().getRequestDispatcher("/ReportError.jsp").forward(request, response);   
                    }
                    
                    break;
                    
                case "Gem rapport":
                    try
                    {
                        // save in report table 
                        int rBuildingID = Integer.parseInt(request.getParameter("buildingID"));

                        // Report data
                        String rDate = request.getParameter("date");
                        int rCondition = Integer.parseInt(request.getParameter("condition"));

                        Report report = new Report(rDate, rCondition);
                        
                        //Review of building outside
                        ArrayList<ReviewOf> outerReviews = new ArrayList();
                        
                        ReviewOf roof = new ReviewOf("Loft",request.getParameter("roof"));
                        outerReviews.add(roof);
                        
                        ReviewOf outerWalls = new ReviewOf("yder vægge",request.getParameter("outerwalls"));
                        outerReviews.add(outerWalls);
                        
                        //Employee 
                        String eFirstName = request.getParameter("eFirstName");
                        String eLastName = request.getParameter("eLastName");
                        
                        Employee employee = new Employee(eFirstName, eLastName);
                        //int eID = con.getEID(eFirstName, eLastName);
                        
                       
                        
                        // ^ virker hertil
                        //con.createReport(rBuildingID, report, outerReviews, employee);
                       
                        ArrayList<Room> roomList = new ArrayList();
                        ArrayList<Damage> damageList = new ArrayList();
                        ArrayList<ReviewOf> reviewList = new ArrayList();
                        ArrayList<MoistScan> msList = new ArrayList();
                        ArrayList<Conclusion> conclusionList = new ArrayList();
                        
                        //--------Pages-----------
                        int roomPages = Integer.parseInt(request.getParameter("addRoom")) - 1;
                        System.out.println("roomPages" + roomPages);
                        
                        for (int i = 0; i < roomPages; i++)
                        {
                            // room number
                            int bFloor = Integer.parseInt(request.getParameter("floor"+i));
                            int bRoom = Integer.parseInt(request.getParameter("room" + i));
                            Room room = new Room(bFloor, bRoom);
                            roomList.add(room);

                            // save in Damage table
                            String damageInRoom = request.getParameter("damageInRoom" + i);
                            String when = request.getParameter("when" + i);
                            String where = request.getParameter("where" + i);
                            String what = request.getParameter("what" + i);
                            String repaired = request.getParameter("repaired" + i);
                            String damage = request.getParameter("damage" + i);
                            String otherDamage = request.getParameter("otherDamage" + i);
                            
                            Damage rDamage = new Damage(bRoom, damageInRoom, when, where, what, repaired, damage, otherDamage);
                            damageList.add(rDamage);

                            // save in ReviewOf table
                            String wallPart = "Vægge";
                            String wallNote = request.getParameter("wallNote" + i);
                            ReviewOf rWall = new ReviewOf(bRoom, wallPart, wallNote);
                            reviewList.add(rWall);

                            String ceilingPart = "Loft";
                            String ceilingNote = request.getParameter("ceilingNote" + i);
                            ReviewOf rCeiling = new ReviewOf(bRoom, ceilingPart, ceilingNote);
                            reviewList.add(rCeiling);

                            String floorPart = "Gulv";
                            String floorNote = request.getParameter("floorNote" + i);
                            ReviewOf rFloor = new ReviewOf(bRoom, floorPart, floorNote);
                            reviewList.add(rFloor);

                            String windowPart = "Vinduer";
                            String windowNote = request.getParameter("windowNote" + i);
                            ReviewOf rWindow = new ReviewOf(bRoom, windowPart, windowNote);
                            reviewList.add(rWindow);

                            String doorPart = "Døre";
                            String doorNote = request.getParameter("doorNote" + i);
                            ReviewOf rDoor = new ReviewOf(bRoom, doorPart, doorNote);
                            reviewList.add(rDoor);

                            String otherPart1 = request.getParameter("otherPart1" + i);
                            String otherNote1 = request.getParameter("otherNote1" + i);
                            ReviewOf rOther1 = new ReviewOf(bRoom, otherPart1, otherNote1);
                            reviewList.add(rOther1);

                            String otherPart2 = request.getParameter("otherPart2" + i);
                            String otherNote2 = request.getParameter("otherNote2" + i);
                            ReviewOf rOther2 = new ReviewOf(bRoom, otherPart2, otherNote2);
                            reviewList.add(rOther2);

                            // save in MoistScan table
                            String msComplete = request.getParameter("moistScanCompletet" + i);
                            String moistScan = request.getParameter("moistScan" + i);
                            String measurePoint = request.getParameter("measurePoint" + i);
                            MoistScan ms = new MoistScan(bRoom, msComplete, moistScan, measurePoint);
                            msList.add(ms);
                            
                            // save in Conclusion table
                            String recommendation = request.getParameter("recommendation" +i);
                            System.out.println("recommendation: "+ recommendation);
                            Conclusion conclusion = new Conclusion(bRoom, recommendation);
                            conclusionList.add(conclusion);

                        }
                        
                        con.createReport(rBuildingID, report, outerReviews, employee, roomList, damageList, reviewList, msList, conclusionList);
                        
                        getServletContext().getRequestDispatcher("/index.html").forward(request, response);

                    }catch (ReportErrorException ex)
                    {
                        request.setAttribute("ReportError", "Report: " + ex);
                        getServletContext().getRequestDispatcher("/ReportError.jsp").forward(request, response);

                    }catch(NumberFormatException ex)
                    {
                        request.setAttribute("Number", "Number: " + ex);
                        getServletContext().getRequestDispatcher("/ReportError.jsp").forward(request, response);
                    }
                    break;

                /*
                 case "ViewReport":
                 int repID = Integer.parseInt(request.getParameter("repID"));
                 session.setAttribute("reportNumber", repID);

                 String rBName
                 = //Metodekald her
                 session.setAttribute("rBName", rBName);

                 int rDate
                 = //Metodekald her 
                 session.setAttribute("rDate", rDate);

                 String rStreet
                 = //Metodekald her 
                 session.setAttribute("rStreet", rStreet);

                 String rStreetNumb
                 = //Metodekald her
                 session.setAttribute("rStreetNumb", rStreetNumb);

                 String rCity
                 = //Metodekald her
                 session.setAttribute("rCity", rCity);

                 int rZip
                 = //Metodekald her
                 session.setAttribute("rZip", rZip);

                 int rBuildyear
                 = //Metodekald her
                 session.setAttribute("rBuildyear", rBuildyear);

                 int rSquareMeter
                 = //Metodekald her
                 session.setAttribute("rSquareMeter", rSquareMeter);

                 String rUse
                 = //Metodekald her
                 session.setAttribute("rUse", rUse);

                 String rRoof
                 = //Metodekald her
                 session.setAttribute("rRoof", rRoof);

                 String rOuterwalls
                 = //Metodekald her
                 session.setAttribute("rOuterwalls", rOuterwalls);
                    
                 String rReviewedBy
                 = //Metodekald her
                 session.setAttribute("rReviewedBy", rReviewedBy);
                    
                 String rCollaboration
                 = //Metodekald her
                 session.setAttribute("rCollaboration", rCollaboration);
                    
                 String rTilstandsgrad
                 = //Metodekald her
                 session.setAttribute("rTilstandsgrad", rTilstandsgrad);

                 //Hvordan gør vi med flere lokaler?
                 //Hvordan gør vi med konklusioner og anbefalinger?
                 forward(request, response, "/ViewReport.jsp");
                 break;
                 */
                    
                case "createContactPerson":
                    String cpFirstName = request.getParameter("cpFirstName");
                    String cpLastName = request.getParameter("cpLastName");
                    String cpEmail = request.getParameter("cpEmail");
                    String cpPhone = request.getParameter("cpPhone");
                    int cpID = con.createContactPerson(cpFirstName, cpLastName, cpEmail, cpPhone);
                    session.setAttribute("cpID", cpID);
                    con.createContactPersonInfo(cpFirstName, cpLastName, cpEmail, cpPhone);
                    forward(request, response, "/CreateBuilding.jsp");
                    break;

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
