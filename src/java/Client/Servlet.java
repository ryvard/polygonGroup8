/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Domain.Conclusion;
import Domain.ContactPerson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logic.Controller;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author emmablomsterberg
 */
@WebServlet()
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
                    String street = request.getParameter("street");
                    String streetNo = request.getParameter("streetNo");
                    int zipcode = Integer.parseInt(request.getParameter("zipcode"));
                    String city = request.getParameter("city");
                    int yearOfCon = Integer.parseInt(request.getParameter("yearOfConst"));
                    double squareM = Double.parseDouble(request.getParameter("squareM"));
                    String buildingUse = request.getParameter("buildingUse");
                    int custID = Integer.parseInt(request.getParameter("custID"));
                    int CPID = Integer.parseInt(request.getParameter("CPID"));

// int CPID = ????  First Name, lastname, phone og mail
                    con.createBuilding(buildingName, street, streetNo, city, zipcode, yearOfCon, squareM, buildingUse, custID, CPID);
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

                    forward(request, response, "/CreateReport.jsp");
                    break;

                

                case "Tilføj lokale":

                case "Gem rapport":
                    System.out.println("hejhej servlet");
                    getServletContext().getRequestDispatcher("/index.html").forward(request, response);
                    
                    int buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    System.out.println("b ID --- "+buildingID);
                    
                    String eFirstName = request.getParameter("eFirstName");
                    String eLastName = request.getParameter("eLastName");
                    int eID = ;
                    
                    String cpFirstName = request.getParameter("cpFirstName");
                    String cpLastName = request.getParameter("cpLastName");
                    int cpID = ;
                    
                    String rDate = request.getParameter("date");
                    
                    String bCondition = request.getParameter("condition");
                    System.out.println("condition: "+ bCondition);
                    
//                    String reportNumber = request.getParameter("reportNumber");
//                    String date = request.getParameter("date");
//                    int squareMeter = Integer.parseInt(request.getParameter("squareMeter"));
//                    String buildingUseability = request.getParameter("buildingUseability");
//                    String roof = request.getParameter("roof");
//                    String roofPicture = request.getParameter("roofPicture");
//                    String outerwalls = request.getParameter("outerwalls");
//                    String outerwallsPicture = request.getParameter("outerwallsPicture");
//                    
//                    ArrayList<Conclusion> conclusions = new ArrayList();
//                    for (int i = 0; i < 9; i++)
//                    {
//                        Integer room = Integer.parseInt(request.getParameter("conclusionRoom" + i));
//                        String rec = request.getParameter("recommendation" + i);
//                        if (room == null || rec == "" || rec == null)
//                        {
//                            break;
//                        } else
//                        {
//                            Conclusion conclusion = new Conclusion(room, rec);
//                            conclusions.add(conclusion);
//                        }
//                    }
//                    
//                    String reviewedBy = request.getParameter("reviewedBy");
//                    String collaboration = request.getParameter("collaboration");
//                    int condition = Integer.parseInt(request.getParameter("condition"));
//                    System.out.println("servlet");
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
                    request.setAttribute("cpID", cpID);
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
