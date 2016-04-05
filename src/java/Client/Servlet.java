/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logic.Controller;

/**
 *
 * @author emmablomsterberg
 */
public class Servlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Controller con = new Controller();

            String do_this = request.getParameter("do_this");

            switch (do_this) {

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
                    // int CPID = ????  First Name, lastname, phone og mail
                    con.createBuilding(buildingName,street, streetNo, city, zipcode, yearOfCon, squareM, buildingUse, custID);
                    System.out.println("servlet");
                    break;
                case "createCustomer":
                    String type = request.getParameter("customerType");
                    String streetNameCust = request.getParameter("streetName");
                    String streetNoCust = request.getParameter("streetNo");
                    int zipcodeCust = Integer.parseInt(request.getParameter("zipcode"));
                    String contactName = request.getParameter("contactName");
                    String phone = request.getParameter("phone");
                    String mail = request.getParameter("mail");
                    con.createCustomer(type, streetNameCust, streetNoCust, zipcodeCust, contactName, phone, mail);
                    System.out.println("servlet");
                    break;
                case "createReport":
                    String reportNumber = request.getParameter("reportNumber");
                    String date = request.getParameter("date");
                    int squareMeter = Integer.parseInt(request.getParameter("squareMeter"));
                    String buildingUseability = request.getParameter("buildingUseability");
                    String roof = request.getParameter("roof");
                    String roofPicture = request.getParameter("roofPicture");
                    String outerwalls = request.getParameter("outerwalls");
                    String outerwallsPicture = request.getParameter("outerwallsPicture");
                    String conclusion = request.getParameter("conclusion"+"i");
                    String reviewedBy = request.getParameter("reviewedBy");
                    String collaboration = request.getParameter("collaboration");
                    int condition = Integer.parseInt(request.getParameter("condition"));
                    con.createReport(reportNumber, date, squareMeter, buildingUseability, roof, roofPicture, 
                            outerwalls, outerwallsPicture, conclusion, reviewedBy, collaboration, condition);
                    System.out.println("servlet");
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
            throws ServletException, IOException {
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
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
